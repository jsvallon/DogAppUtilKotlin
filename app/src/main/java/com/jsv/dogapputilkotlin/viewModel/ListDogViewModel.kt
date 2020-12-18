package com.jsv.dogapputilkotlin.viewModel



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jsv.dogapputilkotlin.model.DogBreedModel
import com.jsv.dogapputilkotlin.service.DogApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


enum class DogApiStatus { LOADING, ERROR, DONE}


class ListDogViewModel :ViewModel() {
    private val _status = MutableLiveData<DogApiStatus>();

    //The external immutable LiveData
    val status: LiveData<DogApiStatus>
        get() = _status

    private val _dogs = MutableLiveData<List<DogBreedModel>>()
    val dogs : LiveData<List<DogBreedModel>>
    get() = _dogs



    //Create a coroutine Job and a CoroutineScope using the Main Dispatcher which use the ui thread
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    //Call list dog on the init that we can display immediately
    init {
        updateDogList();
    }

    private fun updateDogList() {
        coroutineScope.launch {
            var getDogsDeferred = DogApi.retrofitService.getDogsList()

            try {
                _status.value = DogApiStatus.LOADING
                var listResult = getDogsDeferred.await()
                _status.value = DogApiStatus.DONE

                if (listResult.size > 0) {
                    _dogs.value = listResult
                }

            } catch (t:Throwable) {
                _status.value = DogApiStatus.ERROR
                _dogs.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

//    private fun updateDogList() {
//
//        DogApi.retrofitService.getDogsList().enqueue(object : retrofit2.Callback<List<DogBreedModel>> {
//            override fun onFailure(call: Call<List<DogBreedModel>>, t: Throwable) {
//                _response.value = "Failure "+t.message
//            }
//
//            override fun onResponse(call: Call<List<DogBreedModel>>, response: Response<List<DogBreedModel>>) {
//                _response.value = "Success: ${response.body()?.size} Dogs"
//            }
//        })
//    }
}
