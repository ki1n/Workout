package com.example.nikolaiturev.workout.domain.entity

import androidx.room.Relation

data class WorkoutWithExercise(
    val id: Long,
    val name: String,

    @Relation(parentColumn = "id", entityColumn = "workoutId")
    val exercises: List<Exercise>

)
