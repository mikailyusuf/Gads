package com.mikail.gadslearnerboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mikail.gadslearnerboard.Resource
import com.mikail.gadslearnerboard.repository.GoogleRepository
import com.mikail.gadslearnerboard.repository.Repository
import kotlinx.coroutines.Dispatchers

class GoogleViewModel(private val repository: GoogleRepository) : ViewModel() {

    fun submitform(email: String, name: String, lastname: String, link: String) =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(data = null))
            try {
                emit(Resource.success(data = repository.submitForm(email, name, lastname, link)))
            } catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occured"))
            }
        }
}