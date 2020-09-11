package com.mikail.gadslearnerboard.api.google

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface GoogleApi {

    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    suspend fun submitForm(
        @Field("entry.1824927963") email: String,
        @Field("entry.1877115667") name: String,
        @Field("entry.2006916086") lastname: String,
        @Field("entry.284483984") link:String
    ): Response<Void>
}