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

    private val idWorkout: TextView = view.findViewById(R.id.txtIdWorkout)
    private val nameWorkout: TextView = view.findViewById(R.id.tvNameExercise)
    private val date: TextView = view.findViewById(R.id.tvDateWorkout)
    val imageDeleteWorkout: ImageView = view.findViewById(R.id.image_delete_workout)
    val imageEditWorkout: ImageView = view.findViewById(R.id.image_edit_workout)
    private val swipeLayoutWorkout: SwipeLayout = view.findViewById(R.id.swipe_layout_workout)

    fun bind(workout: Workout) {
        idWorkout.text = workout.id.toString()
        nameWorkout.text = workout.nameWorkout
        date.text = dateTimeConverter(workout.date)

        swipeLayoutWorkout.addSwipeListener(SwipeListener(this))
        swipeLayoutWorkout.removeAllSwipeDeniers()
    }
}
