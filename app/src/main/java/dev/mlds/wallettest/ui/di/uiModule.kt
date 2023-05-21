package dev.mlds.wallettest.ui.di

import dev.mlds.wallettest.ui.cardList.CardListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel {
        CardListViewModel(get())
    }
}