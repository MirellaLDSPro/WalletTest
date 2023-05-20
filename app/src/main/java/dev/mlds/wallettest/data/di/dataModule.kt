package dev.mlds.wallettest.data.di

import dev.mlds.wallettest.data.repo.CardRepositoryImpl
import dev.mlds.wallettest.domain.repositories.CardRepository
import org.koin.dsl.module

val dataModule = module {
    single<CardRepository> { CardRepositoryImpl() }
}