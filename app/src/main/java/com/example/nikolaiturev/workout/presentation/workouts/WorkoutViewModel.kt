package com.example.nikolaiturev.workout.presentation.workouts

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.domain.repository.WorkoutRepository
import com.example.nikolaiturev.workout.presentation.base.BaseViewModel

class WorkoutViewModel(private val workoutRepository: WorkoutRepository) : BaseViewModel() {

    val workoutLiveData = MutableLiveData<List<Workout>>()

    init {
        getWorkout()
    }

    private fun getWorkout() {
        disposable {
            workoutRepository.getAllWorkout()
                .doOnSubscribe { isInProgress.value = true }
                .doFinally { isInProgress.value = false }
                .subscribe({
                    workoutLiveData.value = it
                    Log.e("Log", "$it")
                }, {
                    postMessage(it.localizedMessage)
                })
        }
    }

}