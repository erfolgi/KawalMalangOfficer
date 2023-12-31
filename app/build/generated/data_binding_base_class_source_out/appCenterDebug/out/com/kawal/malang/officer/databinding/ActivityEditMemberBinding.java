// Generated by view binder compiler. Do not edit!
package com.kawal.malang.officer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.kawal.malang.officer.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityEditMemberBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ToolbarDetailBinding appbar;

  @NonNull
  public final MaterialButton btnSave;

  @NonNull
  public final TextInputLayout etName;

  @NonNull
  public final TextInputLayout etNip;

  @NonNull
  public final TextInputLayout etPhone;

  @NonNull
  public final TextInputLayout etRank;

  private ActivityEditMemberBinding(@NonNull LinearLayout rootView,
      @NonNull ToolbarDetailBinding appbar, @NonNull MaterialButton btnSave,
      @NonNull TextInputLayout etName, @NonNull TextInputLayout etNip,
      @NonNull TextInputLayout etPhone, @NonNull TextInputLayout etRank) {
    this.rootView = rootView;
    this.appbar = appbar;
    this.btnSave = btnSave;
    this.etName = etName;
    this.etNip = etNip;
    this.etPhone = etPhone;
    this.etRank = etRank;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityEditMemberBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityEditMemberBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_edit_member, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityEditMemberBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appbar;
      View appbar = ViewBindings.findChildViewById(rootView, id);
      if (appbar == null) {
        break missingId;
      }
      ToolbarDetailBinding binding_appbar = ToolbarDetailBinding.bind(appbar);

      id = R.id.btn_save;
      MaterialButton btnSave = ViewBindings.findChildViewById(rootView, id);
      if (btnSave == null) {
        break missingId;
      }

      id = R.id.et_name;
      TextInputLayout etName = ViewBindings.findChildViewById(rootView, id);
      if (etName == null) {
        break missingId;
      }

      id = R.id.et_nip;
      TextInputLayout etNip = ViewBindings.findChildViewById(rootView, id);
      if (etNip == null) {
        break missingId;
      }

      id = R.id.et_phone;
      TextInputLayout etPhone = ViewBindings.findChildViewById(rootView, id);
      if (etPhone == null) {
        break missingId;
      }

      id = R.id.et_rank;
      TextInputLayout etRank = ViewBindings.findChildViewById(rootView, id);
      if (etRank == null) {
        break missingId;
      }

      return new ActivityEditMemberBinding((LinearLayout) rootView, binding_appbar, btnSave, etName,
          etNip, etPhone, etRank);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
