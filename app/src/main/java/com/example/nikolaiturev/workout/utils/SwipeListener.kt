package com.example.nikolaiturev.workout.utils

import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.swipe.SwipeLayout

class SwipeListener constructor(private val holder: RecyclerView.ViewHolder) :
    SwipeLayout.SwipeListener {
    override fun onClose(layout: SwipeLayout?) {
        Handler(Looper.getMainLooper()).postDelayed({
            holder.itemView.isClickable = true
        }, 300)
    }

    override fun onHandRelease(layout: SwipeLayout?, xvel: Float, yvel: Float) {
    }

    override fun onStartClose(layout: SwipeLayout?) {
        holder.itemView.isClickable = false
    }

    override fun onStartOpen(layout: SwipeLayout?) {
        holder.itemView.isClickable = false
    }

    override fun onUpdate(layout: SwipeLayout?, leftOffset: Int, topOffset: Int) {
    }

    override fun onOpen(layout: SwipeLayout?) {
        holder.itemView.isClickable = false
    }
}