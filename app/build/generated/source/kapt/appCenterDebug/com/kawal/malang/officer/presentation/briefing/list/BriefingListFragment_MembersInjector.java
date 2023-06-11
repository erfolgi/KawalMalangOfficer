// Generated by Dagger (https://dagger.dev).
package com.kawal.malang.officer.presentation.briefing.list;

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
public final class BriefingListFragment_MembersInjector implements MembersInjector<BriefingListFragment> {
  private final Provider<BriefingListAdapter> adapterProvider;

  private final Provider<ReportCategoryAdapter> reportCategoryAdapterProvider;

  private final Provider<BriefingViewModelFactory> viewModelFactoryProvider;

  public BriefingListFragment_MembersInjector(Provider<BriefingListAdapter> adapterProvider,
      Provider<ReportCategoryAdapter> reportCategoryAdapterProvider,
      Provider<BriefingViewModelFactory> viewModelFactoryProvider) {
    this.adapterProvider = adapterProvider;
    this.reportCategoryAdapterProvider = reportCategoryAdapterProvider;
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<BriefingListFragment> create(
      Provider<BriefingListAdapter> adapterProvider,
      Provider<ReportCategoryAdapter> reportCategoryAdapterProvider,
      Provider<BriefingViewModelFactory> viewModelFactoryProvider) {
    return new BriefingListFragment_MembersInjector(adapterProvider, reportCategoryAdapterProvider, viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(BriefingListFragment instance) {
    injectAdapter(instance, adapterProvider.get());
    injectReportCategoryAdapter(instance, reportCategoryAdapterProvider.get());
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  @InjectedFieldSignature("com.kawal.malang.officer.presentation.briefing.list.BriefingListFragment.adapter")
  public static void injectAdapter(BriefingListFragment instance, BriefingListAdapter adapter) {
    instance.adapter = adapter;
  }

  @InjectedFieldSignature("com.kawal.malang.officer.presentation.briefing.list.BriefingListFragment.reportCategoryAdapter")
  public static void injectReportCategoryAdapter(BriefingListFragment instance,
      ReportCategoryAdapter reportCategoryAdapter) {
    instance.reportCategoryAdapter = reportCategoryAdapter;
  }

  @InjectedFieldSignature("com.kawal.malang.officer.presentation.briefing.list.BriefingListFragment.viewModelFactory")
  public static void injectViewModelFactory(BriefingListFragment instance,
      BriefingViewModelFactory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
