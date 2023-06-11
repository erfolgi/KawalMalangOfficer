// Generated by Dagger (https://dagger.dev).
package com.kawal.malang.officer.presentation.di;

import com.kawal.malang.officer.presentation.notification.NotificationAdapter;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AdapterModule_ProvideNotificationAdapterFactory implements Factory<NotificationAdapter> {
  private final AdapterModule module;

  public AdapterModule_ProvideNotificationAdapterFactory(AdapterModule module) {
    this.module = module;
  }

  @Override
  public NotificationAdapter get() {
    return provideNotificationAdapter(module);
  }

  public static AdapterModule_ProvideNotificationAdapterFactory create(AdapterModule module) {
    return new AdapterModule_ProvideNotificationAdapterFactory(module);
  }

  public static NotificationAdapter provideNotificationAdapter(AdapterModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideNotificationAdapter());
  }
}