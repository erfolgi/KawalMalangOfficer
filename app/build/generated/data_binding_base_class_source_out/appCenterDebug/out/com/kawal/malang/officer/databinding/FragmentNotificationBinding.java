// Generated by view binder compiler. Do not edit!
package com.kawal.malang.officer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kawal.malang.officer.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentNotificationBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EmptyNotificationBinding emptyNotification;

  @NonNull
  public final RecyclerView rvNotification;

  @NonNull
  public final SwipeRefreshLayout swipeRefreshNotification;

  private FragmentNotificationBinding(@NonNull LinearLayout rootView,
      @NonNull EmptyNotificationBinding emptyNotification, @NonNull RecyclerView rvNotification,
      @NonNull SwipeRefreshLayout swipeRefreshNotification) {
    this.rootView = rootView;
    this.emptyNotification = emptyNotification;
    this.rvNotification = rvNotification;
    this.swipeRefreshNotification = swipeRefreshNotification;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentNotificationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_notification, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentNotificationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.empty_notification;
      View emptyNotification = ViewBindings.findChildViewById(rootView, id);
      if (emptyNotification == null) {
        break missingId;
      }
      EmptyNotificationBinding binding_emptyNotification = EmptyNotificationBinding.bind(emptyNotification);

      id = R.id.rv_notification;
      RecyclerView rvNotification = ViewBindings.findChildViewById(rootView, id);
      if (rvNotification == null) {
        break missingId;
      }

      id = R.id.swipe_refresh_notification;
      SwipeRefreshLayout swipeRefreshNotification = ViewBindings.findChildViewById(rootView, id);
      if (swipeRefreshNotification == null) {
        break missingId;
      }

      return new FragmentNotificationBinding((LinearLayout) rootView, binding_emptyNotification,
          rvNotification, swipeRefreshNotification);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
