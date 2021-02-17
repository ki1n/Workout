package com.example.nikolaiturev.workout.presentation.workout_edit

import androidx.navigation.fragment.navArgs
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.exstension.setOnDebouncedClickListener
import com.example.nikolaiturev.workout.presentation.base.BaseBottomSheetFragment
import com.example.nikolaiturev.workout.presentation.workouts.WorkoutViewModel
import com.example.nikolaiturev.workout.utils.inputCheckEditText
import kotlinx.android.synthetic.main.fragment_workout_edit_bottom_sheet.*
import org.koin.android.ext.android.inject

class WorkoutEditDialog : BaseBottomSheetFragment() {
    override var layoutId: Int = R.layout.fragment_workout_edit_bottom_sheet

    private val args: WorkoutEditDialogArgs by navArgs()

    private val viewModel by inject<WorkoutViewModel>()

    override fun initView() {

        btSaveEditWorkout.setOnDebouncedClickListener {
            if (inputCheckEditText(etNameEditWorkout.text.toString())) {
                viewModel.updateNameById(args.workoutId, newName = etNameEditWorkout.text.toString())
                dismiss()
            }
        }
    }
}







