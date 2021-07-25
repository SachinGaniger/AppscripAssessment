package com.sachin.appscripassessment.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sachin.appscripassessment.R
import com.sachin.appscripassessment.databinding.FragmentNameBinding
import com.sachin.appscripassessment.databinding.FragmentSingleChoiceBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingleChoiceFragment : Fragment(R.layout.fragment_single_choice) {

    lateinit var binding: FragmentSingleChoiceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSingleChoiceBinding.inflate(inflater, container, false)

        arguments?.getString("name")?.let { Log.i("nameValue ", it) }

        val name = arguments?.getString("name")



        binding.apply {

//            var selectedValue: RadioButton =  radioGroup.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
            var selectedValue: RadioButton?= null

            radioGroup.setOnCheckedChangeListener { radioGroup, i ->
                selectedValue = radioGroup.findViewById(i) as RadioButton
            }

            btSingleChoice.setOnClickListener {
                //pass selected ans to next screen
                val bundle = bundleOf("name" to name, "singleChoice" to  selectedValue?.text)
                //navigate to next screen
                findNavController().navigate(R.id.action_singleChoiceFragment_to_multiChoiceFragment, bundle)

            }

        }

        return binding.root
    }
}