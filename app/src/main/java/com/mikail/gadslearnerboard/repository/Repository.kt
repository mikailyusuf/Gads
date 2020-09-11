package com.mikail.gadslearnerboard.repository

import com.mikail.gadslearnerboard.api.ApiHelper

class Repository(private val apihelper: ApiHelper) {

    suspend fun hours() =  apihelper.hours()
    suspend fun skilliq() = apihelper.skilliq()


}