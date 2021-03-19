package com.example.nikolaiturev.workout.presentation.workout_exercises

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.exstension.setOnDebouncedClickListener
import com.example.nikolaiturev.workout.presentation.base.BaseFragment
import com.example.nikolaiturev.workout.presentation.workout_exercises.adapter.WorkoutExercisesAdapter
import kotlinx.android.synthetic.main.app_bar_workout_details.*
import kotlinx.android.synthetic.main.fragment_workout_exercises.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class WorkoutExercisesFragment : BaseFragment() {

    override var layoutId: Int = R.layout.fragment_workout_exercises

    private val args: WorkoutExercisesFragmentArgs by navArgs()

    override val viewModel by viewModel<WorkoutExercisesViewModel>()

    private val workoutExercisesAdapter: WorkoutExercisesAdapter by inject()

    override fun initView() {
        baseSubscribe(viewModel)
        bindViewModel()
        initAdapter()
        viewModel.getWorkoutById(args.workoutIdDetails)
        viewModel.getWorkoutWithExercise(args.workoutIdDetails)

        app_bar_back_in_workouts.setOnDebouncedClickListener {
            findNavController().navigateUp()
        }

        app_bar_add_exercise.setOnDebouncedClickListener {
            findNavController().navigate(
                WorkoutExercisesFragmentDirections.actionWorkoutDetailsFragmentToExerciseAddFragment(
                    args.workoutIdDetails
                )
            )
        }
    }

    private fun initAdapter() {
        rvExercises.adapter = workoutExercisesAdapter

        workoutExercisesAdapter.onDeleteClickListener = { exercise ->
            viewModel.delete(exercise)
        }

        workoutExercisesAdapter.onEditClickListener = { exercise ->
            findNavController().navigate(
                WorkoutExercisesFragmentDirections.actionWorkoutDetailsFragmentToExerciseEditDialog(
                    exercise.id
                )
            )
        }
    }

    private fun bindViewModel() {
        viewModel.workoutLiveData.observe(viewLifecycleOwner, { workout ->
            tvNameWorkout.text = workout.nameWorkout
        })

        viewModel.exercisesLiveData.observe(viewLifecycleOwner, {
            workoutExercisesAdapter.submitList(it)
        })
    }
}
