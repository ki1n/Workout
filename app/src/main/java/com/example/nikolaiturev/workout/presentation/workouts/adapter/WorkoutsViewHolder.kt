package com.example.nikolaiturev.workout.presentation.workouts.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.util.dateTimeConverter

class WorkoutsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val id: TextView = view.findViewById(R.id.txtIdWorkout)
    private val name: TextView = view.findViewById(R.id.txtNameWorkout)
    private val date: TextView = view.findViewById(R.id.txtDateCreateWorkout)

    fun bind(workout: Workout) {
        id.text = workout.id.toString()
        name.text = workout.name
        date.text = dateTimeConverter(workout.date)
    }
}