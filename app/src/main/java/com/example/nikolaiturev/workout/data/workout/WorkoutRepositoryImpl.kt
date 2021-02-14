package com.example.nikolaiturev.workout.data.workout

import androidx.lifecycle.LiveData
import com.example.nikolaiturev.workout.data.dao.WorkoutDao
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.domain.repository.WorkoutRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WorkoutRepositoryImpl(private val workoutDao: WorkoutDao) : WorkoutRepository{

    override fun getAllWorkout(): Single<List<Workout>> =
        workoutDao.getWorkouts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun getAllLiveDate(): LiveData<List<Workout>> = workoutDao.getAllLiveDate()

}