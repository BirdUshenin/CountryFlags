package com.birdushenin.countryflags.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.birdushenin.countryflags.R
import com.birdushenin.countryflags.data.Country
import com.squareup.picasso.Picasso

class CountryAdapter(private val countries: List<Country>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var flag: ImageView = view.findViewById(R.id.flag)
        var countryA: TextView = view.findViewById(R.id.country)
        var capitalQ: TextView = view.findViewById(R.id.capital)

        fun bind(country: Country) {
            countryA.text = country.country
            capitalQ.text = country.capital

            Picasso.get()
                .load(country.flag)
                .into(flag)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int {
        return countries.size
    }
}