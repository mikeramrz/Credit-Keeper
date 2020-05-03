package com.scavdev.creditkeeper.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.scavdev.creditkeeper.R


class CreditItemViewHolder(creditItemView: View) : RecyclerView.ViewHolder(creditItemView){
    val creditItemNameTextView: TextView = creditItemView.findViewById(R.id.text_view_credit_name)
    val creditItemBalanceTextView : TextView = creditItemView.findViewById(R.id.text_view_balance)
    val creditItemUtilizationTextView : TextView = creditItemView.findViewById(R.id.text_view_utilization)
}
