package dev.mlds.wallettest.data.di

import dev.mlds.wallettest.data.repo.CardRepositoryImpl
import dev.mlds.wallettest.domain.repositories.CardRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<CardRepository> { CardRepositoryImpl(androidContext(), get()) }
}

//val networkModule = module {
//    single { RetrofitConfig.retrofitModule }
//}