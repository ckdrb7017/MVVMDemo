package com.changgyu.watcha.ui.track.list

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.changgyu.watcha.R
import com.changgyu.watcha.common.utils.showLog
import com.changgyu.watcha.data.entity.TrackEntity
import com.changgyu.watcha.databinding.FragmentTrackListBinding
import com.changgyu.watcha.ui.MainActivity
import com.changgyu.watcha.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TrackListFragment
    : BaseFragment<FragmentTrackListBinding, MainActivity>(R.layout.fragment_track_list) {

    @Inject
    lateinit var viewModel : TrackListViewModel
    override fun initFragment() {

        binding.viewmodel = viewModel
        initLayout()
        initViewModel()
    }

    private fun initLayout(){
        val clickListener = object : TrackListClickListener {
            override fun onFavoriteClicked(trackId: Int, trackEntity: TrackEntity) {
                if(trackEntity.isFavorite!!){
                    viewModel.deleteFavoriteTrackById(trackId)
                }else{
                    viewModel.insertFavoriteTrack(trackEntity)
                }

            }
        }
        binding.trackListRV.adapter = TrackListAdapter(requireContext(), clickListener)
        binding.trackListRV.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun initViewModel(){
        viewModel.getTrackList("greenday", SearchType.SONG.type)
    }

    override fun initStart() {}
    override fun initResume() {}
    override fun initPause() {}
    override fun initDestroy() {}

}