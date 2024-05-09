package com.jes.wikiworld

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ElviewModel: ViewModel() {



    private val _selectedItems = MutableLiveData<List<Item2>>()
    val selectedItems: LiveData<List<Item2>> = _selectedItems

    fun setSelectedItems(items: List<Item2>) {
        _selectedItems.value = items
    }



}