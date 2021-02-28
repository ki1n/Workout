package com.example.nikolaiturev.workout.di

import com.example.nikolaiturev.workout.presentation.workout_details.WorkoutDetailsViewModel
import com.example.nikolaiturev.workout.presentation.workouts.WorkoutViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { WorkoutViewModel(get()) }
    viewModel { WorkoutDetailsViewModel(get()) }

}