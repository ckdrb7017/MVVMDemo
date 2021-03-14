package com.changgyu.watcha.ui.track.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.changgyu.watcha.R
import com.changgyu.watcha.common.utils.setImage
import com.changgyu.watcha.data.entity.TrackEntity
import com.changgyu.watcha.databinding.ItemTrackListBinding

class TrackListAdapter(private val context: Context, private val clickListener: TrackListClickListener)
    : ListAdapter<TrackEntity, RecyclerView.ViewHolder>(TrackListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemTrackListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TrackListHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int,payload:List<Any>) {
        val item = getItem(position)
        when(holder){
            is TrackListHolder ->{
                holder.bind(item)
            }
        }
    }

    inner class TrackListHolder (val binding : ItemTrackListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: TrackEntity){
            binding.entity = item
            binding.artistName.text = item.artistName
            binding.collectionName.text = item.collectionName
            binding.trackName.text = item.trackName
            setImage(context ,item.artworkUrl100, binding.artwork)
            binding.favoriteButton.setOnClickListener {
                clickListener.onFavoriteClicked(item.trackId, item)
                item.isFavorite = !item.isFavorite!!
                setFavoriteIcon(item)
            }
            binding.executePendingBindings()

        }

        fun setFavoriteIcon(item: TrackEntity){
            if(item.isFavorite!!){
                setImage(context, R.drawable.icon_favorite_trck_selected, binding.favoriteButton)
            }else{
                setImage(context, R.drawable.icon_favorite_trck_unselected, binding.favoriteButton)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }
}

class TrackListDiffCallback : DiffUtil.ItemCallback<TrackEntity>() {
    override fun areItemsTheSame(oldItem: TrackEntity, newItem: TrackEntity): Boolean {
        return oldItem.trackId == newItem.trackId
    }

    override fun areContentsTheSame(oldItem: TrackEntity, newItem: TrackEntity): Boolean {
        return oldItem == newItem
    }

}