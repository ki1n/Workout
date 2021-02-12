package com.example.nikolaiturev.workout.di

import androidx.room.Room
import com.example.nikolaiturev.workout.data.dao.WorkoutDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidApplication(), WorkoutDatabase::class.java, "database.db")
            .build()
    }
    single { get<WorkoutDatabase>().workoutDao() }
}