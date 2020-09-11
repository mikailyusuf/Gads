package com.mikail.gadslearnerboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mikail.gadslearnerboard.api.ApiHelper
import com.mikail.gadslearnerboard.repository.Repository

class MainViewMOdelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {



    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                Repository(
                    apiHelper
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}