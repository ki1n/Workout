package com.example.nikolaiturev.workout.presentation.workout_details

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.exstension.setOnDebouncedClickListener
import com.example.nikolaiturev.workout.presentation.base.BaseFragment
import com.example.nikolaiturev.workout.presentation.workout_details.adapter.WorkoutDetailsAdapter
import kotlinx.android.synthetic.main.app_bar_workout_details.*
import kotlinx.android.synthetic.main.fragment_details_workout.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class WorkoutDetailsFragment : BaseFragment() {

    override var layoutId: Int = R.layout.fragment_details_workout

    private val args: WorkoutDetailsFragmentArgs by navArgs()

    override val viewModel by viewModel<WorkoutDetailsViewModel>()
    private val  workoutDetailsAdapter: WorkoutDetailsAdapter by inject()

    override fun initView() {
        bindViewModel()
        initAdapter()
        // посмотри как получать аргементы во viewmodel
        viewModel.getWorkoutById(args.workoutIdDetails)

        app_bar_back_in_workouts.setOnDebouncedClickListener {
            findNavController().navigate(R.id.action_workoutDetailsFragment_to_workoutsFragment)
        }

        app_bar_add_exercise.setOnDebouncedClickListener {
            findNavController().navigate(R.id.action_workoutDetailsFragment_to_exerciseAddFragment)
        }
    }

    private fun initAdapter() {
        rvExercises.adapter = workoutDetailsAdapter
    }

    private fun bindViewModel(){
        viewModel.workoutLiveData.observe(viewLifecycleOwner, { workout ->
            tvNameWorkout.text = workout.nameWorkout
        })

        viewModel.exercisesLiveData.observe(viewLifecycleOwner,{
            workoutDetailsAdapter.submitList(it)
        })
    }


}
