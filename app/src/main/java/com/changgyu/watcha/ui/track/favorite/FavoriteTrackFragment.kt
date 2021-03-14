package com.changgyu.watcha.ui.track.favorite

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.changgyu.watcha.R
import com.changgyu.watcha.databinding.FragmentTrackFavoriteBinding
import com.changgyu.watcha.ui.MainActivity
import com.changgyu.watcha.ui.base.BaseFragment
import com.changgyu.watcha.ui.track.list.TrackListViewModel
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
        binding.favoriteTrackRV.adapter = FavoriteTrackAdapter(mActivity!!, clickListener)
        binding.favoriteTrackRV.layoutManager = LinearLayoutManager(mActivity)
    }

    override fun initStart() {}
    override fun initResume() {}
    override fun initPause() {}
    override fun initDestroy() {}

}