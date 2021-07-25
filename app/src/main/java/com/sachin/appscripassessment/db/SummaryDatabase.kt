package com.sachin.appscripassessment.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Summary::class],
    version = 1
)
abstract class SummaryDatabase : RoomDatabase(){

    abstract fun getDao(): SummaryDao

}