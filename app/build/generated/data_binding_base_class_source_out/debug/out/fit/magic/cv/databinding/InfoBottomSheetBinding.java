// Generated by view binder compiler. Do not edit!
package fit.magic.cv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import fit.magic.cv.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class InfoBottomSheetBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final NestedScrollView bottomSheetLayout;

  @NonNull
  public final AppCompatImageButton detectionThresholdMinus;

  @NonNull
  public final AppCompatImageButton detectionThresholdPlus;

  @NonNull
  public final TextView detectionThresholdValue;

  @NonNull
  public final TextView inferenceTimeLabel;

  @NonNull
  public final TextView inferenceTimeVal;

  @NonNull
  public final AppCompatImageButton presenceThresholdMinus;

  @NonNull
  public final AppCompatImageButton presenceThresholdPlus;

  @NonNull
  public final TextView presenceThresholdValue;

  @NonNull
  public final AppCompatSpinner spinnerDelegate;

  @NonNull
  public final AppCompatSpinner spinnerModel;

  @NonNull
  public final AppCompatImageButton trackingThresholdMinus;

  @NonNull
  public final AppCompatImageButton trackingThresholdPlus;

  @NonNull
  public final TextView trackingThresholdValue;

  private InfoBottomSheetBinding(@NonNull NestedScrollView rootView,
      @NonNull NestedScrollView bottomSheetLayout,
      @NonNull AppCompatImageButton detectionThresholdMinus,
      @NonNull AppCompatImageButton detectionThresholdPlus,
      @NonNull TextView detectionThresholdValue, @NonNull TextView inferenceTimeLabel,
      @NonNull TextView inferenceTimeVal, @NonNull AppCompatImageButton presenceThresholdMinus,
      @NonNull AppCompatImageButton presenceThresholdPlus, @NonNull TextView presenceThresholdValue,
      @NonNull AppCompatSpinner spinnerDelegate, @NonNull AppCompatSpinner spinnerModel,
      @NonNull AppCompatImageButton trackingThresholdMinus,
      @NonNull AppCompatImageButton trackingThresholdPlus,
      @NonNull TextView trackingThresholdValue) {
    this.rootView = rootView;
    this.bottomSheetLayout = bottomSheetLayout;
    this.detectionThresholdMinus = detectionThresholdMinus;
    this.detectionThresholdPlus = detectionThresholdPlus;
    this.detectionThresholdValue = detectionThresholdValue;
    this.inferenceTimeLabel = inferenceTimeLabel;
    this.inferenceTimeVal = inferenceTimeVal;
    this.presenceThresholdMinus = presenceThresholdMinus;
    this.presenceThresholdPlus = presenceThresholdPlus;
    this.presenceThresholdValue = presenceThresholdValue;
    this.spinnerDelegate = spinnerDelegate;
    this.spinnerModel = spinnerModel;
    this.trackingThresholdMinus = trackingThresholdMinus;
    this.trackingThresholdPlus = trackingThresholdPlus;
    this.trackingThresholdValue = trackingThresholdValue;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static InfoBottomSheetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static InfoBottomSheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.info_bottom_sheet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static InfoBottomSheetBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      NestedScrollView bottomSheetLayout = (NestedScrollView) rootView;

      id = R.id.detection_threshold_minus;
      AppCompatImageButton detectionThresholdMinus = ViewBindings.findChildViewById(rootView, id);
      if (detectionThresholdMinus == null) {
        break missingId;
      }

      id = R.id.detection_threshold_plus;
      AppCompatImageButton detectionThresholdPlus = ViewBindings.findChildViewById(rootView, id);
      if (detectionThresholdPlus == null) {
        break missingId;
      }

      id = R.id.detection_threshold_value;
      TextView detectionThresholdValue = ViewBindings.findChildViewById(rootView, id);
      if (detectionThresholdValue == null) {
        break missingId;
      }

      id = R.id.inference_time_label;
      TextView inferenceTimeLabel = ViewBindings.findChildViewById(rootView, id);
      if (inferenceTimeLabel == null) {
        break missingId;
      }

      id = R.id.inference_time_val;
      TextView inferenceTimeVal = ViewBindings.findChildViewById(rootView, id);
      if (inferenceTimeVal == null) {
        break missingId;
      }

      id = R.id.presence_threshold_minus;
      AppCompatImageButton presenceThresholdMinus = ViewBindings.findChildViewById(rootView, id);
      if (presenceThresholdMinus == null) {
        break missingId;
      }

      id = R.id.presence_threshold_plus;
      AppCompatImageButton presenceThresholdPlus = ViewBindings.findChildViewById(rootView, id);
      if (presenceThresholdPlus == null) {
        break missingId;
      }

      id = R.id.presence_threshold_value;
      TextView presenceThresholdValue = ViewBindings.findChildViewById(rootView, id);
      if (presenceThresholdValue == null) {
        break missingId;
      }

      id = R.id.spinner_delegate;
      AppCompatSpinner spinnerDelegate = ViewBindings.findChildViewById(rootView, id);
      if (spinnerDelegate == null) {
        break missingId;
      }

      id = R.id.spinner_model;
      AppCompatSpinner spinnerModel = ViewBindings.findChildViewById(rootView, id);
      if (spinnerModel == null) {
        break missingId;
      }

      id = R.id.tracking_threshold_minus;
      AppCompatImageButton trackingThresholdMinus = ViewBindings.findChildViewById(rootView, id);
      if (trackingThresholdMinus == null) {
        break missingId;
      }

      id = R.id.tracking_threshold_plus;
      AppCompatImageButton trackingThresholdPlus = ViewBindings.findChildViewById(rootView, id);
      if (trackingThresholdPlus == null) {
        break missingId;
      }

      id = R.id.tracking_threshold_value;
      TextView trackingThresholdValue = ViewBindings.findChildViewById(rootView, id);
      if (trackingThresholdValue == null) {
        break missingId;
      }

      return new InfoBottomSheetBinding((NestedScrollView) rootView, bottomSheetLayout,
          detectionThresholdMinus, detectionThresholdPlus, detectionThresholdValue,
          inferenceTimeLabel, inferenceTimeVal, presenceThresholdMinus, presenceThresholdPlus,
          presenceThresholdValue, spinnerDelegate, spinnerModel, trackingThresholdMinus,
          trackingThresholdPlus, trackingThresholdValue);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
