// Generated by Dagger (https://dagger.dev).
package com.kawal.malang.officer.presentation.account.edit.editCar;

import com.kawal.malang.officer.presentation.viewmodels.account.AccountViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class EditCarActivity_MembersInjector implements MembersInjector<EditCarActivity> {
  private final Provider<AccountViewModelFactory> factoryProvider;

  public EditCarActivity_MembersInjector(Provider<AccountViewModelFactory> factoryProvider) {
    this.factoryProvider = factoryProvider;
  }

  public static MembersInjector<EditCarActivity> create(
      Provider<AccountViewModelFactory> factoryProvider) {
    return new EditCarActivity_MembersInjector(factoryProvider);
  }

  @Override
  public void injectMembers(EditCarActivity instance) {
    injectFactory(instance, factoryProvider.get());
  }

  @InjectedFieldSignature("com.kawal.malang.officer.presentation.account.edit.editCar.EditCarActivity.factory")
  public static void injectFactory(EditCarActivity instance, AccountViewModelFactory factory) {
    instance.factory = factory;
  }
}
