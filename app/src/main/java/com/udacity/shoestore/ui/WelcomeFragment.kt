package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomefragmentBinding


class WelcomeFragment : Fragment() {

private lateinit var binding:WelcomefragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= WelcomefragmentBinding.inflate(layoutInflater,container,false)
        context ?: return binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvNavigate.setOnClickListener {
            val action=WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
            findNavController().navigate(action)
        }
    }


}