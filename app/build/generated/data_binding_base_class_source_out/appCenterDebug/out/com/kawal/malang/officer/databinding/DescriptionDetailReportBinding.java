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
import com.kawal.malang.officer.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import org.osmdroid.views.MapView;

public final class DescriptionDetailReportBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout actionDesc;

  @NonNull
  public final LinearLayout descriptionDetail;

  @NonNull
  public final ImageView ivActionDesc;

  @NonNull
  public final MapView mapView;

  @NonNull
  public final TextView tvActionDesc;

  @NonNull
  public final TextView tvDescription;

  @NonNull
  public final TextView tvPlace;

  private DescriptionDetailReportBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout actionDesc, @NonNull LinearLayout descriptionDetail,
      @NonNull ImageView ivActionDesc, @NonNull MapView mapView, @NonNull TextView tvActionDesc,
      @NonNull TextView tvDescription, @NonNull TextView tvPlace) {
    this.rootView = rootView;
    this.actionDesc = actionDesc;
    this.descriptionDetail = descriptionDetail;
    this.ivActionDesc = ivActionDesc;
    this.mapView = mapView;
    this.tvActionDesc = tvActionDesc;
    this.tvDescription = tvDescription;
    this.tvPlace = tvPlace;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DescriptionDetailReportBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DescriptionDetailReportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.description_detail_report, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DescriptionDetailReportBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.action_desc;
      LinearLayout actionDesc = ViewBindings.findChildViewById(rootView, id);
      if (actionDesc == null) {
        break missingId;
      }

      LinearLayout descriptionDetail = (LinearLayout) rootView;

      id = R.id.iv_action_desc;
      ImageView ivActionDesc = ViewBindings.findChildViewById(rootView, id);
      if (ivActionDesc == null) {
        break missingId;
      }

      id = R.id.map_view;
      MapView mapView = ViewBindings.findChildViewById(rootView, id);
      if (mapView == null) {
        break missingId;
      }

      id = R.id.tv_action_desc;
      TextView tvActionDesc = ViewBindings.findChildViewById(rootView, id);
      if (tvActionDesc == null) {
        break missingId;
      }

      id = R.id.tv_description;
      TextView tvDescription = ViewBindings.findChildViewById(rootView, id);
      if (tvDescription == null) {
        break missingId;
      }

      id = R.id.tv_place;
      TextView tvPlace = ViewBindings.findChildViewById(rootView, id);
      if (tvPlace == null) {
        break missingId;
      }

      return new DescriptionDetailReportBinding((LinearLayout) rootView, actionDesc,
          descriptionDetail, ivActionDesc, mapView, tvActionDesc, tvDescription, tvPlace);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
