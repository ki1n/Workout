package com.example.nikolaiturev.workout.presentation.workout_details

import androidx.lifecycle.MutableLiveData
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.domain.repository.WorkoutRepository
import com.example.nikolaiturev.workout.presentation.base.BaseViewModel

class WorkoutDetailsViewModel(private val workoutRepository: WorkoutRepository) : BaseViewModel() {

    val workoutLiveData = MutableLiveData<Workout>()

    fun getWorkoutById(id: Long) {
        disposable {
            workoutRepository.getWorkoutById(id)
                .doOnSubscribe { isInProgress.value = true }
                .doFinally { isInProgress.value = false }
                .subscribe(
                    {
                        workoutLiveData.value = it
                    },
                    {
                        postMessage(it.localizedMessage)
                    }
                )
        }
    }

}