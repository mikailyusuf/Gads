package com.mikail.gadslearnerboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mikail.gadslearnerboard.R
import com.mikail.gadslearnerboard.model.SkilliqModelItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.skilliq_layout.view.*


class SkillsIqAdapter(private val ItemsList: List<SkilliqModelItem>) :
    RecyclerView.Adapter<SkillsIqAdapter.RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {

        val items = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.skilliq_layout, parent
                , false
            )

        return RecyclerViewHolder(items)

    }

    override fun getItemCount(): Int {
        return ItemsList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {

        holder.initialise(ItemsList.get(position))
    }

    class RecyclerViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        private val username: TextView = itemview.name
        private val image: ImageView = itemview.badgeUrl
        private val hours: TextView = itemview.hours
        private val country:TextView = itemview.country
        fun initialise(datamodel: SkilliqModelItem) {
            username.text = datamodel.name
            Picasso.get().load(datamodel.badgeUrl).into(image)
            val h = datamodel.score.toString()
            val skilliq = "$h IQ Score"
            hours.text = skilliq
            country.text = datamodel.country
        }
    }
}