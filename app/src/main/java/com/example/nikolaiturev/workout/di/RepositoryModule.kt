package com.example.nikolaiturev.workout.di

import com.example.nikolaiturev.workout.data.exercise.ExerciseRepositoryImpl
import com.example.nikolaiturev.workout.data.workout.WorkoutRepositoryImpl
import com.example.nikolaiturev.workout.domain.repository.ExerciseRepository
import com.example.nikolaiturev.workout.domain.repository.WorkoutRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { WorkoutRepositoryImpl(get()) as WorkoutRepository }
    single { ExerciseRepositoryImpl(get()) as ExerciseRepository }

}
