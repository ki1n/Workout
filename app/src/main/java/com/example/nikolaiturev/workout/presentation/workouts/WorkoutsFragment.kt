package com.example.nikolaiturev.workout.presentation.workouts

import androidx.navigation.fragment.findNavController
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.exstension.setOnDebouncedClickListener
import com.example.nikolaiturev.workout.presentation.base.BaseFragment
import com.example.nikolaiturev.workout.presentation.workouts.adapter.WorkoutsAdapter
import kotlinx.android.synthetic.main.app_bar_workouts.*
import kotlinx.android.synthetic.main.fragment_workouts.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class WorkoutsFragment : BaseFragment() {

    override var layoutId: Int = R.layout.fragment_workouts

    override val viewModel by viewModel<WorkoutViewModel>()

    private val workoutsAdapter: WorkoutsAdapter by inject()

    override fun initView() {
        baseSubscribe(viewModel)
        initAdapter()

        viewModel.workoutLiveData.observe(viewLifecycleOwner, { list ->
            workoutsAdapter.submitList(list)
        })

        app_bar_add_workout.setOnDebouncedClickListener {
            findNavController().navigate(R.id.action_workoutsFragment_to_workoutAddDialog)
        }
    }

    private fun initAdapter() {
        rvWorkouts.adapter = workoutsAdapter

        workoutsAdapter.onClickListener = { workout ->
            findNavController()
                .navigate(
                    WorkoutsFragmentDirections.actionWorkoutsFragmentToWorkoutDetailsFragment(
                        workout.id
                    )
                )
        }

        workoutsAdapter.onEditClickListener = { workout ->
            findNavController().navigate(
                WorkoutsFragmentDirections.actionWorkoutsFragmentToWorkoutEditDialog(workout.id)
            )
        }

        workoutsAdapter.onDeleteClickListener = { workout ->
            viewModel.delete(workout)
        }
    }
}
