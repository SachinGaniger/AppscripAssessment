package com.sachin.appscripassessment.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sachin.appscripassessment.R
import com.sachin.appscripassessment.databinding.FragmentNameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NameFragment : Fragment(R.layout.fragment_name) {

    lateinit var binding: FragmentNameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        ////bind the view reference
        binding = FragmentNameBinding.inflate(inflater, container, false)


        binding.apply {

            btNext.setOnClickListener {
                //pass selected ans to next screen
                val bundle = bundleOf("name" to etName.text.toString())
                //navigate to next screen
                findNavController().navigate(R.id.action_nameFragment_to_singleChoiceFragment, bundle)
            }

        }

        return binding.root
    }
}