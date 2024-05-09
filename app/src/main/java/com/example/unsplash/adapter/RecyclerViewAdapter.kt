package com.example.unsplash.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.unsplash.R
import com.example.unsplash.data.ResponsePhoto

class RecyclerViewAdapter(
    var photosList: List<ResponsePhoto>,
    var itemClick: photoClickListener
) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        var view: View =
            LayoutInflater.from(parent!!.context).inflate(R.layout.item_list, parent, false)
        return RecyclerViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return photosList!!.size
    }

    interface photoClickListener {
        fun getItem(position: Int)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bindData(photosList, position)
    }

    class RecyclerViewHolder(itemView: View, var itemClick: photoClickListener) :
        RecyclerView.ViewHolder(itemView) {
        var photo: ImageView = itemView.findViewById(R.id.image_picture)
        var textName: TextView = itemView.findViewById(R.id.text_name)
        var textAuthor: TextView = itemView.findViewById(R.id.text_author)
        fun bindData(photoList: List<ResponsePhoto>, position: Int) {
            textName.text = photoList!![position].slug
            textAuthor.text = "Author: " + photoList!![position].user.name
            Glide.with(itemView).load(photoList!![position].urls.regular).into(photo)
            itemView.setOnClickListener(View.OnClickListener {
                itemClick.getItem(adapterPosition)
            })

        }
    }
}