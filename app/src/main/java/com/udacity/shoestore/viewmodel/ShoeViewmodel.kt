package com.udacity.shoestore.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewmodel:ViewModel() {

    val shoes: MutableLiveData<MutableList<Shoe>> = MutableLiveData()

    fun setData() {

        val shoeslist: MutableList<Shoe> = mutableListOf()
        shoeslist.add(Shoe(name = "Casual shoes",40.0,"cat","good shoes"))
        shoeslist.add(Shoe(name = "sport shes",38.0,"adidas","very good shoes" ))
        shoeslist.add(Shoe(name = "classic shoes",42.0,"cat","good shoes" ))


        shoes.postValue(shoeslist)
    }
}