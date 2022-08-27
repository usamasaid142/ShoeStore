package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailfragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewmodel


class ShoeDetailFragment : Fragment() {

    private lateinit var binding:ShoeDetailfragmentBinding
    lateinit var viewModel: ShoeViewmodel
    var shoe:Shoe?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding= ShoeDetailfragmentBinding.inflate(layoutInflater,container,false)
        context ?: return binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as MainActivity).viewmodel
        initbutton()
    }


    fun initbutton(){
        binding.btnCancel.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        binding.btnSave.setOnClickListener {
            getshoeinfodetail()

        }
    }

    fun getshoeinfodetail(){
        val list= mutableListOf<Shoe>()
        val size=binding.etSize.text.toString()

        if(!binding.etShoeName.text.toString().isNullOrEmpty()&& !size.isNullOrEmpty()&&
        !binding.etCompany.text.toString().isNullOrEmpty()&&!binding.etDesc.text.toString().isNullOrEmpty()){
            val d: Double = size.toDouble()
            val shoe=Shoe(binding.etShoeName.text.toString(),d,
                binding.etCompany.text.toString(),binding.etDesc.text.toString())
            binding.shoe=shoe
             list.add(shoe)
           viewModel.shoes.postValue(list)
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }else{
            Toast.makeText(requireContext(),"all fields required",Toast.LENGTH_LONG).show()
        }

    }




}