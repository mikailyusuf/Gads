package com.mikail.gadslearnerboard.api

import com.mikail.gadslearnerboard.model.HoursModel
import com.mikail.gadslearnerboard.model.HoursModelItem
import com.mikail.gadslearnerboard.model.SkilliqModel
import com.mikail.gadslearnerboard.model.SkilliqModelItem
import com.mikail.gadslearnerboard.testItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("/api/hours")
    suspend fun hours():List<HoursModelItem>


    @GET("/api/skilliq")
    suspend fun skilliq(): List<SkilliqModelItem>



}