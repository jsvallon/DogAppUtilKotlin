package com.jsv.dogapputilkotlin.view

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jsv.dogapputilkotlin.R
import com.jsv.dogapputilkotlin.model.DogBreedModel
import com.jsv.dogapputilkotlin.viewModel.DogApiStatus


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<DogBreedModel>?) {
    var adapter = recyclerView.adapter as DogAdapter
    adapter.submitList(data)
}

@BindingAdapter("dogApiStatus")
fun bindStatus(statusImageView: ImageView, status: DogApiStatus?){
    when(status){
        DogApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        DogApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        DogApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}
