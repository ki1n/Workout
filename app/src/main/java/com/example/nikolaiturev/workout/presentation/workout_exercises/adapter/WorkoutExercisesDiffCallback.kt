package com.example.nikolaiturev.workout.presentation.workout_exercises.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.nikolaiturev.workout.domain.entity.Exercise

class WorkoutExercisesDiffCallback : DiffUtil.ItemCallback<Exercise>() {
    override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
        return oldItem == newItem
    }
}