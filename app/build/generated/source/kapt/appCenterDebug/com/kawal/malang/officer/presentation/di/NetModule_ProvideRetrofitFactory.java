// Generated by Dagger (https://dagger.dev).
package com.kawal.malang.officer.presentation.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final NetModule module;

  public NetModule_ProvideRetrofitFactory(NetModule module) {
    this.module = module;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(module);
  }

  public static NetModule_ProvideRetrofitFactory create(NetModule module) {
    return new NetModule_ProvideRetrofitFactory(module);
  }

  public static Retrofit provideRetrofit(NetModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideRetrofit());
  }
}
