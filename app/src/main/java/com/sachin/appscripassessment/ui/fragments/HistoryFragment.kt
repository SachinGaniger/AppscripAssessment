package com.sachin.appscripassessment.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sachin.appscripassessment.R
import com.sachin.appscripassessment.databinding.*
import com.sachin.appscripassessment.db.Summary
import com.sachin.appscripassessment.ui.adapters.HistoryAdapter
import com.sachin.appscripassessment.ui.viewmodel.SummaryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.job

@AndroidEntryPoint
class HistoryFragment : Fragment(R.layout.fragment_history) {

    lateinit var binding: FragmentHistoryBinding
    private val viewModel: SummaryViewModel by viewModels()
    private var summaryAdapter: HistoryAdapter?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHistoryBinding.inflate(inflater, container, false)

        ////get all data from room db in background
        viewModel.getAllSummaryList()

        ////observe the data list
        viewModel.getSummaryData().observe(viewLifecycleOwner, Observer {summary->
            summaryAdapter = HistoryAdapter(summary as ArrayList<Summary>)

            binding.rvHistory.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = summaryAdapter
            }

        })

        return binding.root
    }
}