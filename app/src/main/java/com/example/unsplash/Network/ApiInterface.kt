package com.example.unsplash.Network

import com.example.unsplash.data.ResponsePhoto
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("photos/?client_id=    ENTER YOUR SECRET KEY  ")
    fun getPhotos(): Call<List<ResponsePhoto>>
}