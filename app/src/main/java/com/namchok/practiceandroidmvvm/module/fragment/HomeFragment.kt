package com.namchok.practiceandroidmvvm.module.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.namchok.practiceandroidmvvm.R
import com.namchok.practiceandroidmvvm.module.adapter.PlaylistAdapter
import com.namchok.practiceandroidmvvm.viewmodel.AppViewModel
import com.namchok.practiceandroidmvvm.viewmodel.factory.AppViewModelFactory
import com.namchok.practiceandroidspotify.module.adapter.ArtistsAdapter
import com.namchok.practiceandroidspotify.repository.SpotifyServiceRepository
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private var mArtistAdapter = ArtistsAdapter()
    private var mPlaylistAdapter = PlaylistAdapter()
    private var viewModel:AppViewModel? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var mRepository = SpotifyServiceRepository()
        val factory = AppViewModelFactory(mRepository)

        val artistLayoutManager = LinearLayoutManager(context)
        val albumLayoutManager = LinearLayoutManager(context)
        artistLayoutManager.orientation = LinearLayoutManager.VERTICAL
        albumLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerArtists.layoutManager = artistLayoutManager
        recyclerArtists.adapter = mArtistAdapter
        recyclerPlaylist.layoutManager = albumLayoutManager
        recyclerPlaylist.adapter = mPlaylistAdapter

        viewModel = ViewModelProvider(this,factory).get(AppViewModel::class.java)
        viewModel?.apply {
            mListArtist?.observe(this@HomeFragment, Observer {
                mArtistAdapter.setListArtist(it)
                mArtistAdapter?.notifyDataSetChanged()
            })

            mListPlaylist?.observe(this@HomeFragment, Observer {
                mPlaylistAdapter.setListPlaylist(it)
                mPlaylistAdapter?.notifyDataSetChanged()
            })
        }
        viewModel?.apply {
            getListArtist()
            getPlaylist()
        }
    }

}