package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeDetailfragmentBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {

    private lateinit var binding:ShoeDetailfragmentBinding
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
        getshoeinfodetail()
    }


    fun initbutton(){
        binding.btnCancel.setOnClickListener {

            //findNavController().navigate()
        }
        binding.btnSave.setOnClickListener {

           // val action =

        }
    }

    fun getshoeinfodetail():List<Shoe>{
       val shoelist= mutableListOf<Shoe>()
        if(binding.etShoeName.text.toString().isNullOrEmpty()&& binding.etSize.text.toString() as Double!=null&&
        binding.etCompany.text.toString().isNullOrEmpty()&&binding.etDesc.text.toString().isNullOrEmpty()){
            val shoe=Shoe(binding.etShoeName.text.toString(),binding.etSize.text.toString() as Double,
                binding.etCompany.text.toString(),binding.etDesc.text.toString())
            shoelist.add(shoe)
        }else{
            Toast.makeText(requireContext(),"all fields required",Toast.LENGTH_LONG).show()
        }

      return shoelist
    }


}