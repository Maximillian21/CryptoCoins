package com.maximilian.cryptocoins.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateConverter {
    fun timestampToDate(timestamp: Long): String {
        val date = Date(timestamp * 1000)

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        return dateFormat.format(date)
    }
}