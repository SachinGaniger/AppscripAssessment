package com.sachin.appscripassessment.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sachin.appscripassessment.R
import com.sachin.appscripassessment.databinding.FragmentMultipleChoiceBinding
import com.sachin.appscripassessment.databinding.FragmentNameBinding
import com.sachin.appscripassessment.databinding.FragmentSplashBinding
import com.sachin.appscripassessment.databinding.FragmentSummeryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSplashBinding.inflate(inflater, container, false)

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_nameFragment)
        }, 3000)

        return binding.root
    }
}