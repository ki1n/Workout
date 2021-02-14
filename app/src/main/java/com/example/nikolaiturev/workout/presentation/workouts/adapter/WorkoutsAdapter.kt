package com.example.nikolaiturev.workout.presentation.workouts.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.exstension.inflate

class WorkoutsAdapter : RecyclerView.Adapter<WorkoutsViewHolder>(){
    private var workouts = mutableListOf<Workout>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutsViewHolder {
       return WorkoutsViewHolder(parent.inflate(R.layout.item_workout))
    }

    override fun onBindViewHolder(holder: WorkoutsViewHolder, position: Int) {
        val currentWorkout = workouts[position]
        holder.bind(currentWorkout)
    }

    override fun getItemCount(): Int = workouts.size

    fun updateWorkout(list: MutableList<Workout>) {
        workouts.addAll(list)
        notifyDataSetChanged()
    }
}