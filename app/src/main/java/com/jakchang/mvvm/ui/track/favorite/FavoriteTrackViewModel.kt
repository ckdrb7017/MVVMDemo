package com.jakchang.mvvm.ui.track.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jakchang.mvvm.MyApplication.Companion.myApp
import com.jakchang.mvvm.common.utils.showToast
import com.jakchang.mvvm.data.entity.FavoriteTrackEntity
import com.jakchang.mvvm.data.repository.LocalRepositoryImpl
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
            if (result > 0) showToast(myApp!!.applicationContext, "삭제되었습니다.")
        }
    }

}