package com.example.nikolaiturev.workout.presentation.exercise

import com.example.nikolaiturev.workout.domain.entity.Exercise
import com.example.nikolaiturev.workout.domain.repository.ExerciseRepository
import com.example.nikolaiturev.workout.presentation.base.BaseViewModel
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

class ExerciseAddFragmentViewModel(
    private val exerciseRepository: ExerciseRepository
) : BaseViewModel() {

    fun insert(exercise: Exercise) {
        exerciseRepository.insert(exercise)
            .subscribeBy(
                onError = {
                    postMessage(it.localizedMessage)
                }
            ).addTo(disposable)
    }
}
