package com.example.nikolaiturev.workout.presentation.workouts.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.exstension.inflate
import com.example.nikolaiturev.workout.exstension.setOnDebouncedClickListener

class WorkoutsAdapter : ListAdapter<Workout, WorkoutsViewHolder>(WorkoutsDiffCallback()) {

    lateinit var onClickListener: ((Workout) -> Unit)
    lateinit var onEditClickListener: ((Workout) -> Unit)
    lateinit var onDeleteClickListener: ((Workout) -> Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutsViewHolder {
        return WorkoutsViewHolder(parent.inflate(R.layout.item_workout))
    }

    override fun onBindViewHolder(holder: WorkoutsViewHolder, position: Int) {
        val currentWorkout = currentList[position]

        with(holder) {
            positionWorkout.text = (position + 1).toString()
            bind(currentWorkout)

            itemView.setOnDebouncedClickListener {
                onClickListener.invoke(currentWorkout)
            }

            imageEditWorkout.setOnDebouncedClickListener {
                onEditClickListener.invoke(currentWorkout)
            }

            imageDeleteWorkout.setOnDebouncedClickListener {
                onDeleteClickListener.invoke(currentWorkout)
            }
        }
    }
}
