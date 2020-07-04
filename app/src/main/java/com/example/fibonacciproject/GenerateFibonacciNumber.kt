package com.example.fibonacciproject

import androidx.lifecycle.MutableLiveData
import com.example.fibonacciproject.model.FibonacciNumber
import java.math.BigInteger
import kotlin.collections.ArrayList



class GenerateFibonacciNumber {

    fun generatefibonaccinumber(): MutableLiveData<ArrayList<FibonacciNumber>> {

        val list = MutableLiveData<ArrayList<FibonacciNumber>>()

        val list2 = ArrayList<FibonacciNumber>()


        var n1 = BigInteger("1")
        var n2 = BigInteger("1")

        for(i in 1 until Constants.endnumber){
            val fibo1 = FibonacciNumber(i, n1.toString())

            val sum = n1 + n2
            n1 = n2
            n2 = sum

            list2.add(fibo1)

        }
        list.value = list2

        return list

    }

}