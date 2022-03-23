package com.example.taptap.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taptap.R
import com.example.taptap.model.HighScore

class Adapter : ListAdapter<HighScore, Adapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.name)
        private val score: TextView = itemView.findViewById(R.id.score)
        fun bind (highScore: HighScore)  {
            name.text = highScore.name
            score.text = highScore.score.toString()
        }
    }



    object DiffCallback : DiffUtil.ItemCallback<HighScore>() {
        override fun areItemsTheSame(oldItem: HighScore, newItem: HighScore): Boolean {
            return oldItem.name == newItem.name && oldItem.score == newItem.score
        }
        override fun areContentsTheSame(oldItem: HighScore, newItem: HighScore): Boolean {
            return oldItem == newItem
        }
    }
}