package com.example.nikolaiturev.workout.presentation.workouts.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.exstension.inflate
import com.example.nikolaiturev.workout.exstension.setOnDebouncedClickListener

class WorkoutsAdapter : ListAdapter<Workout, WorkoutsViewHolder>(ExerciseDiffCallback()) {

    lateinit var onClickListener: ((Workout) -> Unit)
    lateinit var onEditClickListener: ((Workout) -> Unit)
    lateinit var onDeleteClickListener: ((Workout) -> Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutsViewHolder {
        return WorkoutsViewHolder(parent.inflate(R.layout.item_workout))
    }

    override fun onBindViewHolder(holder: WorkoutsViewHolder, position: Int) {
        val currentWorkout = currentList[position]
        with(holder) {
            bind(currentWorkout)

            itemView.setOnDebouncedClickListener {
                onClickListener.invoke(currentWorkout)
            }

            imageEdit.setOnDebouncedClickListener {
                onEditClickListener.invoke(currentWorkout)
            }

            imageDelete.setOnDebouncedClickListener {
                onDeleteClickListener.invoke(currentWorkout)
            }

        }
    }

    class ExerciseDiffCallback : DiffUtil.ItemCallback<Workout>() {
        override fun areItemsTheSame(oldItem: Workout, newItem: Workout): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Workout, newItem: Workout): Boolean {
            return oldItem == newItem
        }
    }
}
