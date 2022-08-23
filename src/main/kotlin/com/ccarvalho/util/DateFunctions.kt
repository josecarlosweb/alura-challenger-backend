package com.ccarvalho.util

import java.text.SimpleDateFormat
import java.util.*

val formatToGetMonth = SimpleDateFormat("MM")

fun getMonthFromDate(date: Date): String = formatToGetMonth.format(date)