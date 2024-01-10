package com.example.spacedaily.data

import retrofit2.http.GET

const val API_KEY = "93jM2ueuefIIP8ayn111VI8YdQAW64o8QYnToAf3\n"
interface NASAAPIInterface {

    @GET("apod?api_key=$API_KEY")
    suspend fun getDailyPhoto(): PhotoResponse
}