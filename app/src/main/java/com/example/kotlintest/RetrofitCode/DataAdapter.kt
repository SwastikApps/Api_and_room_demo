package com.example.kotlintest.RetrofitCode

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintest.R

class DataAdapter(private val context: Context, private var list: List<Data>) :
    RecyclerView.Adapter<DataAdapter.myclass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myclass {
        return myclass(LayoutInflater.from(context).inflate(R.layout.itemview, parent, false))
    }

    fun updateData(newData: List<Data>) {
        list = newData
        notifyDataSetChanged()
    }

    class myclass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var id: TextView = itemView.findViewById(R.id.id)
        private var title: TextView = itemView.findViewById(R.id.title)
        private var body: TextView = itemView.findViewById(R.id.body)

        fun bind(data: Data) {
            id.text = data.id.toString()
            title.text = data.name.toString()
            body.text = data.email.toString()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: myclass, position: Int) {
        holder.bind(list.get(position))
    }
}