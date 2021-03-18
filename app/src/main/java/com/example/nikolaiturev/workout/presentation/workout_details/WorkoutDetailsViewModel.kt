package com.example.nikolaiturev.workout.presentation.workout_details

import androidx.lifecycle.MutableLiveData
import com.example.nikolaiturev.workout.domain.entity.Exercise
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.domain.repository.ExerciseRepository
import com.example.nikolaiturev.workout.domain.repository.WorkoutRepository
import com.example.nikolaiturev.workout.presentation.base.BaseViewModel
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

class WorkoutDetailsViewModel(
    private val workoutRepository: WorkoutRepository,
    private val exerciseRepository: ExerciseRepository
) : BaseViewModel() {

    val workoutLiveData = MutableLiveData<Workout>()
    val exercisesLiveData = MutableLiveData<List<Exercise>>()

    fun getWorkoutWithExercise(id: Long) {

        exerciseRepository.getWorkoutWithExercise(id)
            .subscribeBy(
                onSuccess = {
                    exercisesLiveData.value = it.exercises
                },
                onError = { postMessage(it.localizedMessage) }
            ).addTo(disposable)
    }

    fun getWorkoutById(id: Long) {

        workoutRepository.getWorkoutById(id)
            .subscribeBy(
                onSuccess = {
                    workoutLiveData.value = it
                },
                onError = {
                    postMessage(it.localizedMessage)
                }
            ).addTo(disposable)
    }
}
