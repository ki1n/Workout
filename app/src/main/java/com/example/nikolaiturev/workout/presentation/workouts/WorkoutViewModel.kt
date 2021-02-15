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
                .doOnSubscribe { isInProgress.value = false }
                .doFinally { isInProgress.value = true }
                .subscribe({
                    workoutLiveData.value = it
                    Log.d("Log", "$it")
                }, {
                    postMessage(it.localizedMessage)
                })
        }
    }

    fun update(workout: Workout) {
        workoutRepository.update(workout)
            .subscribe()
    }

    fun delete(workout: Workout) {
        workoutRepository.delete(workout)
            .subscribe()
    }

    fun insert(workout: Workout){
        workoutRepository.insert(workout)
            .subscribe()
    }

}