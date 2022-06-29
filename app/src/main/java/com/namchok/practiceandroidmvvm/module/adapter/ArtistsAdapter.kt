package com.namchok.practiceandroidspotify.module.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.namchok.practiceandroidmvvm.R
import com.namchok.practiceandroidmvvm.model.common.Artist
import kotlinx.android.synthetic.main.item_artist.view.*

class ArtistsAdapter(): RecyclerView.Adapter<ArtistsAdapter.ViewHolder>() {

    var mListArtist = ArrayList<Artist>()
    var context:Context? = null

    fun setListArtist(mList:ArrayList<Artist>){
        this.mListArtist = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistsAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_artist, parent, false)
        context = parent.context
        return ArtistsAdapter.ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return mListArtist.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.tvNameArtist
        var image = itemView.imgProfileArtist
        var type = itemView.tvArtistType
        var popularity = itemView.tvArtistPopularity
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = mListArtist[position].name
        holder.type.text = mListArtist[position].type
        holder.popularity.text = mListArtist[position].popularity.toString()
        context?.let {
            Glide.with(it)
                .load(mListArtist[position].images[0].url)
                .into(holder.image)
        }

    }
}