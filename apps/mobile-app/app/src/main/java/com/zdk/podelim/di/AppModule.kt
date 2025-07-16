package com.zdk.podelim.di

import com.zdk.podelim.data.remote.ApiService
import com.zdk.podelim.data.repository.DebtRepository
import com.zdk.podelim.data.repository.EventRepository
import com.zdk.podelim.data.repository.ExpenseRepository
import com.zdk.podelim.data.repository.MockDebtRepository
import com.zdk.podelim.data.repository.MockEventRepository
import com.zdk.podelim.data.repository.MockParticipantRepository
import com.zdk.podelim.data.repository.MockExpenseRepository
import com.zdk.podelim.data.repository.ParticipantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://mock.api.podelim.com/")
            .addConverterFactory(Json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideEventRepository(apiService: ApiService): EventRepository {
        return MockEventRepository()

        //return EventRepositoryImpl(apiService)
    }
    @Provides
    @Singleton
    fun provideParticipantRepository(apiService: ApiService): ParticipantRepository {
        return MockParticipantRepository()

        //return ParticipantRepositoryImpl(apiService)
    }
    @Provides
    @Singleton
    fun provideExpenseRepository(apiService: ApiService): ExpenseRepository {
        return MockExpenseRepository()

        //return ExpenseRepositoryImpl(apiService)
    }
    @Provides
    @Singleton
    fun provideDebtRepository(apiService: ApiService): DebtRepository {
        return MockDebtRepository()

        //return DebtRepositoryImpl(apiService)
    }
}