// Generated by view binder compiler. Do not edit!
package com.kawal.malang.officer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.kawal.malang.officer.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class BsConfirmBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageButton btClose;

  @NonNull
  public final MaterialButton btNegative;

  @NonNull
  public final MaterialButton btPositive;

  @NonNull
  public final ImageView icon;

  @NonNull
  public final TextView txCaption;

  @NonNull
  public final TextView txTitle;

  private BsConfirmBinding(@NonNull LinearLayout rootView, @NonNull ImageButton btClose,
      @NonNull MaterialButton btNegative, @NonNull MaterialButton btPositive,
      @NonNull ImageView icon, @NonNull TextView txCaption, @NonNull TextView txTitle) {
    this.rootView = rootView;
    this.btClose = btClose;
    this.btNegative = btNegative;
    this.btPositive = btPositive;
    this.icon = icon;
    this.txCaption = txCaption;
    this.txTitle = txTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static BsConfirmBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BsConfirmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.bs_confirm, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BsConfirmBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btClose;
      ImageButton btClose = ViewBindings.findChildViewById(rootView, id);
      if (btClose == null) {
        break missingId;
      }

      id = R.id.btNegative;
      MaterialButton btNegative = ViewBindings.findChildViewById(rootView, id);
      if (btNegative == null) {
        break missingId;
      }

      id = R.id.btPositive;
      MaterialButton btPositive = ViewBindings.findChildViewById(rootView, id);
      if (btPositive == null) {
        break missingId;
      }

      id = R.id.icon;
      ImageView icon = ViewBindings.findChildViewById(rootView, id);
      if (icon == null) {
        break missingId;
      }

      id = R.id.txCaption;
      TextView txCaption = ViewBindings.findChildViewById(rootView, id);
      if (txCaption == null) {
        break missingId;
      }

      id = R.id.txTitle;
      TextView txTitle = ViewBindings.findChildViewById(rootView, id);
      if (txTitle == null) {
        break missingId;
      }

      return new BsConfirmBinding((LinearLayout) rootView, btClose, btNegative, btPositive, icon,
          txCaption, txTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
