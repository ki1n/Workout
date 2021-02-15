package com.example.nikolaiturev.workout.data.workout

import androidx.lifecycle.LiveData
import com.example.nikolaiturev.workout.data.dao.WorkoutDao
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.domain.repository.WorkoutRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers

class WorkoutRepositoryImpl(private val workoutDao: WorkoutDao) : WorkoutRepository{

    override fun getAllWorkout(): Flowable<List<Workout>> =
        workoutDao.getWorkouts()
           // .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())

    override fun getAllLiveDate(): LiveData<List<Workout>> = workoutDao.getAllLiveDate()

}