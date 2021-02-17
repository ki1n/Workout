package com.example.nikolaiturev.workout.utils

import java.text.SimpleDateFormat
import java.util.*

fun getDateTime(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault())
    return dateFormat.format(Calendar.getInstance().time)
}

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun dateTimeConverter(string: String): String {

    val inFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault())

    val outFormat = if (Locale.getDefault() == Locale("ru", "RU")) {
        SimpleDateFormat("d MMMM 'в' HH:mm", Locale.getDefault())
    } else {
        SimpleDateFormat("MMMM d 'at' HH:mm", Locale.getDefault())
    }

    val inDate = inFormat.parse(string)
    return outFormat.format(inDate)
}