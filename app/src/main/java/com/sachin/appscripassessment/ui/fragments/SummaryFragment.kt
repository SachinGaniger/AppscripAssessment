package com.sachin.appscripassessment.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sachin.appscripassessment.R
import com.sachin.appscripassessment.databinding.FragmentMultipleChoiceBinding
import com.sachin.appscripassessment.databinding.FragmentNameBinding
import com.sachin.appscripassessment.databinding.FragmentSummeryBinding
import com.sachin.appscripassessment.db.Summary
import com.sachin.appscripassessment.ui.viewmodel.SummaryViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class SummaryFragment : Fragment(R.layout.fragment_summery) {

    lateinit var binding: FragmentSummeryBinding
    val viewModel: SummaryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSummeryBinding.inflate(inflater, container, false)

        arguments?.getString("name")?.let { Log.i("name ", it) }
        arguments?.getString("singleChoice")?.let { Log.i("singleChoice ", it) }
        arguments?.getString("multiChoice")?.let { Log.i("multiChoice ", it) }

        ////save all the previously passed ans data
        val name = "Hello, ${arguments?.getString("name")}"
        val singleChoice = arguments?.getString("singleChoice")
        val multiChoice = arguments?.getString("multiChoice")

        binding.apply {
            tvName.text = name
            tvCricketerAns.text = singleChoice
            tvNationalFlagAns.text = multiChoice

            ////set date format
            val date = Calendar.getInstance().time
            val formatter = SimpleDateFormat.getDateTimeInstance()
            val dateString = formatter.format(date)

            val summary = Summary(name, singleChoice, multiChoice, dateString)

            btSummeryFinish.setOnClickListener {
                ///insert data into database
                viewModel.insertSummary(summary)
//                findNavController().popBackStack(R.id.nameFragment, false)
                findNavController().navigate(R.id.action_summaryFragment_to_nameFragment)
            }

            btSummeryHistory.setOnClickListener {
                findNavController().navigate(R.id.action_summaryFragment_to_historyFragment)
            }
        }

        return binding.root
    }
}