package com.example.navigationexampletow

import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NestedViewModel : ViewModel(), LifecycleObserver {

    private val liveDataWaves = MutableLiveData<Int>()

    init {
        runDemo()
    }

    fun getLivedata(): LiveData<Int> {
        return liveDataWaves
    }

    fun runDemo() {
        var count = 0
        viewModelScope.launch {
            while (true) {
                liveDataWaves.value = count
                delay(500)
                count++
            }
        }
    }
}