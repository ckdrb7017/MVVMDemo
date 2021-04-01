package com.jakchang.mvvm.ui

import androidx.fragment.app.Fragment
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jakchang.mvvm.common.utils.getCurrentTime
import com.jakchang.mvvm.common.utils.showLog
import com.jakchang.mvvm.data.entity.FavoriteTrackEntity
import com.jakchang.mvvm.data.entity.TrackEntity
import com.jakchang.mvvm.data.entity.TrackListRequestEntity
import com.jakchang.mvvm.data.repository.LocalRepositoryImpl
import com.jakchang.mvvm.data.repository.ServerRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

class MainViewModel @Inject constructor() : ViewModel() {

    var isInitialized = false
    private lateinit var currentFragment: Fragment
    private var _titleText : MutableLiveData<String> = MutableLiveData()
    val titleText : LiveData<String> = _titleText

    fun setTitleText(title: String){
        _titleText.value = title
    }

    fun setCurrentFragment(fragment: Fragment){
        currentFragment = fragment
    }

    fun getCurrentFragment(): Fragment{
        return currentFragment
    }
}