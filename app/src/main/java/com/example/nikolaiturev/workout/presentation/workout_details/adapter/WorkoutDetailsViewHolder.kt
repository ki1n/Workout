package com.example.nikolaiturev.workout.presentation.workout_details.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.swipe.SwipeLayout
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.domain.entity.Exercise
import com.example.nikolaiturev.workout.utils.SwipeListener

class WorkoutDetailsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val idExercise : TextView = view.findViewById(R.id.tvIdExercise)
    private val nameExercise : TextView = view.findViewById(R.id.tvNameExercise)
    val imageDeleteExercise: ImageView = view.findViewById(R.id.image_delete_exercise)
    val imageEditExercise: ImageView = view.findViewById(R.id.image_edit_exercise)
    private val swipeLayoutExercise: SwipeLayout = view.findViewById(R.id.swipe_layout_exercise)

    fun bind(exercise: Exercise) {
        idExercise.text = exercise.id.toString()
        nameExercise.text = exercise.nameExercise

        swipeLayoutExercise.addSwipeListener(SwipeListener(this))
        swipeLayoutExercise.removeAllSwipeDeniers()
    }

}
