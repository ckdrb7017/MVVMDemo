package com.changgyu.watcha.ui

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

    @Inject
    lateinit var viewModel: MainViewModel
    private val tackListFragment = TrackListFragment()
    private val favoriteTrackFragment = FavoriteTrackFragment()

    override fun initActivity() {
        binding.viewmodel = viewModel
        initBottomNavItemClick()
        changeFragment(this, binding.fragmentContainer, tackListFragment)
        viewModel.setTitleText(getString(R.string.title_track_list))
    }

    private fun initBottomNavItemClick() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.trackListFragment -> {
                    changeFragment(this, binding.fragmentContainer, tackListFragment)
                    viewModel.setTitleText(getString(R.string.title_track_list))
                }
                R.id.trackFavoriteFragment -> {
                    changeFragment(this, binding.fragmentContainer, favoriteTrackFragment)
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