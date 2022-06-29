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
import com.namchok.practiceandroidmvvm.viewmodel.ListArtistViewModel
import com.namchok.practiceandroidmvvm.viewmodel.factory.ListArtistViewModelFactory
import com.namchok.practiceandroidspotify.module.adapter.ArtistsAdapter
import com.namchok.practiceandroidspotify.repository.SpotifyServiceRepository
import kotlinx.android.synthetic.main.fragment_list_artist.*


class ListArtistFragment : Fragment() {

    private var mAdapter = ArtistsAdapter()
    private var viewModel:ListArtistViewModel? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_artist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var mRepository = SpotifyServiceRepository()
        val factory = ListArtistViewModelFactory(mRepository)

        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.HORIZONTAL
        recyclerArtists.layoutManager = llm
        recyclerArtists.adapter = mAdapter

        viewModel = ViewModelProvider(this,factory).get(ListArtistViewModel::class.java)
        viewModel?.mListArtist?.observe(this, Observer {
            mAdapter.setListArtist(it)
            mAdapter?.notifyDataSetChanged()
        })
        viewModel?.getListArtist()
    }

}