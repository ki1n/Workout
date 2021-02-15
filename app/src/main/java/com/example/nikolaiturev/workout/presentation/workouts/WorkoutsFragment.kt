package com.example.nikolaiturev.workout.presentation.workouts

import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.presentation.base.BaseFragment
import com.example.nikolaiturev.workout.presentation.workout_add.WorkoutAddDialog
import com.example.nikolaiturev.workout.presentation.workouts.adapter.WorkoutsAdapter
import com.example.nikolaiturev.workout.presentation.workouts.swipe_to_delete.SwipeToDeleteCallback
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
            workoutsAdapter.updateWorkout(list)
        })

        app_bar_addWorkout.setOnClickListener {
            workoutAddDialog.show(childFragmentManager, "WorkoutAddDialog")
        }

        val swipeToDelete = object : SwipeToDeleteCallback(requireContext()){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.delete(workoutsAdapter.getWorkoutPosition(viewHolder.adapterPosition))
                Toast.makeText(requireContext(), "Тренировка удалена", Toast.LENGTH_SHORT).show()
            }
        }
        val touchHelper = ItemTouchHelper(swipeToDelete)
        touchHelper.attachToRecyclerView(rvWorkouts)

    }

    private fun initAdapter() {
        rvWorkouts.adapter = workoutsAdapter
        rvWorkouts.layoutManager = LinearLayoutManager(requireContext())
    }




}