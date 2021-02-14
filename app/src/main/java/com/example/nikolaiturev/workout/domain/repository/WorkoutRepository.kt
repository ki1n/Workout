package com.example.nikolaiturev.workout.domain.repository

import androidx.lifecycle.LiveData
import com.example.nikolaiturev.workout.domain.entity.Workout
import io.reactivex.Single

interface WorkoutRepository {

    fun getAllWorkout() : Single<List<Workout>>

    fun getAllLiveDate(): LiveData<List<Workout>>
}