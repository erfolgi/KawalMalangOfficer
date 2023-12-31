// Generated by view binder compiler. Do not edit!
package com.kawal.malang.officer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import com.kawal.malang.officer.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class OfficerListBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView btnConfirm;

  @NonNull
  public final TextInputLayout etSearch;

  @NonNull
  public final RecyclerView rvPatrolOfficer;

  @NonNull
  public final TextView tvLoading;

  private OfficerListBinding(@NonNull LinearLayout rootView, @NonNull TextView btnConfirm,
      @NonNull TextInputLayout etSearch, @NonNull RecyclerView rvPatrolOfficer,
      @NonNull TextView tvLoading) {
    this.rootView = rootView;
    this.btnConfirm = btnConfirm;
    this.etSearch = etSearch;
    this.rvPatrolOfficer = rvPatrolOfficer;
    this.tvLoading = tvLoading;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static OfficerListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static OfficerListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.officer_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static OfficerListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_confirm;
      TextView btnConfirm = ViewBindings.findChildViewById(rootView, id);
      if (btnConfirm == null) {
        break missingId;
      }

      id = R.id.et_search;
      TextInputLayout etSearch = ViewBindings.findChildViewById(rootView, id);
      if (etSearch == null) {
        break missingId;
      }

      id = R.id.rv_patrol_officer;
      RecyclerView rvPatrolOfficer = ViewBindings.findChildViewById(rootView, id);
      if (rvPatrolOfficer == null) {
        break missingId;
      }

      id = R.id.tv_loading;
      TextView tvLoading = ViewBindings.findChildViewById(rootView, id);
      if (tvLoading == null) {
        break missingId;
      }

      return new OfficerListBinding((LinearLayout) rootView, btnConfirm, etSearch, rvPatrolOfficer,
          tvLoading);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
