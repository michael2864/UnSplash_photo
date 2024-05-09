package com.example.unsplash

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class FullScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen)
        var imageView: ImageView = findViewById(R.id.image_picture_fullscreen)
        val intent = intent
        val photo = intent.getStringExtra("photo")
        Glide.with(this).load(photo).into(imageView)
    }
}