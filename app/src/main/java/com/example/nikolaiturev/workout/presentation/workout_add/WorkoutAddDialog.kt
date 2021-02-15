package com.example.nikolaiturev.workout.presentation.workout_add

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.nikolaiturev.workout.R
import com.example.nikolaiturev.workout.data.dao.WorkoutDao
import com.example.nikolaiturev.workout.domain.entity.Workout
import com.example.nikolaiturev.workout.presentation.workouts.WorkoutViewModel
import com.example.nikolaiturev.workout.util.getDateTime
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_workout_bottom_sheet.*
import org.koin.android.ext.android.inject

class WorkoutAddDialog : BottomSheetDialogFragment() {

    private val workoutDao: WorkoutDao by inject()
    private val viewModel by inject<WorkoutViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_workout_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btSaveWorkout.setOnClickListener {
            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase() {
        val name = etNameWorkout.text.toString()
        val date = getDateTime()

        if (inputCheck(name)) {
            val workout = Workout(0, name, date)
            viewModel.insert(workout)
//            workoutDao.insert(workout)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe()

          //  etNameWorkout.text = null
            Toast.makeText(requireContext(), "Добавлено!", Toast.LENGTH_LONG).show()
            dismiss()
        } else {
            Toast.makeText(requireContext(), "Введите поле", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String): Boolean {
        return !(TextUtils.isEmpty(name))
    }
}