package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.adapter.ShoeAdapter
import com.udacity.shoestore.databinding.ShoelistfragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewmodel


class ShoeListFragment : Fragment() {

    private lateinit var binding:ShoelistfragmentBinding
    private lateinit var shoeAdapter:ShoeAdapter
  lateinit var viewModel:ShoeViewmodel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=ShoelistfragmentBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as MainActivity).viewmodel
      //  setupRecylerview()
        callback()
    }

//    fun setupRecylerview(){
//        shoeAdapter= ShoeAdapter()
//        binding.rvShoes.apply {
//
//            adapter=shoeAdapter
//            layoutManager= LinearLayoutManager(requireContext())
//            setHasFixedSize(true)
//
//        }
//    }

    fun callback() {

       viewModel.shoes.observe(viewLifecycleOwner, Observer {
          // shoeAdapter.submitList(it)
           add(it)
       })

        getshoes()
    }

    private fun getshoes() {
        viewModel.setData()
    }

    fun add(list:MutableList<Shoe>) {

        val view = layoutInflater.inflate(R.layout.shoe_item_layout, null)
        val shoename = view.findViewById<TextView>(R.id.shoename)
        val company = view.findViewById<TextView>(R.id.company)
        val size = view.findViewById<TextView>(R.id.size)
        val desc = view.findViewById<TextView>(R.id.description)


            for (i in 0 until list.size) {
                binding.layoutOfItems.removeView(view)
                shoename.text = list[i].name
                company.text = list[i].company
                size.text = list[i].size.toString()
                desc.text = list[i].description
                binding.layoutOfItems.addView(view)
            }


        }
    fun navigatetoShoeDetail()
    {

    }

}