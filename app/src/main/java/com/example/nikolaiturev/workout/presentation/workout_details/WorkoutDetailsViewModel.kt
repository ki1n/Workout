package com.example.nikolaiturev.workout.presentation.workout_details

import com.example.nikolaiturev.workout.domain.repository.WorkoutRepository
import com.example.nikolaiturev.workout.presentation.base.BaseViewModel

class WorkoutDetailsViewModel(private val workoutRepository: WorkoutRepository) : BaseViewModel(){

    fun getWorkoutById(id: Long) {
        disposable {
            workoutRepository.getWorkoutById(id)
                .doOnSubscribe { isInProgress.value = true }
                .doFinally { isInProgress.value = false }
                .subscribe({}, {
                    postMessage(it.localizedMessage)
                })
        }
    }



}