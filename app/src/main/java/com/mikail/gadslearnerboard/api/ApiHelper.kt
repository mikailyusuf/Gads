package com.mikail.gadslearnerboard.api

import com.mikail.gadslearnerboard.api.Api

class ApiHelper (private val api: Api){

    suspend fun hours() = api.hours()
    suspend fun skilliq() = api.skilliq()



}