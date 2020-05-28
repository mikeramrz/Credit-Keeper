package com.scavdev.creditkeeper.adapters

import android.icu.text.SimpleDateFormat
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.google.android.material.textfield.TextInputEditText
import com.scavdev.creditkeeper.R
import java.util.*

@BindingAdapter("android:utilizationTextColor")
fun setUtilizationColor(textView: TextView, utilization: Double) {

    when (utilization.toInt()) {
        in 0..29 -> textView.setTextColor(textView.context.getColor(R.color.colorCreditUtilizationGreen))
        in 30..49 -> textView.setTextColor(textView.context.getColor(R.color.colorCreditUtilizationYellow))
        in 50..74 -> textView.setTextColor(textView.context.getColor(R.color.colorCreditUtilizationOrange))
        in 75..100 -> textView.setTextColor(textView.context.getColor(R.color.colorCreditUtilizationRed))
    }
}

@BindingAdapter("android:dateFormat")
fun setDateFormat(textView: TextView, dueDate: Date) {

    val todayDate = Calendar.getInstance(TimeZone.getDefault())
    val dueDateDay = SimpleDateFormat("dd").format(dueDate.time)

    if (hasDayPassedThisMonth(dueDate, todayDate)) {
        todayDate.add(Calendar.MONTH, 1)
        val nextMonthString = SimpleDateFormat("MMM").format(todayDate.time)
        val textDateString = " Due: $nextMonthString $dueDateDay"
        textView.text = textDateString
    } else {
        val monthString = SimpleDateFormat("MMM").format(todayDate.time)
        val textDateString = " Due: $monthString $dueDateDay"
        textView.text = textDateString
    }
}


@BindingAdapter("android:text")
fun setDouble(inputEditText: TextInputEditText, double: Double) {
    if (double.equals(Double.NaN)) {
        inputEditText.setText("")
    } else inputEditText.setText(double.toString())
}

@InverseBindingAdapter(attribute = "android:text")
fun getDouble(textInputEditText: TextInputEditText): Double {
    var num: String = textInputEditText.text.toString();
    return if (num.isEmpty()) {
        "0".toDouble()
    } else {
        num.toDouble()
    }
}

private fun hasDayPassedThisMonth(dueDate: Date, todayDate: Calendar): Boolean {
    val cal = Calendar.getInstance()
    cal.time = dueDate

    val dayDueDateNum = cal.get(Calendar.DAY_OF_MONTH)
    val todayDayNum = todayDate.get(Calendar.DAY_OF_MONTH)

    return todayDayNum > dayDueDateNum
}