package com.enestigli.diyetkolikcase.di

import android.content.Context
import androidx.room.Room
import com.enestigli.diyetkolikcase.data.locale.ExchangeDao
import com.enestigli.diyetkolikcase.data.locale.ExchangeDatabase
import com.enestigli.diyetkolikcase.data.remote.ExchangeApi
import com.enestigli.diyetkolikcase.data.repository.ExchangeRepositoryImpl
import com.enestigli.diyetkolikcase.domain.repository.ExchangeRepository
import com.enestigli.diyetkolikcase.util.Constants
import com.enestigli.diyetkolikcase.util.SharedPrefHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    /*-------------------------- Exchange  --------------------------*/

    @Provides
    @Singleton
    fun provideExchangeApi() : ExchangeApi {

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExchangeApi::class.java)
    }

    @Singleton
    @Provides
    fun provideExchangeDao(database: ExchangeDatabase) = database.exchangeDao

    @Singleton
    @Provides
    fun provideExchangeDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ExchangeDatabase::class.java,
        "Exchange.db")
        .build()


    @Singleton
    @Provides
    fun provideExchangeRepository(dao : ExchangeDao,api: ExchangeApi) : ExchangeRepository {

        return ExchangeRepositoryImpl(dao,api)
    }


    @Singleton
    @Provides
    fun provideSharedPrefHelper(@ApplicationContext context:Context)  = SharedPrefHelper(context)

}