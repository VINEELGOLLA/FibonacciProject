package com.example.fibonacciproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fibonacciproject.GenerateFibonacciNumber
import com.example.fibonacciproject.model.FibonacciNumber

class HomeScreenViewModel : ViewModel() {

    var mutableList = MutableLiveData<ArrayList<FibonacciNumber>>()

    private var repository: GenerateFibonacciNumber =
        GenerateFibonacciNumber()

    init {
        mutableList = repository.generatefibonaccinumber()
    }


}