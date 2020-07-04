package com.example.fibonacciproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fibonacciproject.R
import com.example.fibonacciproject.model.FibonacciNumber
import kotlinx.android.synthetic.main.recyclerviewcell.view.*

class RecyclerviewAdapter(private var list: MutableList<FibonacciNumber>): RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerviewcell,parent,false)
        return ViewHolder(
            view
        )
    }

    fun addData(data: MutableList<FibonacciNumber>){
        list = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(this.list[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: FibonacciNumber){
            itemView.cellnumber.text = data.id.toString()
            itemView.cellvalue.text = data.number
        }
    }
}