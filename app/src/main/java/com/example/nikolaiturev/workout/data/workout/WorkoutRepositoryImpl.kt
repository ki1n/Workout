package com.example.nikolaiturev.workout.data.workout

import com.example.nikolaiturev.workout.data.dao.WorkoutDao
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.domain.repository.WorkoutRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WorkoutRepositoryImpl(private val workoutDao: WorkoutDao) : WorkoutRepository {

    override fun getAllWorkout(): Flowable<List<Workout>> =
        workoutDao.getWorkouts()
            .observeOn(AndroidSchedulers.mainThread())

    override fun insert(workout: Workout): Completable =
        workoutDao.insertWorkout(workout)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun delete(workout: Workout): Completable =
        workoutDao.deleteWorkout(workout)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


    override fun update(workout: Workout): Completable =
        workoutDao.updateWorkout(workout)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun getWorkoutById(id: Long): Single<Workout> =
        workoutDao.getWorkoutById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun updateNameById(id: Long, newName: String): Completable =
        workoutDao.updateNameById(id, newName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}
