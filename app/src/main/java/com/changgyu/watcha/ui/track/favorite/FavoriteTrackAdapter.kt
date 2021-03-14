package com.changgyu.watcha.ui.track.favorite

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.changgyu.watcha.common.utils.setImage
import com.changgyu.watcha.data.entity.FavoriteTrackEntity
import com.changgyu.watcha.databinding.ItemTrackFavoriteBinding

class FavoriteTrackAdapter(private val context: Context, private val clickListener: FavoriteTrackClickListener)
    : ListAdapter<FavoriteTrackEntity, RecyclerView.ViewHolder>(FavoriteTrackDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemTrackFavoriteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FavoriteTrackHolder(binding)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int,payload:List<Any>) {
        val item = getItem(position)
        when(holder){
            is FavoriteTrackHolder ->{
               holder.bind(item)
               holder.binding.favoriteButton.setOnClickListener {
                   clickListener.onFavoriteClicked(item.trackId)
               }
            }
        }
    }

    inner class FavoriteTrackHolder (val binding : ItemTrackFavoriteBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: FavoriteTrackEntity){
            binding.artistName.text = item.artistName
            binding.collectionName.text = item.collectionName
            binding.trackName.text = item.trackName
            setImage(context ,item.artworkUrl, binding.artwork)
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }
}

class FavoriteTrackDiffCallback : DiffUtil.ItemCallback<FavoriteTrackEntity>() {
    override fun areItemsTheSame(oldItem: FavoriteTrackEntity, newItem: FavoriteTrackEntity): Boolean {
        return oldItem.trackId == newItem.trackId
    }

    override fun areContentsTheSame(oldItem: FavoriteTrackEntity, newItem: FavoriteTrackEntity): Boolean {
        return oldItem == newItem
    }

}