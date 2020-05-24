package com.scavdev.creditkeeper.adapters

import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.scavdev.creditkeeper.R

@BindingAdapter("android:utilizationTextColor")
fun setUtilizationColor(textView: TextView, utilization: Double) {

    when (utilization.toInt()) {
        in 0..29 -> textView.setTextColor(textView.context.getColor(R.color.colorCreditUtilizationGreen))
        in 30..49 -> textView.setTextColor(textView.context.getColor(R.color.colorCreditUtilizationYellow))
        in 50..74 -> textView.setTextColor(textView.context.getColor(R.color.colorCreditUtilizationOrange))
        in 75..100 -> textView.setTextColor(textView.context.getColor(R.color.colorCreditUtilizationRed))
    }
}