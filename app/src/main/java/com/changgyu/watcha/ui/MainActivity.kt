package com.changgyu.watcha.ui

import androidx.activity.viewModels
import com.changgyu.watcha.R
import com.changgyu.watcha.common.utils.changeFragment
import com.changgyu.watcha.databinding.ActivityMainBinding
import com.changgyu.watcha.ui.base.BaseActivity
import com.changgyu.watcha.ui.track.favorite.FavoriteTrackFragment
import com.changgyu.watcha.ui.track.list.TrackListFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    //@Inject
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