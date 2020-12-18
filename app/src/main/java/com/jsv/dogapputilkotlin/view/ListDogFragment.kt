package com.jsv.dogapputilkotlin.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jsv.dogapputilkotlin.R
import com.jsv.dogapputilkotlin.databinding.FragmentListDogBinding
import com.jsv.dogapputilkotlin.viewModel.ListDogViewModel
import kotlinx.android.synthetic.main.fragment_list_dog.view.*


class ListDogFragment : Fragment() {

    //Lazy initialize our ViewModel
    private val viewModel: ListDogViewModel by lazy {
        ViewModelProvider(this).get(ListDogViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentListDogBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.listDogs.adapter = DogAdapter()

        return binding.root
    }

}