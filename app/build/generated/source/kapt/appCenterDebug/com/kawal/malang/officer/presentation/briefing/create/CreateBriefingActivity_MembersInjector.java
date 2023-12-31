// Generated by Dagger (https://dagger.dev).
package com.kawal.malang.officer.presentation.briefing.create;

import com.kawal.malang.officer.presentation.adapter.ReportCategoryAdapter;
import com.kawal.malang.officer.presentation.viewmodels.briefing.BriefingViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CreateBriefingActivity_MembersInjector implements MembersInjector<CreateBriefingActivity> {
  private final Provider<BriefingViewModelFactory> factoryProvider;

  private final Provider<ReportCategoryAdapter> reportCategoryAdapterProvider;

  public CreateBriefingActivity_MembersInjector(Provider<BriefingViewModelFactory> factoryProvider,
      Provider<ReportCategoryAdapter> reportCategoryAdapterProvider) {
    this.factoryProvider = factoryProvider;
    this.reportCategoryAdapterProvider = reportCategoryAdapterProvider;
  }

  public static MembersInjector<CreateBriefingActivity> create(
      Provider<BriefingViewModelFactory> factoryProvider,
      Provider<ReportCategoryAdapter> reportCategoryAdapterProvider) {
    return new CreateBriefingActivity_MembersInjector(factoryProvider, reportCategoryAdapterProvider);
  }

  @Override
  public void injectMembers(CreateBriefingActivity instance) {
    injectFactory(instance, factoryProvider.get());
    injectReportCategoryAdapter(instance, reportCategoryAdapterProvider.get());
  }

  @InjectedFieldSignature("com.kawal.malang.officer.presentation.briefing.create.CreateBriefingActivity.factory")
  public static void injectFactory(CreateBriefingActivity instance,
      BriefingViewModelFactory factory) {
    instance.factory = factory;
  }

  @InjectedFieldSignature("com.kawal.malang.officer.presentation.briefing.create.CreateBriefingActivity.reportCategoryAdapter")
  public static void injectReportCategoryAdapter(CreateBriefingActivity instance,
      ReportCategoryAdapter reportCategoryAdapter) {
    instance.reportCategoryAdapter = reportCategoryAdapter;
  }
}
