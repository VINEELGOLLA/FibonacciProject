package com.example.fibonacciproject.view

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fibonacciproject.viewmodel.HomeScreenViewModel
import com.example.fibonacciproject.R
import com.example.fibonacciproject.adapter.RecyclerviewAdapter
import com.example.fibonacciproject.model.FibonacciNumber
import kotlinx.android.synthetic.main.home_screen_fragment.*

class HomeScreen : Fragment(R.layout.home_screen_fragment) {

    private lateinit var viewModel: HomeScreenViewModel



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup_recyclerview()

        viewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observedata()

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                p0?.progress?.let { recyclerview.scrollToPosition(it) }
            }

        })


    }

    // update recyclerview with data
    fun observedata(){

        viewModel.mutableList.observe(this.viewLifecycleOwner, Observer {

            if(it.isNotEmpty()){

                (recyclerview.adapter as RecyclerviewAdapter).addData(it as MutableList<FibonacciNumber>)

            }
        })
    }

    // setting up recyclerview
    fun setup_recyclerview(){
        recyclerview.layoutManager = LinearLayoutManager(this.context)
        recyclerview.setHasFixedSize(true)
        recyclerview.adapter =
            RecyclerviewAdapter(
                mutableListOf()
            )
    }

}