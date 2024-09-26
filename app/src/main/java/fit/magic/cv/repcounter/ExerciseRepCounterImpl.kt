// Copyright (c) 2024 Magic Tech Ltd

package fit.magic.cv.repcounter

import com.google.mediapipe.tasks.components.containers.NormalizedLandmark
import fit.magic.cv.PoseLandmarkerHelper
import com.google.mediapipe.tasks.vision.poselandmarker.PoseLandmarkerResult

import kotlin.math.sqrt
import kotlin.math.acos
import kotlin.math.PI

class ExerciseRepCounterImpl : ExerciseRepCounter() {

    // Variables to track the current state of the exercise
    private var previousKneeAngle = 0.0
    private var lungeInProgress = false
    private var movementProgress = 0.0

    // Thresholds for determining when a rep starts and ends
    private val standingThreshold = 160.0 // Angle when standing
    private val lungeThreshold = 90.0 // Angle when in a lunge position

    private val progressTracking = mutableListOf<Double>()

    // This method processes the result bundle, which includes the landmark data
    override fun setResults(resultBundle: PoseLandmarkerHelper.ResultBundle) {
        // Iterate through each PoseLandmarkerResult in the results list
        for (poseResult: PoseLandmarkerResult in resultBundle.results) {
            // Access the 2D landmarks from the PoseLandmarkerResult
            val multiPoseLandmarks: List<List<NormalizedLandmark>> = poseResult.landmarks()

            if (multiPoseLandmarks.isNotEmpty()) {
                // Use the first detected person's landmarks for simplicity
                val poseLandmarks: List<NormalizedLandmark> = multiPoseLandmarks[0]

                // Process pose data to detect exercise movements
                val leftKneeAngle = calculateKneeAngle(poseLandmarks, left = true)
                val rightKneeAngle = calculateKneeAngle(poseLandmarks, left = false)

                // Determine which knee is leading (using the greater bend angle)
                val activeKneeAngle = if (leftKneeAngle < rightKneeAngle) leftKneeAngle else rightKneeAngle

                // Update the movement progress based on the current knee angle
                updateMovementProgress(activeKneeAngle)

                // Detect when the user starts and completes a lunge rep
                if (!lungeInProgress && activeKneeAngle < lungeThreshold) {
                    // User starts a lunge
                    lungeInProgress = true
                } else if (lungeInProgress && activeKneeAngle > standingThreshold) {
                    // Lunge completed, increment the rep count
                    incrementRepCount()
                    lungeInProgress = false
                }

                // Send progress updates to the UI
                sendProgressUpdate(movementProgress.toFloat())

                // Optionally send feedback (e.g., "Good form!" or "Keep going!")
                sendFeedbackMessage("Keep going!")
            }
        }
    }

    // Calculate the knee angle using hip, knee, and ankle landmarks
    private fun calculateKneeAngle(poseLandmarks: List<NormalizedLandmark>, left: Boolean): Double {
        val hipIndex = if (left) 23 else 24 // Use MediaPipe predefined indices
        val kneeIndex = if (left) 25 else 26
        val ankleIndex = if (left) 27 else 28

        val hipLandmark = poseLandmarks[hipIndex]
        val kneeLandmark = poseLandmarks[kneeIndex]
        val ankleLandmark = poseLandmarks[ankleIndex]

        return calculateAngleBetweenPoints(hipLandmark, kneeLandmark, ankleLandmark)
    }

    // Helper function to calculate the angle between three points (hip, knee, ankle)
    private fun calculateAngleBetweenPoints(
        point1: NormalizedLandmark,
        point2: NormalizedLandmark,
        point3: NormalizedLandmark
    ): Double {
        // Convert Float to Double using .toDouble()
        val vector1 = Pair(point1.x().toDouble() - point2.x().toDouble(), point1.y().toDouble() - point2.y().toDouble())
        val vector2 = Pair(point3.x().toDouble() - point2.x().toDouble(), point3.y().toDouble() - point2.y().toDouble())

        val dotProduct = vector1.first * vector2.first + vector1.second * vector2.second
        val magnitude1 = sqrt(vector1.first * vector1.first + vector1.second * vector1.second)
        val magnitude2 = sqrt(vector2.first * vector2.first + vector2.second * vector2.second)

        val cosineOfAngle = dotProduct / (magnitude1 * magnitude2)

        return acos(cosineOfAngle) * (180 / PI)
    }

    // Update the movement progress as the user performs a lunge
    private fun updateMovementProgress(kneeAngle: Double) {
        val progressValue = 1.0 - (kneeAngle - lungeThreshold) / (standingThreshold - lungeThreshold)
        progressTracking.add(progressValue.coerceIn(0.0, 1.0))

        // Keep track of the last 5 frames to smooth the progress updates
        if (progressTracking.size > 5) {
            progressTracking.removeAt(0)
        }

        // Calculate the average progress to smooth fluctuations
        movementProgress = progressTracking.average()
    }
}
