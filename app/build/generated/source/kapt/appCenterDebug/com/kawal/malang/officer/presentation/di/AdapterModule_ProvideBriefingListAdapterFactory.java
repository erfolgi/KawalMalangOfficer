// Generated by Dagger (https://dagger.dev).
package com.kawal.malang.officer.presentation.di;

import com.kawal.malang.officer.presentation.briefing.list.BriefingListAdapter;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AdapterModule_ProvideBriefingListAdapterFactory implements Factory<BriefingListAdapter> {
  private final AdapterModule module;

  public AdapterModule_ProvideBriefingListAdapterFactory(AdapterModule module) {
    this.module = module;
  }

  @Override
  public BriefingListAdapter get() {
    return provideBriefingListAdapter(module);
  }

  public static AdapterModule_ProvideBriefingListAdapterFactory create(AdapterModule module) {
    return new AdapterModule_ProvideBriefingListAdapterFactory(module);
  }

  public static BriefingListAdapter provideBriefingListAdapter(AdapterModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideBriefingListAdapter());
  }
}