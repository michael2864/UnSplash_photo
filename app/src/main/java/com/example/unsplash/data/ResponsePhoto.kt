package com.example.unsplash.data

import kotlinx.android.parcel.Parcelize


@Parcelize
data class ResponsePhoto(
    val id: String,
    val slug: String,
    val description: String?,
    val urls: UnsplashPhotoUrls,
    val user: UnsplashUser
) {

    @Parcelize
    data class UnsplashPhotoUrls(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String
    )

    @Parcelize
    data class UnsplashUser(
        val name: String,
        val username: String
    )
}