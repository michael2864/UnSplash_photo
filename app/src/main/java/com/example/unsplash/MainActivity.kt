package com.example.unsplash

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unsplash.Network.ApiClient
import com.example.unsplash.Network.ApiInterface
import com.example.unsplash.adapter.RecyclerViewAdapter
import com.example.unsplash.data.ResponsePhoto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.photoClickListener {

    var photoData: List<ResponsePhoto> = listOf()

    override fun getItem(position: Int) {
        startActivity(Intent(this, FullScreenActivity::class.java).apply {
            putExtra("photo", photoData[position].urls.full)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recyclerView: RecyclerView = findViewById(R.id.recyclerview_demo)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        var apiInterface: ApiInterface =
            ApiClient().getApiClient()!!.create(ApiInterface::class.java)
        apiInterface.getPhotos().enqueue(object : Callback<List<ResponsePhoto>> {

            override fun onFailure(call: Call<List<ResponsePhoto>>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "onFailure", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<List<ResponsePhoto>>?,
                response: Response<List<ResponsePhoto>>?
            ) {
                photoData = response?.body()!!
                recyclerView.adapter = RecyclerViewAdapter(response?.body()!!, this@MainActivity)
                Toast.makeText(this@MainActivity, "onSuccess", Toast.LENGTH_LONG).show()
            }
        })
    }
}