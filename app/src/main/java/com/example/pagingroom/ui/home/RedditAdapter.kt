package com.example.pagingroom.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingroom.databinding.ItemRedditBinding
import com.example.pagingroom.model.ChildrenDataDTO
import com.example.pagingroom.usePicassoToLoadPhoto
import com.squareup.picasso.Picasso

class RedditAdapter(
    private val onItemClick: () -> Unit
) : ListAdapter<ChildrenDataDTO, RedditAdapter.RedditViewHolder>(RedditItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditViewHolder {
        val binding =
            ItemRedditBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RedditViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RedditViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class RedditViewHolder(private val binding: ItemRedditBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ChildrenDataDTO) {
            with(binding) {
                text.text = data.data.titleText
                btnMessage.text = data.data.numCommentsMessage.toString()
                btnStar.text = data.data.scoreStar.toString()

                if (data.data.thumbnailImage.isNotEmpty()) {
                    usePicassoToLoadPhoto(image, data.data.thumbnailImage, Picasso.Priority.HIGH)
                }
                btnMessage.setOnClickListener { onItemClick.invoke() }
            }
        }
    }
}

class RedditItemCallback : DiffUtil.ItemCallback<ChildrenDataDTO>() {
    override fun areItemsTheSame(oldItem: ChildrenDataDTO, newItem: ChildrenDataDTO): Boolean {
        return oldItem.kind == newItem.kind
    }

    override fun areContentsTheSame(oldItem: ChildrenDataDTO, newItem: ChildrenDataDTO): Boolean {
        return oldItem == newItem
    }
}