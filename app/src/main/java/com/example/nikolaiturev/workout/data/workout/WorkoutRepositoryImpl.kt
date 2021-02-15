package com.example.nikolaiturev.workout.data.workout

import com.example.nikolaiturev.workout.data.dao.WorkoutDao
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.domain.repository.WorkoutRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WorkoutRepositoryImpl(private val workoutDao: WorkoutDao) : WorkoutRepository {

    override fun getAllWorkout(): Flowable<List<Workout>> =
        workoutDao.getWorkouts()
            .observeOn(AndroidSchedulers.mainThread())

    override fun insert(workout: Workout): Completable =
        workoutDao.insert(workout)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun delete(workout: Workout): Completable =
        workoutDao.delete(workout)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


    override fun update(workout: Workout): Completable =
        workoutDao.update(workout)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


}