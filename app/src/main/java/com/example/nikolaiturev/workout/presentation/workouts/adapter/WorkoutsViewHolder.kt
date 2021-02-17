package com.example.nikolaiturev.workout.presentation.workouts.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.swipe.SwipeLayout
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.utils.SwipeListener
import com.example.nikolaiturev.workout.utils.dateTimeConverter

class WorkoutsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val id: TextView = view.findViewById(R.id.txtIdWorkout)
    val name: TextView = view.findViewById(R.id.tvNameExercise)
    val date: TextView = view.findViewById(R.id.tvApproaches)
    val imageDelete: ImageView = view.findViewById(R.id.image_delete)
    val imageEdit: ImageView = view.findViewById(R.id.image_edit)
    val swipe_layout: SwipeLayout = view.findViewById(R.id.swipe_layout)

    fun bind(workout: Workout) {
        id.text = workout.id.toString()
        name.text = workout.name
        date.text = dateTimeConverter(workout.date)

        swipe_layout.addSwipeListener(SwipeListener(this))
        swipe_layout.removeAllSwipeDeniers()
    }
}