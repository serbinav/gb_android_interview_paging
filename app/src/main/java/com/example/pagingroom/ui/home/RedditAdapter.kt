package com.example.pagingroom.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingroom.databinding.ItemRedditBinding
import com.example.pagingroom.model.ChildrenDataDTO
import com.example.pagingroom.usePicassoToLoadPhoto
import com.squareup.picasso.Picasso

class RedditAdapter :
    PagingDataAdapter<ChildrenDataDTO, RedditAdapter.RedditViewHolder>(POST_DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditViewHolder {
        val binding =
            ItemRedditBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RedditViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RedditViewHolder, position: Int) {
        val tile = getItem(position)
        if (tile != null) {
            holder.bind(tile)
        }
    }

    inner class RedditViewHolder(private val binding: ItemRedditBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ChildrenDataDTO) {
            with(binding) {
                text.text = data.data.titleText
                btnMessage.text = data.data.numCommentsMessage.toString()
                btnStar.text = data.data.scoreStar.toString()

                if (data.data.thumbnailImage.isNotEmpty()) {
                    usePicassoToLoadPhoto(
                        image,
                        data.data.thumbnailImage,
                        Picasso.Priority.HIGH
                    )
                }
            }
        }
    }

    companion object {
        private val POST_DIFF_CALLBACK = object : DiffUtil.ItemCallback<ChildrenDataDTO>() {
            override fun areItemsTheSame(
                oldItem: ChildrenDataDTO,
                newItem: ChildrenDataDTO
            ): Boolean =
                oldItem.kind == newItem.kind

            override fun areContentsTheSame(
                oldItem: ChildrenDataDTO,
                newItem: ChildrenDataDTO
            ): Boolean =
                oldItem == newItem
        }
    }
}