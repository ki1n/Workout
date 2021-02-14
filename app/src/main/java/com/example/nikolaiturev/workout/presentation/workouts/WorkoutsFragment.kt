package com.example.nikolaiturev.workout.presentation.workouts

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.presentation.base.BaseFragment
import com.example.nikolaiturev.workout.presentation.workout_add.WorkoutAddDialog
import com.example.nikolaiturev.workout.presentation.workouts.adapter.WorkoutsAdapter
import kotlinx.android.synthetic.main.app_bar_add.*
import kotlinx.android.synthetic.main.fragments_workouts.*
import org.koin.android.ext.android.inject

class WorkoutsFragment : BaseFragment() {
    override var layoutId: Int = R.layout.fragments_workouts

    override val viewModel by inject<WorkoutViewModel>()

    private val workoutsAdapter: WorkoutsAdapter by inject()
    private val workoutAddDialog = WorkoutAddDialog()

    override fun initView() {
        initAdapter()

        viewModel.workoutLiveData.observe(viewLifecycleOwner, { list ->
            workoutsAdapter.updateWorkout(list as MutableList<Workout>)
        })

        app_bar_addWorkout.setOnClickListener {
            workoutAddDialog.show(childFragmentManager, "WorkoutAddDialog")
        }

    }

    private fun initAdapter() {
        rvWorkouts.adapter = workoutsAdapter
        rvWorkouts.layoutManager = LinearLayoutManager(requireContext())
    }


}