package com.changgyu.watcha.ui.track.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.changgyu.watcha.WatchaTestApplication.Companion.watchaTestApp
import com.changgyu.watcha.common.utils.showToast
import com.changgyu.watcha.data.entity.FavoriteTrackEntity
import com.changgyu.watcha.data.repository.LocalRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteTrackViewModel @Inject constructor(
    private val localRepository: LocalRepositoryImpl
) : ViewModel() {

    val favoriteTrackItemList: LiveData<List<FavoriteTrackEntity>> =
        localRepository.observeFavoriteTrackList()

    fun deleteFavoriteTrackById(trackId: Int) {
        viewModelScope.launch {
            val result = localRepository.deleteFavoriteTrackById(trackId)
            if (result > 0) showToast(watchaTestApp!!.applicationContext, "삭제되었습니다.")
        }
    }

}