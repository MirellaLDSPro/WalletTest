package dev.mlds.wallettest.ui.di

import dev.mlds.wallettest.ui.create.CreateCardViewModel
import dev.mlds.wallettest.ui.list.CardListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel {
        CardListViewModel(get())
    }

    viewModel {
        CreateCardViewModel(get())
    }
}