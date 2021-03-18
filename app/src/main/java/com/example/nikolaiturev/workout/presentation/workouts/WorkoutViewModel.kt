package com.example.nikolaiturev.workout.presentation.workouts

import androidx.lifecycle.MutableLiveData
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.domain.repository.WorkoutRepository
import com.example.nikolaiturev.workout.presentation.base.BaseViewModel
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

class WorkoutViewModel(private val workoutRepository: WorkoutRepository) : BaseViewModel() {

    val workoutLiveData = MutableLiveData<List<Workout>>()

    init {
        getAllWorkout()
    }

    private fun getAllWorkout() {
        workoutRepository.getAllWorkout()
            .doOnSubscribe { isInProgress.value = false }
            .doFinally { isInProgress.value = true }
            .subscribeBy(
                onNext = { workoutLiveData.value = it },
                onError = { it.localizedMessage }
            ).addTo(disposable)
    }

    fun update(workout: Workout) {
        workoutRepository.update(workout)
            .subscribeBy(
                onComplete = {
                    // ignore
                },
                onError = {
                    postMessage(it.localizedMessage)
                }
            )
            .addTo(disposable)
    }

    fun delete(workout: Workout) {
        workoutRepository.delete(workout)
            .subscribeBy(
                onComplete = {
                    // ignore
                },
                onError = {
                    postMessage(it.localizedMessage)
                }).addTo(disposable)
    }


    fun insert(workout: Workout) {
        workoutRepository.insert(workout)
            .subscribeBy(
                onError = {
                    postMessage(it.localizedMessage)
                }).addTo(disposable)
    }


    fun updateNameById(id: Long, newName: String) {

        workoutRepository.updateNameById(id, newName)
            .subscribeBy(
                onError = {
                    postMessage(it.localizedMessage)
                }).addTo(disposable)
    }
}

