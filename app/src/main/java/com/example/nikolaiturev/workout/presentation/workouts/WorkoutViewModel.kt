package com.example.nikolaiturev.workout.presentation.workouts

import androidx.lifecycle.MutableLiveData
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.domain.repository.WorkoutRepository
import com.example.nikolaiturev.workout.presentation.base.BaseViewModel

class WorkoutViewModel(private val workoutRepository: WorkoutRepository) : BaseViewModel() {

    val workoutLiveData = MutableLiveData<List<Workout>>()

    init {
        getAllWorkout()
    }

    private fun getAllWorkout() {
        disposable {
            workoutRepository.getAllWorkout()
                .doOnSubscribe { isInProgress.value = false }
                .doFinally { isInProgress.value = true }
                .subscribe({
                    workoutLiveData.value = it
                }, {
                    postMessage(it.localizedMessage)
                })
        }
    }

    fun update(workout: Workout) {
        disposable {
            workoutRepository.update(workout)
                .subscribe({}, {
                    postMessage(it.localizedMessage)
                })
        }
    }

    fun delete(workout: Workout) {
        disposable {
            workoutRepository.delete(workout)
                .subscribe({}, {
                    postMessage(it.localizedMessage)
                })
        }
    }

    fun insert(workout: Workout) {
        disposable {
            workoutRepository.insert(workout)
                .subscribe({}, {
                    postMessage(it.localizedMessage)
                })
        }
    }

    fun updateNameById(id: Long, newName: String) {
        disposable {
            workoutRepository.updateNameById(id, newName)
                .subscribe({}, {
                    postMessage(it.localizedMessage)
                })
        }
    }

}