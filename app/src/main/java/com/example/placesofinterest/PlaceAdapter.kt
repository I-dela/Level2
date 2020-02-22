package com.example.placesofinterest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_place.view.*

class PlaceAdapter(private var places: List<Place>) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {


    /**
     *  This inner custom viewholder class is responsible for how the views are going to look like in the recyclerView.
     *  takes the data from the dataset and sets it to a viewholder
     */

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val place_image  = itemView.img_title
        val place_title = itemView.place_title


        /**
         * responsible for taking each individual item object and actually binding it
         * to the views in the layout
         */
        fun bind(place: Place){
            place_title.setText(place.name)

            // glide object. is used to set some defaults to any images youre gonna be setting
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)


            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(place.imageResId)
                .into(place_image)

        }


    }

    /**
     *  responsible for creating each viewholder in a list. Essentially each item in the list has a viewholder

     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false))

    }

    /**
     *
     */

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // is gonna bind the data to the particulair viewholder that is currently in view
        when(holder){
            is ViewHolder -> {
                holder.bind(places.get(position))
            }

        }
    }

    /**
     *  returns the amount of items in your list

     */
    override fun getItemCount(): Int {
        return places.size
    }






}