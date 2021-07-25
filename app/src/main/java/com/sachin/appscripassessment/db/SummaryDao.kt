package com.sachin.appscripassessment.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SummaryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSummary(summary: Summary)

    @Query("SELECT * FROM summary_table")
    suspend fun getAllSummary(): List<Summary>

}