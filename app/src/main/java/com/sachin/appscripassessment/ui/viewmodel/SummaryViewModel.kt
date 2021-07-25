package com.sachin.appscripassessment.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sachin.appscripassessment.db.Summary
import com.sachin.appscripassessment.repositories.SummaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SummaryViewModel @Inject constructor(
    private val repository: SummaryRepository
): ViewModel() {
    private val summaries : MutableLiveData<List<Summary>> = MutableLiveData()

    fun insertSummary(summary: Summary) = viewModelScope
        .launch {
            repository.insertSummary(summary)
        }

    fun getAllSummaryList() = viewModelScope
        .launch {
            summaries.postValue(repository.getAllSummaries())
        }

    fun getSummaryData(): LiveData<List<Summary>>{
        return summaries
    }


}