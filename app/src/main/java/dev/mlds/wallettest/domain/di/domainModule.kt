package dev.mlds.wallettest.domain.di

import dev.mlds.wallettest.domain.usecases.GetCardsUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetCardsUseCase(get()) }
}