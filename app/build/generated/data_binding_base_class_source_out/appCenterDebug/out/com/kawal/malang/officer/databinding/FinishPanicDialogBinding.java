// Generated by view binder compiler. Do not edit!
package com.kawal.malang.officer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import com.kawal.malang.officer.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FinishPanicDialogBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView btnFinish;

  @NonNull
  public final LinearLayout btnUpload;

  @NonNull
  public final TextInputLayout etDescription;

  @NonNull
  public final ImageView ivReport;

  private FinishPanicDialogBinding(@NonNull LinearLayout rootView, @NonNull TextView btnFinish,
      @NonNull LinearLayout btnUpload, @NonNull TextInputLayout etDescription,
      @NonNull ImageView ivReport) {
    this.rootView = rootView;
    this.btnFinish = btnFinish;
    this.btnUpload = btnUpload;
    this.etDescription = etDescription;
    this.ivReport = ivReport;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FinishPanicDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FinishPanicDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.finish_panic_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FinishPanicDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_finish;
      TextView btnFinish = ViewBindings.findChildViewById(rootView, id);
      if (btnFinish == null) {
        break missingId;
      }

      id = R.id.btn_upload;
      LinearLayout btnUpload = ViewBindings.findChildViewById(rootView, id);
      if (btnUpload == null) {
        break missingId;
      }

      id = R.id.et_description;
      TextInputLayout etDescription = ViewBindings.findChildViewById(rootView, id);
      if (etDescription == null) {
        break missingId;
      }

      id = R.id.iv_report;
      ImageView ivReport = ViewBindings.findChildViewById(rootView, id);
      if (ivReport == null) {
        break missingId;
      }

      return new FinishPanicDialogBinding((LinearLayout) rootView, btnFinish, btnUpload,
          etDescription, ivReport);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}