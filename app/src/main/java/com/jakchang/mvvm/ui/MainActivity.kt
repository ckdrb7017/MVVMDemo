package com.jakchang.mvvm.ui

import androidx.activity.viewModels
import com.jakchang.mvvm.R
import com.jakchang.mvvm.common.utils.changeFragment
import com.jakchang.mvvm.databinding.ActivityMainBinding
import com.jakchang.mvvm.ui.base.BaseActivity
import com.jakchang.mvvm.ui.track.favorite.FavoriteTrackFragment
import com.jakchang.mvvm.ui.track.list.TrackListFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainViewModel  by viewModels()
    private val tackListFragment = TrackListFragment()
    private val favoriteTrackFragment = FavoriteTrackFragment()

    override fun initActivity() {
        initBottomNavItemClick()
        binding.viewmodel = viewModel
        if(viewModel.isInitialized){
            changeFragment(this, binding.fragmentContainer, viewModel.getCurrentFragment())
        }else{
            changeFragment(this, binding.fragmentContainer, tackListFragment)
            viewModel.setCurrentFragment(tackListFragment)
            viewModel.setTitleText(getString(R.string.title_track_list))
            viewModel.isInitialized = true
        }
    }

    private fun initBottomNavItemClick() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.trackListFragment -> {
                    changeFragment(this, binding.fragmentContainer, tackListFragment)
                    viewModel.setCurrentFragment(tackListFragment)
                    viewModel.setTitleText(getString(R.string.title_track_list))
                }
                R.id.trackFavoriteFragment -> {
                    changeFragment(this, binding.fragmentContainer, favoriteTrackFragment)
                    viewModel.setCurrentFragment(favoriteTrackFragment)
                    viewModel.setTitleText(getString(R.string.title_track_favorite))
                }
            }
            true
        }
    }

    override fun initStart() {}
    override fun initResume() {}
    override fun initPause() {}
    override fun initDestroy() {}

}