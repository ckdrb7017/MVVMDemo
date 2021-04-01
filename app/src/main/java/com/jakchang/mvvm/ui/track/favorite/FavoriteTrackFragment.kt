package com.jakchang.mvvm.ui.track.favorite

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakchang.mvvm.R
import com.jakchang.mvvm.databinding.FragmentTrackFavoriteBinding
import com.jakchang.mvvm.ui.MainActivity
import com.jakchang.mvvm.ui.base.BaseFragment
import com.jakchang.mvvm.ui.track.list.TrackListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class FavoriteTrackFragment
    : BaseFragment<FragmentTrackFavoriteBinding, MainActivity>(R.layout.fragment_track_favorite) {

    @Inject
    lateinit var viewModel : FavoriteTrackViewModel
    override fun initFragment() {

        binding.viewmodel = viewModel
        initLayout()

    }

    private fun initLayout(){
        val clickListener = object :FavoriteTrackClickListener{
            override fun onFavoriteClicked(trackId: Int) {
              viewModel.deleteFavoriteTrackById(trackId)
            }
        }
        binding.favoriteTrackRV.adapter = FavoriteTrackAdapter(requireContext(), clickListener)
        binding.favoriteTrackRV.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun initStart() {}
    override fun initResume() {}
    override fun initPause() {}
    override fun initDestroy() {}

}