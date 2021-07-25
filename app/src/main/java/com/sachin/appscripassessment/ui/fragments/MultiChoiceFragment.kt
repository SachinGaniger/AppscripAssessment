package com.sachin.appscripassessment.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sachin.appscripassessment.R
import com.sachin.appscripassessment.databinding.FragmentMultipleChoiceBinding
import com.sachin.appscripassessment.databinding.FragmentNameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MultiChoiceFragment : Fragment(R.layout.fragment_multiple_choice) {

    lateinit var binding: FragmentMultipleChoiceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMultipleChoiceBinding.inflate(inflater, container, false)

        var selectedChoices = StringBuilder()

        ///answers from previous screens
        val name = arguments?.getString("name")
        val singleChoice = arguments?.getString("singleChoice")

//        arguments?.getString("singleChoice")?.let { Log.i("singleChoice ", it) }

        binding.apply {

            ///check condition of checked item
            white.setOnCheckedChangeListener{_, isCheck->

                if (isCheck){
                    ///build string if checked with comma separated
                    selectedChoices.append(white.text).append(", ")
                }

            }

            yellow.setOnCheckedChangeListener{_, isCheck->

                if (isCheck){
                    selectedChoices.append(yellow.text).append(", ")
                }

            }

            orange.setOnCheckedChangeListener{_, isCheck->

                if (isCheck){
                    selectedChoices.append(orange.text).append(", ")
                }

            }

            green.setOnCheckedChangeListener{_, isCheck->

                if (isCheck){
                    selectedChoices.append(green.text).append(", ")
                }

            }

            btNext.setOnClickListener {
                ////pass previous selected answers to next screen
                val bundle = bundleOf("name" to name, "singleChoice" to  singleChoice, "multiChoice" to selectedChoices.toString())
                ////navigate to next screen
                findNavController().navigate(R.id.action_multiChoiceFragment_to_summaryFragment, bundle)
            }

        }

        return binding.root
    }
}