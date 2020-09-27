package com.scavdev.creditkeeper.ui.addItem

import android.app.DatePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.widget.DatePicker

class DayOfMonthDatePickerDialog(context: Context, var calendar: Calendar): DatePickerDialog(context) {

    init {
        setMinimumAndMaximumDayForMonth()
    }
    private fun setMinimumAndMaximumDayForMonth(){
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH))
        this.datePicker.minDate = calendar.timeInMillis
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
        this.datePicker.maxDate = calendar.timeInMillis
    }

}