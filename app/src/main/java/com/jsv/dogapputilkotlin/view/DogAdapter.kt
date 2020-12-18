package com.jsv.dogapputilkotlin.view


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jsv.dogapputilkotlin.databinding.SingleDogItemBinding
import com.jsv.dogapputilkotlin.model.DogBreedModel


class DogAdapter : ListAdapter<DogBreedModel, DogAdapter.DogBreedModelViewHolder>(DiffCallBack) {


    class DogBreedModelViewHolder(private var binding: SingleDogItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dogBreedModel: DogBreedModel) {
           binding.dogbreedmodel = dogBreedModel
           binding.executePendingBindings()
       }

    }

    companion object DiffCallBack: DiffUtil.ItemCallback<DogBreedModel>() {
        override fun areItemsTheSame(oldItem: DogBreedModel, newItem: DogBreedModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DogBreedModel, newItem: DogBreedModel): Boolean {
            return oldItem.id == newItem.id
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogBreedModelViewHolder {
        return DogBreedModelViewHolder(SingleDogItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: DogBreedModelViewHolder, position: Int) {
        val dogsModel = getItem(position)
        holder.bind(dogsModel)
    }
}
