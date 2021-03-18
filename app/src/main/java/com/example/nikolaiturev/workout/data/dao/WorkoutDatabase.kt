package com.example.nikolaiturev.workout.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nikolaiturev.workout.domain.entity.Exercise
import com.example.nikolaiturev.workout.domain.entity.Workout

@Database(entities = [Workout::class, Exercise::class], version = 1)
abstract class WorkoutDatabase : RoomDatabase() {

    abstract fun workoutDao() : WorkoutDao

}
