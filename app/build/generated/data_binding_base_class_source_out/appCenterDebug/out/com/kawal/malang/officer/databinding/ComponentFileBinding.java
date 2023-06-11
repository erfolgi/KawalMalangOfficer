// Generated by view binder compiler. Do not edit!
package com.kawal.malang.officer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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

public final class ComponentFileBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView add;

  @NonNull
  public final ImageButton delete;

  @NonNull
  public final LinearLayout ll;

  @NonNull
  public final LinearLayout llFile;

  @NonNull
  public final TextView name;

  private ComponentFileBinding(@NonNull LinearLayout rootView, @NonNull TextView add,
      @NonNull ImageButton delete, @NonNull LinearLayout ll, @NonNull LinearLayout llFile,
      @NonNull TextView name) {
    this.rootView = rootView;
    this.add = add;
    this.delete = delete;
    this.ll = ll;
    this.llFile = llFile;
    this.name = name;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ComponentFileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ComponentFileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.component_file, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ComponentFileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add;
      TextView add = ViewBindings.findChildViewById(rootView, id);
      if (add == null) {
        break missingId;
      }

      id = R.id.delete;
      ImageButton delete = ViewBindings.findChildViewById(rootView, id);
      if (delete == null) {
        break missingId;
      }

      LinearLayout ll = (LinearLayout) rootView;

      id = R.id.llFile;
      LinearLayout llFile = ViewBindings.findChildViewById(rootView, id);
      if (llFile == null) {
        break missingId;
      }

      id = R.id.name;
      TextView name = ViewBindings.findChildViewById(rootView, id);
      if (name == null) {
        break missingId;
      }

      return new ComponentFileBinding((LinearLayout) rootView, add, delete, ll, llFile, name);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}