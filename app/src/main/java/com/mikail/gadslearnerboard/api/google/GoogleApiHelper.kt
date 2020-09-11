package com.mikail.gadslearnerboard.api.google

import com.mikail.gadslearnerboard.api.Api

class GoogleApiHelper(private val api: GoogleApi) {
    suspend fun submitForm(email:String,name: String,lastname:String,link:String) = api.submitForm(email, name, lastname, link)
}