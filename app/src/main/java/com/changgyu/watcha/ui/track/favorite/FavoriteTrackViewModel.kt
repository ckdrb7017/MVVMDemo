package com.changgyu.watcha.ui.track.favorite

import androidx.lifecycle.*
import com.changgyu.watcha.WatchaTestApplication.Companion.watchaTestApp
import com.changgyu.watcha.common.utils.showToast
import com.changgyu.watcha.data.entity.FavoriteTrackEntity
import com.changgyu.watcha.data.repository.LocalRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteTrackViewModel @Inject constructor(
    private val localRepository: LocalRepositoryImpl
) : ViewModel() {

    private var _favoriteTrackAdapter :MutableLiveData<FavoriteTrackAdapter> = MutableLiveData()
    val favoriteTrackAdapter : LiveData<FavoriteTrackAdapter> = _favoriteTrackAdapter

    val favoriteTrackItemList : LiveData<List<FavoriteTrackEntity>> = localRepository.observeFavoriteTrackList()

    fun setFavoriteTrackAdapter(){

    }

    fun deleteFavoriteTrackById(trackId: Int){
        viewModelScope.launch {
            val result = localRepository.deleteFavoriteTrackById(trackId)
            if(result>0) showToast(watchaTestApp!!.applicationContext,"삭제되었습니다.")
        }
    }

}