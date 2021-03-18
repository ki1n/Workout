package com.example.nikolaiturev.workout.domain.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Exercise(

    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @ColumnInfo(name = "nameExercise")
    var nameExercise: String,

    @ColumnInfo(name = "workoutId")
    var workoutId : Long

) : Parcelable
