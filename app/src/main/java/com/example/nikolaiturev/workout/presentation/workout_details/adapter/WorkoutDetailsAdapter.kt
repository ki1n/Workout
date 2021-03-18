package com.example.nikolaiturev.workout.presentation.workout_details.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.domain.entity.Exercise
import com.example.nikolaiturev.workout.exstension.inflate
import com.example.nikolaiturev.workout.exstension.setOnDebouncedClickListener

class WorkoutDetailsAdapter :
    ListAdapter<Exercise, WorkoutDetailsViewHolder>(ExerciseDiffCallback()) {

    lateinit var onClickListener: ((Exercise) -> Unit)
    lateinit var onEditClickListener: ((Exercise) -> Unit)
    lateinit var onDeleteClickListener: ((Exercise) -> Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutDetailsViewHolder {
        return WorkoutDetailsViewHolder(parent.inflate(R.layout.item_exercise))
    }

    override fun onBindViewHolder(holder: WorkoutDetailsViewHolder, position: Int) {
        val currentExercise = currentList[position]
        with(holder) {
            bind(currentExercise)

            itemView.setOnDebouncedClickListener {
                onClickListener.invoke(currentExercise)
            }

            imageEditExercise.setOnDebouncedClickListener {
                onEditClickListener.invoke(currentExercise)
            }

            imageDeleteExercise.setOnDebouncedClickListener {
                onDeleteClickListener.invoke(currentExercise)
            }

        }
    }
}
