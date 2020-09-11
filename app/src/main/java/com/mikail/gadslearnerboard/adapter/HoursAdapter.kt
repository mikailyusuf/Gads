package com.mikail.gadslearnerboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mikail.gadslearnerboard.R
import com.mikail.gadslearnerboard.model.HoursModel
import com.mikail.gadslearnerboard.model.HoursModelItem
import com.mikail.gadslearnerboard.testItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.hours_layout.view.*

class HoursAdapter(private val ItemsList:List<HoursModelItem>) :
    RecyclerView.Adapter<HoursAdapter.RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {

        val items = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.hours_layout, parent
                , false
            )

        return RecyclerViewHolder(items)

    }

    override fun getItemCount(): Int {
        return ItemsList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {

        holder.initialise(ItemsList[position])
    }

    class RecyclerViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        private val username: TextView = itemview.name
        private val image: ImageView = itemview.badgeUrl
        private val hours: TextView = itemview.hours
        private val country:TextView = itemview.country


        fun initialise(hoursModel: HoursModelItem) {
            username.text =   hoursModel.name
            Picasso.get().load(hoursModel.badgeUrl).into(image)

            val data = hoursModel.hours.toString()
            val t = "$data  Learning hours,"
            hours.text = t
            country.text = hoursModel.country
        }
    }
}