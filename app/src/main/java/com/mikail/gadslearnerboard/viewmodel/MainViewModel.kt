package com.mikail.gadslearnerboard.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mikail.gadslearnerboard.repository.Repository
import com.mikail.gadslearnerboard.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repository: Repository) : ViewModel() {

    fun hours() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.hours()))
            Log.d("result", Resource.success(data = repository.hours().toString()).toString())
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occured"))
            Log.d(
                "result",
                emit(
                    Resource.error(
                        data = null,
                        message = exception.message ?: "Error Occured"
                    )
                ).toString()
            )
        }

    }


    fun skilliq() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.skilliq()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occured"))
        }
    }




}