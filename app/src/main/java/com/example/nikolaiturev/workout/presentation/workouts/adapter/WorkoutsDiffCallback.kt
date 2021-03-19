package com.example.nikolaiturev.workout.presentation.workouts.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.nikolaiturev.workout.domain.entity.Workout

class WorkoutsDiffCallback : DiffUtil.ItemCallback<Workout>() {
    override fun areItemsTheSame(oldItem: Workout, newItem: Workout): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Workout, newItem: Workout): Boolean {
        return oldItem == newItem
    }
}
