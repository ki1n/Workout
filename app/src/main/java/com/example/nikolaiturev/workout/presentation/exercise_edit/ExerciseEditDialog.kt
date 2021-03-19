package com.example.nikolaiturev.workout.presentation.exercise_edit

import androidx.navigation.fragment.navArgs
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.exstension.setOnDebouncedClickListener
import com.example.nikolaiturev.workout.presentation.base.BaseBottomSheetFragment
import com.example.nikolaiturev.workout.presentation.workout_exercises.WorkoutExercisesViewModel
import com.example.nikolaiturev.workout.utils.inputCheckEditText
import kotlinx.android.synthetic.main.fragment_exercise_edit_bottom_sheet.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExerciseEditDialog : BaseBottomSheetFragment() {

    override var layoutId: Int = R.layout.fragment_exercise_edit_bottom_sheet

    private val args: ExerciseEditDialogArgs by navArgs()

    private val viewModel by viewModel<WorkoutExercisesViewModel>()

    override fun getTheme(): Int = R.style.Theme_FullScreenDialog

    override fun initView() {

        btSaveEditExercise.setOnDebouncedClickListener {
            if (inputCheckEditText(etNameEditExercise.text.toString())) {
                viewModel.updateExerciseNameById(
                    args.exerciseId,
                    etNameEditExercise.text.toString()
                )
                dismiss()
            }
        }
    }
}
