package com.fefe.mystationaryproject.utils.ext

import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions

fun ImageView.setImageUrl(
        url: String?,
        @DrawableRes noImageRes: Int = 0,
        listener: RequestListener<Drawable>? = null) {
    Glide.with(context).load(url)
            .transition(withCrossFade(300))
            .apply(RequestOptions()
                    .error(noImageRes))
            .listener(listener)
            .into(this)
}

fun ImageView.setImageUrlWithCircle(
        url: String?,
        @DrawableRes noImageRes: Int = 0,
        listener: RequestListener<Drawable>? = null) {
    Glide.with(context)
            .load(url)
            .transition(withCrossFade(300))
            .apply(RequestOptions().circleCrop().error(noImageRes))
            .listener(listener)
            .into(this)
}