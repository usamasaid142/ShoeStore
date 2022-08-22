package com.udacity.shoestore.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.viewmodel.ShoeViewmodel


class ShoeviewmodelFactory (): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoeViewmodel() as T
    }


}