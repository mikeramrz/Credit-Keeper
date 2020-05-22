package com.scavdev.creditkeeper.adapters

import android.view.View
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView
import com.scavdev.creditkeeper.R
import com.scavdev.creditkeeper.databinding.CreditItemCardBinding
import com.scavdev.creditkeeper.model.CreditItem


class CreditItemViewHolder(val binding: CreditItemCardBinding) : RecyclerView.ViewHolder(binding.root){
   /* val creditItemNameTextView: TextView = creditItemView.findViewById(R.id.text_view_credit_name)
    val creditItemBalanceTextView : TextView = creditItemView.findViewById(R.id.text_view_balance)
    val creditItemUtilizationTextView : TextView = creditItemView.findViewById(R.id.text_view_utilization)
    val creditItemLimitTextView: TextView = creditItemView.findViewById(R.id.text_view_limit)
    val creditItemRateTextView: TextView = creditItemView.findViewById(R.id.text_view_rate)
    val creditItemMinimumTextView: TextView = creditItemView.findViewById(R.id.text_view_minimum)
    val creditItemDueDateTextView: TextView = creditItemView.findViewById(R.id.text_view_due_date)*/
    fun bind(item: CreditItem){
        binding.creditItem = item
   }


}
