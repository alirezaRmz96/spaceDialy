package com.example.spacedaily.data

import retrofit2.http.GET

const val API_KEY = "Gu6AjVDPxqg6heC0WQYSGXwPxWlabESDEbagyGxO"
interface NASAAPIInterface {

    @GET("apod?api_key=$API_KEY")
    suspend fun getDailyPhoto(): PhotoResponse
}