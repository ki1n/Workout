package com.example.nikolaiturev.workout.presentation.workout_details

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.exstension.setOnDebouncedClickListener
import com.example.nikolaiturev.workout.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.app_bar_workout_details.*
import org.koin.android.ext.android.inject

class WorkoutDetailsFragment : BaseFragment() {
    override var layoutId: Int = R.layout.fragment_details_workout

    private val args: WorkoutDetailsFragmentArgs by navArgs()

    override val viewModel by inject<WorkoutDetailsViewModel>()

    override fun initView() {
        val workoutId = args.workoutIdDetails
        val workout = viewModel.getWorkoutById(workoutId)

        tvNameWorkout.text = workout.toString()

        app_bar_back_in_workouts.setOnDebouncedClickListener {
            findNavController().navigate(R.id.action_workoutDetailsFragment_to_workoutsFragment)
        }

        app_bar_add_exercise.setOnClickListener {
            findNavController().navigate(R.id.action_workoutDetailsFragment_to_exerciseAddFragment)
        }
    }
}