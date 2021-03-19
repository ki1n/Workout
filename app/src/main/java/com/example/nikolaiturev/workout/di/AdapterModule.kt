package com.example.nikolaiturev.workout.di

import com.example.nikolaiturev.workout.presentation.workout_exercises.adapter.WorkoutExercisesAdapter
import com.example.nikolaiturev.workout.presentation.workouts.adapter.WorkoutsAdapter
import org.koin.dsl.module

val adapterModule = module {

    single { WorkoutsAdapter() }

    single { WorkoutExercisesAdapter() }

}
