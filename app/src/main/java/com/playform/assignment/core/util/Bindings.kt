package com.playform.assignment.core.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("app:src")
fun loadPic(view: ImageView, src: String?) {
  Glide.with(view).load(src).into(view)
}