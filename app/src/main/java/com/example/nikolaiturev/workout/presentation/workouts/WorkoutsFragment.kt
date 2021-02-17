package com.example.nikolaiturev.workout.presentation.workouts

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.exstension.setOnDebouncedClickListener
import com.example.nikolaiturev.workout.presentation.base.BaseFragment
import com.example.nikolaiturev.workout.presentation.workouts.adapter.WorkoutsAdapter
import kotlinx.android.synthetic.main.app_bar_workouts.*
import kotlinx.android.synthetic.main.fragment_workouts.*
import org.koin.android.ext.android.inject

class WorkoutsFragment : BaseFragment() {
    override var layoutId: Int = R.layout.fragment_workouts

    override val viewModel by inject<WorkoutViewModel>()

    private val workoutsAdapter: WorkoutsAdapter by inject()

    override fun initView() {
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
        rvWorkouts.layoutManager = LinearLayoutManager(requireContext())

        workoutsAdapter.onClickListener = { workout ->
            findNavController().navigate(R.id.action_workoutsFragment_to_workoutDetailsFragment)
        }

        workoutsAdapter.onEditClickListener = { workout ->
            val action =
                WorkoutsFragmentDirections.actionWorkoutsFragmentToWorkoutEditDialog(workout.id)
            findNavController().navigate(action)
        }

        workoutsAdapter.onDeleteClickListener = { workout ->
            viewModel.delete(workout)
        }
    }

}