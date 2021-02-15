package com.example.nikolaiturev.workout.presentation.workouts.swipe_to_delete

import android.content.Context
import android.graphics.Canvas
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

abstract class SwipeToDeleteCallback(context: Context) :
    ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return true
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
//        RecyclerViewSwipeDecorator.Builder(
//            c,
//            recyclerView,
//            viewHolder,
//            dX,
//            dY,
//            actionState,
//            isCurrentlyActive
//        )
//            .addBackgroundColor()
//            .addActionIcon()
//            .create()
//            .decorate()


        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }
}