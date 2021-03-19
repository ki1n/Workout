package com.example.nikolaiturev.workout.data.exercise

import com.example.nikolaiturev.workout.data.dao.WorkoutDao
import com.example.nikolaiturev.workout.domain.entity.Exercise
import com.example.nikolaiturev.workout.domain.entity.WorkoutWithExercise
import com.example.nikolaiturev.workout.domain.repository.ExerciseRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ExerciseRepositoryImpl(private val workoutDao: WorkoutDao) : ExerciseRepository {
    override fun insert(exercise: Exercise): Completable =
        workoutDao.insertExercise(exercise)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun delete(exercise: Exercise): Completable =
        workoutDao.deleteExercise(exercise)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun update(exercise: Exercise): Completable =
        workoutDao.updateExercise(exercise)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun getWorkoutWithExercise(id: Long): Flowable<WorkoutWithExercise> =
        workoutDao.getWorkoutWithExercise(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun updateExerciseNameById(id: Long, newName: String): Completable =
        workoutDao.updateExerciseNameById(id, newName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}
