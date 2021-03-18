package com.example.nikolaiturev.workout.presentation.exercise

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.domain.entity.Exercise
import com.example.nikolaiturev.workout.exstension.setOnDebouncedClickListener
import com.example.nikolaiturev.workout.presentation.base.BaseFragment
import com.example.nikolaiturev.workout.utils.inputCheckEditText
import kotlinx.android.synthetic.main.app_bar_exercise_add.*
import kotlinx.android.synthetic.main.fragment_add_exercise.*
import org.koin.android.ext.android.inject

class ExerciseAddFragment : BaseFragment() {

    override var layoutId: Int = R.layout.fragment_add_exercise

    override val viewModel by inject<ExerciseAddFragmentViewModel>()

    private val args: ExerciseAddFragmentArgs by navArgs()

    override fun initView() {
        baseSubscribe(viewModel)

        app_bar_back_in_workoutDetails.setOnDebouncedClickListener {
            findNavController().navigateUp()
        }

        btSaveAddExercise.setOnDebouncedClickListener {
            if (inputCheckEditText(etNameAddExercise.text.toString())) {

                val exercise =
                    Exercise(0, etNameAddExercise.text.toString(), args.workoutIdExerciseAdd)
                viewModel.insert(exercise)
                findNavController().navigateUp()
            }
        }
    }
}
