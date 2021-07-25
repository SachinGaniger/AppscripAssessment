package com.sachin.appscripassessment.repositories

import com.sachin.appscripassessment.db.Summary
import com.sachin.appscripassessment.db.SummaryDao
import javax.inject.Inject

class SummaryRepository @Inject constructor(
    private val summaryDao: SummaryDao
) {

    suspend fun insertSummary(summary: Summary) = summaryDao.insertSummary(summary)

    suspend fun getAllSummaries() = summaryDao.getAllSummary()

}