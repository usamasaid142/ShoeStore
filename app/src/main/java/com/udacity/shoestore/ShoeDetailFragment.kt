package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeDetailfragmentBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {

    private lateinit var binding:ShoeDetailfragmentBinding
    var shoe:Shoe?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= ShoeDetailfragmentBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initbutton()

    }


    fun initbutton(){
        binding.btnCancel.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        binding.btnSave.setOnClickListener {
            getshoeinfodetail()
            val action=ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(
                shoe)
            findNavController().navigate(action)
        }
    }

    fun getshoeinfodetail(){
        val size=binding.etSize.text.toString()
        val d: Double = size.toDouble()
        if(binding.etShoeName.text.toString().isNullOrEmpty()&& d!=null&&
        binding.etCompany.text.toString().isNullOrEmpty()&&binding.etDesc.text.toString().isNullOrEmpty()){
            shoe=Shoe(binding.etShoeName.text.toString(),d,
                binding.etCompany.text.toString(),binding.etDesc.text.toString())

        }else{
            Toast.makeText(requireContext(),"all fields required",Toast.LENGTH_LONG).show()
        }

    }


}