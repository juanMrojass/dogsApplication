package com.example.dogsapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dogsapplication.R
import com.example.dogsapplication.data.model.DogModelItem
import com.example.dogsapplication.databinding.ItemDogBinding

class DogAdapter(private val dogList: ArrayList<DogModelItem> = arrayListOf()) :
    RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    inner class DogViewHolder(private val rootView: ItemDogBinding) :
        RecyclerView.ViewHolder(rootView.root) {

        fun bind(item: DogModelItem) {
            rootView.name.text = item.dogName ?: ""
            rootView.description.text = item.description ?: ""
            rootView.age.text = itemView.context.getString(R.string.almost_years, item.age ?: 0)
            Glide
                .with(itemView.context).
                load(item.image ?: "")
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .into(rootView.imageDog)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val rootView = ItemDogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DogViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.bind(dogList[position])
    }

    override fun getItemCount(): Int = dogList.size

    fun addItems(dogList: List<DogModelItem>) {
        dogList.forEachIndexed { index, dogModelItem ->
            this.dogList.add(dogModelItem)
            notifyItemInserted(index)
        }
    }
}
