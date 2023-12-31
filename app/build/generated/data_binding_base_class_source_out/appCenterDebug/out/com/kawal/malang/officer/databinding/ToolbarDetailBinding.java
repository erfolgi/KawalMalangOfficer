// Generated by view binder compiler. Do not edit!
package com.kawal.malang.officer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kawal.malang.officer.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ToolbarDetailBinding implements ViewBinding {
  @NonNull
  private final Toolbar rootView;

  @NonNull
  public final ImageButton tbArchive;

  @NonNull
  public final ImageButton tbBack;

  @NonNull
  public final TextView tbKategori;

  @NonNull
  public final ImageButton tbMore;

  @NonNull
  public final TextView tbTitle;

  private ToolbarDetailBinding(@NonNull Toolbar rootView, @NonNull ImageButton tbArchive,
      @NonNull ImageButton tbBack, @NonNull TextView tbKategori, @NonNull ImageButton tbMore,
      @NonNull TextView tbTitle) {
    this.rootView = rootView;
    this.tbArchive = tbArchive;
    this.tbBack = tbBack;
    this.tbKategori = tbKategori;
    this.tbMore = tbMore;
    this.tbTitle = tbTitle;
  }

  @Override
  @NonNull
  public Toolbar getRoot() {
    return rootView;
  }

  @NonNull
  public static ToolbarDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ToolbarDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.toolbar_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ToolbarDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tbArchive;
      ImageButton tbArchive = ViewBindings.findChildViewById(rootView, id);
      if (tbArchive == null) {
        break missingId;
      }

      id = R.id.tbBack;
      ImageButton tbBack = ViewBindings.findChildViewById(rootView, id);
      if (tbBack == null) {
        break missingId;
      }

      id = R.id.tbKategori;
      TextView tbKategori = ViewBindings.findChildViewById(rootView, id);
      if (tbKategori == null) {
        break missingId;
      }

      id = R.id.tbMore;
      ImageButton tbMore = ViewBindings.findChildViewById(rootView, id);
      if (tbMore == null) {
        break missingId;
      }

      id = R.id.tbTitle;
      TextView tbTitle = ViewBindings.findChildViewById(rootView, id);
      if (tbTitle == null) {
        break missingId;
      }

      return new ToolbarDetailBinding((Toolbar) rootView, tbArchive, tbBack, tbKategori, tbMore,
          tbTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
