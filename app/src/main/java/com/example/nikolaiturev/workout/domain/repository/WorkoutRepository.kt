package com.example.nikolaiturev.workout.domain.repository

import com.example.nikolaiturev.workout.domain.entity.Workout
import io.reactivex.Completable
import io.reactivex.Flowable

interface WorkoutRepository {

    fun getAllWorkout(): Flowable<List<Workout>>

    fun insert(workout: Workout): Completable

    fun delete(workout: Workout): Completable

    fun update(workout: Workout): Completable



    fun updateNameById(id: Long, newName: String): Completable
}