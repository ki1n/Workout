package com.example.nikolaiturev.workout.presentation.exercise

import androidx.navigation.fragment.findNavController
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.exstension.setOnDebouncedClickListener
import com.example.nikolaiturev.workout.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.app_bar_exercise_add.*

class ExerciseAddFragment : BaseFragment() {

    override var layoutId: Int = R.layout.fragment_add_exercise

    override fun initView() {

        app_bar_back_in_workoutDetails.setOnDebouncedClickListener {
            findNavController().navigate(R.id.action_exerciseAddFragment_to_workoutDetailsFragment)
        }

    }
}