package com.changgyu.watcha.ui

import androidx.fragment.app.Fragment
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.changgyu.watcha.common.utils.getCurrentTime
import com.changgyu.watcha.common.utils.showLog
import com.changgyu.watcha.data.entity.FavoriteTrackEntity
import com.changgyu.watcha.data.entity.TrackEntity
import com.changgyu.watcha.data.entity.TrackListRequestEntity
import com.changgyu.watcha.data.repository.LocalRepositoryImpl
import com.changgyu.watcha.data.repository.ServerRepositoryImpl
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