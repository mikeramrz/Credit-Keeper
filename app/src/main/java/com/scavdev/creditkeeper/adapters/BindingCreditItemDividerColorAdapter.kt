package com.scavdev.creditkeeper.adapters

import android.view.View
import androidx.databinding.BindingAdapter
import com.scavdev.creditkeeper.R

@BindingAdapter("android:utilizationDividerColor")
fun setUtilizationColor(view: View, utilization: Double) {

    when (utilization.toInt()) {
        in 0..29 -> view.setBackgroundColor(view.context.getColor(R.color.colorCreditUtilizationGreen))
        in 30..49 -> view.setBackgroundColor(view.context.getColor(R.color.colorCreditUtilizationYellow))
        in 50..74 -> view.setBackgroundColor(view.context.getColor(R.color.colorCreditUtilizationOrange))
        in 75..100 -> view.setBackgroundColor(view.context.getColor(R.color.colorCreditUtilizationRed))
    }
}