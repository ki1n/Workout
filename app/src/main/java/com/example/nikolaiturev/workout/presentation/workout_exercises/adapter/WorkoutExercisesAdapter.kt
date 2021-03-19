package com.example.nikolaiturev.workout.presentation.workout_exercises.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.domain.entity.Exercise
import com.example.nikolaiturev.workout.exstension.inflate
import com.example.nikolaiturev.workout.exstension.setOnDebouncedClickListener

class WorkoutExercisesAdapter :
    ListAdapter<Exercise, WorkoutExercisesViewHolder>(WorkoutExercisesDiffCallback()) {

    lateinit var onClickListener: ((Exercise) -> Unit)
    lateinit var onEditClickListener: ((Exercise) -> Unit)
    lateinit var onDeleteClickListener: ((Exercise) -> Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutExercisesViewHolder {
        return WorkoutExercisesViewHolder(parent.inflate(R.layout.item_exercise))
    }

    override fun onBindViewHolder(holder: WorkoutExercisesViewHolder, position: Int) {
        val currentExercise = currentList[position]

        with(holder) {
            positionExercise.text = (position + 1).toString()
            bind(currentExercise)

            imageEditExercise.setOnDebouncedClickListener {
                onEditClickListener.invoke(currentExercise)
            }

            imageDeleteExercise.setOnDebouncedClickListener {
                onDeleteClickListener.invoke(currentExercise)
            }

        }
    }
}
