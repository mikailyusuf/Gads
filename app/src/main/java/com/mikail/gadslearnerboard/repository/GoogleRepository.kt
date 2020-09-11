package com.mikail.gadslearnerboard.repository

import com.mikail.gadslearnerboard.api.ApiHelper
import com.mikail.gadslearnerboard.api.google.GoogleApiHelper

class GoogleRepository(private val apihelper: GoogleApiHelper) {

    suspend fun submitForm(email:String,name: String,lastname:String,link:String) = apihelper.submitForm(email, name, lastname, link)
}