package com.example.nikolaiturev.workout.presentation.workouts

import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.presentation.base.BaseFragment
import com.example.nikolaiturev.workout.presentation.workout_add.WorkoutAddDialog
import kotlinx.android.synthetic.main.app_bar_add.*

class WorkoutsFragment : BaseFragment() {
    override var layoutId: Int = R.layout.fragments_workouts

    private val workoutAddDialog = WorkoutAddDialog()

    override fun initView() {

        app_bar_addWorkout.setOnClickListener {
            workoutAddDialog.show(childFragmentManager, "WorkoutAddDialog")
        }

    }


}