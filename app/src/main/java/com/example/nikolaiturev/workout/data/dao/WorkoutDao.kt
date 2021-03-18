package com.example.nikolaiturev.workout.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.nikolaiturev.workout.domain.entity.Exercise
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.domain.entity.WorkoutWithExercise
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface WorkoutDao {
    @Query("SELECT * FROM Workout ORDER BY id")
    fun getAllLiveDate(): LiveData<List<Workout>>

    @Query("SELECT id, name FROM WORKOUT WHERE id = :id")
    fun getWorkoutWithExercise(id: Long): Single<WorkoutWithExercise>

    @Query("SELECT * FROM Workout ORDER BY id")
    fun getWorkouts(): Flowable<List<Workout>>

    @Query("SELECT * FROM Workout WHERE id = :id")
    fun getWorkoutById(id: Long): Single<Workout>

    @Query("DELETE FROM Workout WHERE id = :id")
    fun deleteById(id: Long)

    @Query("UPDATE Workout SET name = :newName WHERE id = :id")
    fun updateNameById(id: Long, newName: String): Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertWorkout(workout: Workout): Completable

    @Update
    fun updateWorkout(workout: Workout): Completable

    @Delete
    fun deleteWorkout(workout: Workout): Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertExercise(exercise: Exercise): Completable

    @Update
    fun updateExercise(exercise: Exercise): Completable

    @Delete
    fun deleteExercise(exercise: Exercise): Completable

}
