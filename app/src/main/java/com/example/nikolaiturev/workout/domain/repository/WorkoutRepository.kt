package com.example.nikolaiturev.workout.domain.repository

import androidx.lifecycle.LiveData
import com.example.nikolaiturev.workout.domain.entity.Workout
import io.reactivex.Flowable

interface WorkoutRepository {

    fun getAllWorkout() : Flowable<List<Workout>>

    fun getAllLiveDate(): LiveData<List<Workout>>
}