package com.changgyu.watcha.ui.track.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.changgyu.watcha.WatchaTestApplication
import com.changgyu.watcha.common.utils.getCurrentTime
import com.changgyu.watcha.common.utils.showToast
import com.changgyu.watcha.data.entity.FavoriteTrackEntity
import com.changgyu.watcha.data.entity.TrackEntity
import com.changgyu.watcha.data.entity.TrackListRequestEntity
import com.changgyu.watcha.data.repository.LocalRepositoryImpl
import com.changgyu.watcha.data.repository.ServerRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.collections.LinkedHashMap
import kotlin.collections.List
import kotlin.collections.forEachIndexed
import kotlin.collections.listOf
import kotlin.collections.set

class TrackListViewModel @Inject constructor(
    private val serverRepository: ServerRepositoryImpl,
    private val localRepository: LocalRepositoryImpl
) : ViewModel() {

    private var _favoriteTrackItemList: MutableLiveData<List<FavoriteTrackEntity>> =
        MutableLiveData()
    val favoriteTrackItemList: LiveData<List<FavoriteTrackEntity>> = _favoriteTrackItemList

    private var _trackList: MutableLiveData<List<TrackEntity>> = MutableLiveData()
    val trackList: LiveData<List<TrackEntity>> = _trackList

    private var page = 0 //paging을 위한 변수

    // 서버로 부터 TrackList를 받아와 FavoriteTrackMap과 비교해 이미 추가된 것에 대한 설정
    // Paging을 하고 싶다면 TrackListRequestEntity에 있는 limit 과 offset을 설정하면 Paging이 적용된 결과를 가져온다
    fun getTrackList(term: String, entity: String) {
        viewModelScope.launch {
            val request = TrackListRequestEntity(term, entity, null, null)
            val results = serverRepository.getTrackList(request).results
            _favoriteTrackItemList.value = localRepository.selectFavoriteTrackList()

            val favoriteTrackMap = getFavoriteTrackMap(favoriteTrackItemList.value ?: listOf())
            results.forEachIndexed { index, entity ->
                if (favoriteTrackMap[entity.trackId] != null) {
                    entity.isFavorite = true
                }
            }

            _trackList.value = results
        }
    }

    //FavoriteTrack을 추가하기 위한 함수
    fun insertFavoriteTrack(trackEntity: TrackEntity) {
        viewModelScope.launch {
            val favoriteTrack = convertTrackToFavoriteTrack(trackEntity)
            val result = localRepository.insertFavoriteTrack(favoriteTrack)
            if (result > 0) showToast(
                WatchaTestApplication.watchaTestApp!!.applicationContext,
                "추가되었습니다."
            )
        }
    }

    //FavoriteTrack을 지우기 위한 함수
    fun deleteFavoriteTrackById(trackId: Int) {
        viewModelScope.launch {
            val result = localRepository.deleteFavoriteTrackById(trackId)
            if (result > 0) showToast(
                WatchaTestApplication.watchaTestApp!!.applicationContext,
                "삭제되었습니다."
            )
        }
    }

    //서버에서 받아온 데이터를 로컬디비 저장용 데이터로 변환
    private fun convertTrackToFavoriteTrack(trackEntity: TrackEntity): FavoriteTrackEntity {
        return FavoriteTrackEntity(
            trackId = trackEntity.trackId,
            collectionId = trackEntity.collectionId,
            artistId = trackEntity.artistId,
            trackName = trackEntity.trackName,
            collectionName = trackEntity.collectionName,
            artistName = trackEntity.artistName,
            artworkUrl = trackEntity.artworkUrl100,
            createdDate = getCurrentTime()
        )
    }

    //기존에 Favorite으로 추가된 Map 을 갖기 위한 함수
    private fun getFavoriteTrackMap(list: List<FavoriteTrackEntity>): LinkedHashMap<Int, Int> {
        val map = LinkedHashMap<Int, Int>()
        list.forEachIndexed { index, entity ->
            map[entity.trackId] = index
        }
        return map
    }

}