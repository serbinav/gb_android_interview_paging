package com.example.pagingroom

import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

fun usePicassoToLoadPhoto(
    imageView: ImageView,
    imageLink: String,
    priority: Picasso.Priority = Picasso.Priority.LOW
) {
    Picasso.get().load(imageLink)
        .placeholder(R.drawable.ic_baseline_image_24).fit()
        .priority(priority)
        .into(imageView, object : Callback {
            override fun onSuccess() {
            }

            override fun onError(e: Exception?) {
                imageView.setImageResource(R.drawable.ic_baseline_error_outline_24)
            }
        })
}