package dev.mlds.wallettest.data.di

import dev.mlds.wallettest.data.api.CardService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {
    private const val BASE_URL = "https://wallet-test-backend.vercel.app"

    private fun config() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CardService::class.java)

    val retrofitModule = module {
        single {
            config()
        }
    }
}