package com.namchok.practiceandroidmvvm.module.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.namchok.practiceandroidmvvm.R
import com.namchok.practiceandroidmvvm.model.common.Artist
import com.namchok.practiceandroidmvvm.model.common.Item
import com.namchok.practiceandroidspotify.module.adapter.ArtistsAdapter
import kotlinx.android.synthetic.main.item_artist.view.*
import kotlinx.android.synthetic.main.item_playlist.view.*

class PlaylistAdapter : RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {

    var mListPlaylist = ArrayList<Item>()
    var context: Context? = null

    fun setListPlaylist(mList:ArrayList<Item>){
        this.mListPlaylist = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_playlist, parent, false)
        context = parent.context
        return PlaylistAdapter.ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return mListPlaylist.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.tvPlaylistName
        var image = itemView.imgPlaylist
        var view = itemView.linearArtist
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = mListPlaylist[position].track.album.name
        context?.let {
            Glide.with(it)
                .load(mListPlaylist[position].track.album.images[0].url)
                .into(holder.image)
        }

    }
}