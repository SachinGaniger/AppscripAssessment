package com.sachin.appscripassessment.di

import android.content.Context
import androidx.room.Room
import com.sachin.appscripassessment.db.SummaryDatabase
import com.sachin.appscripassessment.utils.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SummaryModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext app:Context
    ) = Room.databaseBuilder(
        app, SummaryDatabase::class.java, DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideDao(summaryDatabase: SummaryDatabase) = summaryDatabase.getDao()

}