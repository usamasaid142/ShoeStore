package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.adapter.ShoeAdapter
import com.udacity.shoestore.databinding.ShoeItemLayoutBinding
import com.udacity.shoestore.databinding.ShoelistfragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewmodel


class ShoeListFragment : Fragment() {

    private lateinit var binding:ShoelistfragmentBinding
    private lateinit var shoeAdapter:ShoeAdapter
    val list= mutableListOf<Shoe>()
  lateinit var viewModel:ShoeViewmodel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=ShoelistfragmentBinding.inflate(layoutInflater,container,false)
          setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as MainActivity).viewmodel
      //  setupRecylerview()

        initbutton()
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

    fun initbutton(){
        binding.add.setOnClickListener {
            navigatetoShoeDetail()
        }
    }
    fun callback() {

       viewModel.shoes.observe(viewLifecycleOwner, Observer {
          // shoeAdapter.submitList(it)

           for(i in 0 until it.size){
               addview(it[i].name,it[i].size,it[i].company,it[i].description)

           }

       })

        getshoes()
    }

    private fun getshoes() {
        viewModel.setData()
    }

    fun addview(shname:String,shsize:Double,shcompany:String,shdesc:String) {
       val view = layoutInflater.inflate(R.layout.shoe_item_layout, null)
        ShoeItemLayoutBinding.bind(view).data=Shoe(shname,shsize,shcompany,shdesc)
         binding.layoutOfItems.addView(view)
    }

    fun navigatetoShoeDetail()
    {
     val action=ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
        findNavController().navigate(action)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId== R.id.loginFragment){
            findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
            true
        }else{
            return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())||super.onOptionsItemSelected(item)
        }

    }



}