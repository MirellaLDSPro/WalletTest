package dev.mlds.wallettest.domain.di

import dev.mlds.wallettest.domain.usecases.GetCardsUseCase
import dev.mlds.wallettest.domain.usecases.PostCardUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetCardsUseCase(get()) }
    single { PostCardUseCase(get()) }
}