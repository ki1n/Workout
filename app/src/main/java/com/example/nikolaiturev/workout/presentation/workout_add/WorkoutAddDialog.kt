package com.example.nikolaiturev.workout.presentation.workout_add

import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.exstension.setOnDebouncedClickListener
import com.example.nikolaiturev.workout.presentation.base.BaseBottomSheetFragment
import com.example.nikolaiturev.workout.presentation.workouts.WorkoutViewModel
import com.example.nikolaiturev.workout.utils.getDateTime
import com.example.nikolaiturev.workout.utils.inputCheckEditText
import kotlinx.android.synthetic.main.fragment_workout_add_bottom_sheet.*
import org.koin.android.ext.android.inject

class WorkoutAddDialog : BaseBottomSheetFragment() {

    private val viewModel by inject<WorkoutViewModel>()

    override var layoutId: Int = R.layout.fragment_workout_add_bottom_sheet

    override fun initView() {

        btSaveAddExercise.setOnDebouncedClickListener {
            if (inputCheckEditText(etNameAddWorkout.text.toString())) {
                // не надо создавать тренировку
                val workout = Workout(0, etNameAddWorkout.text.toString(), getDateTime())
                viewModel.insert(workout)
                dismiss()
            }
        }
    }
}





