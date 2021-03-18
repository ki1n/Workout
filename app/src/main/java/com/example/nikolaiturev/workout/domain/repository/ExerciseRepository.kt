package com.example.nikolaiturev.workout.domain.repository

import com.example.nikolaiturev.workout.domain.entity.Exercise
import com.example.nikolaiturev.workout.domain.entity.WorkoutWithExercise
import io.reactivex.Completable
import io.reactivex.Single

interface ExerciseRepository {

    fun insert(exercise: Exercise): Completable

    fun delete(exercise: Exercise): Completable

    fun update(exercise: Exercise): Completable

    fun getWorkoutWithExercise(id: Long): Single<WorkoutWithExercise>

}
