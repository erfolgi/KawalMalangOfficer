// Generated by Dagger (https://dagger.dev).
package com.kawal.malang.officer.presentation.account.edit.editMember;

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
public final class EditMemberActivity_MembersInjector implements MembersInjector<EditMemberActivity> {
  private final Provider<AccountViewModelFactory> factoryProvider;

  public EditMemberActivity_MembersInjector(Provider<AccountViewModelFactory> factoryProvider) {
    this.factoryProvider = factoryProvider;
  }

  public static MembersInjector<EditMemberActivity> create(
      Provider<AccountViewModelFactory> factoryProvider) {
    return new EditMemberActivity_MembersInjector(factoryProvider);
  }

  @Override
  public void injectMembers(EditMemberActivity instance) {
    injectFactory(instance, factoryProvider.get());
  }

  @InjectedFieldSignature("com.kawal.malang.officer.presentation.account.edit.editMember.EditMemberActivity.factory")
  public static void injectFactory(EditMemberActivity instance, AccountViewModelFactory factory) {
    instance.factory = factory;
  }
}