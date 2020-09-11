package com.mikail.gadslearnerboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mikail.gadslearnerboard.api.ApiHelper
import com.mikail.gadslearnerboard.api.google.GoogleApiHelper
import com.mikail.gadslearnerboard.repository.GoogleRepository
import com.mikail.gadslearnerboard.repository.Repository

class GoogleViewModelFactory(private val apiHelper: GoogleApiHelper) : ViewModelProvider.Factory   {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GoogleViewModel::class.java)) {
            return GoogleViewModel(
                GoogleRepository(
                    apiHelper
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}