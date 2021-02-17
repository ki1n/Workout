package com.example.nikolaiturev.workout.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.nikolaiturev.workout.domain.entity.Workout
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface WorkoutDao {
    @Query("SELECT * FROM Workout ORDER BY id")
    fun getAllLiveDate(): LiveData<List<Workout>>

    @Query("SELECT * FROM Workout ORDER BY id")
    fun getWorkouts(): Flowable<List<Workout>>

    @Query("SELECT * FROM Workout WHERE id = :id")
    fun getWorkout(id: Long): Single<Workout>

    @Query("DELETE FROM Workout WHERE id = :id")
    fun deleteById(id: Long)

    @Query("UPDATE Workout SET name = :newName WHERE id = :id")
    fun updateNameById(id: Long, newName: String) : Completable

//    fun save(workout: Workout) =
//        if (workout.id == 0L) insert(workout) else updateNameById(workout.id, workout.name)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(workout: Workout) : Completable

    @Update
    fun update(workout: Workout) : Completable

    @Delete
    fun delete(workout: Workout) : Completable

}