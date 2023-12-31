// Generated by view binder compiler. Do not edit!
package com.kawal.malang.officer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kawal.malang.officer.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class NotificationItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final CircleImageView ivCategory;

  @NonNull
  public final TextView tvDate;

  @NonNull
  public final TextView tvDescription;

  @NonNull
  public final TextView tvTitle;

  private NotificationItemBinding(@NonNull LinearLayout rootView,
      @NonNull CircleImageView ivCategory, @NonNull TextView tvDate,
      @NonNull TextView tvDescription, @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.ivCategory = ivCategory;
    this.tvDate = tvDate;
    this.tvDescription = tvDescription;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static NotificationItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static NotificationItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.notification_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static NotificationItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_category;
      CircleImageView ivCategory = ViewBindings.findChildViewById(rootView, id);
      if (ivCategory == null) {
        break missingId;
      }

      id = R.id.tv_date;
      TextView tvDate = ViewBindings.findChildViewById(rootView, id);
      if (tvDate == null) {
        break missingId;
      }

      id = R.id.tv_description;
      TextView tvDescription = ViewBindings.findChildViewById(rootView, id);
      if (tvDescription == null) {
        break missingId;
      }

      id = R.id.tv_title;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      return new NotificationItemBinding((LinearLayout) rootView, ivCategory, tvDate, tvDescription,
          tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
