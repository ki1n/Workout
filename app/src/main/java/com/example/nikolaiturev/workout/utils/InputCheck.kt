package com.example.nikolaiturev.workout.utils

import android.text.TextUtils

fun inputCheckEditText(name: String): Boolean {
    return !(TextUtils.isEmpty(name))
}