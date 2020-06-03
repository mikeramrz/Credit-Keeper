package com.scavdev.creditkeeper.adapters

import android.transition.TransitionManager
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.scavdev.creditkeeper.R
import com.scavdev.creditkeeper.databinding.CreditItemCardBinding
import com.scavdev.creditkeeper.model.CreditItem


class CreditItemViewHolder(private val binding: CreditItemCardBinding) :
    RecyclerView.ViewHolder(binding.root) {
    /* val creditItemNameTextView: TextView = creditItemView.findViewById(R.id.text_view_credit_name)
     val creditItemBalanceTextView : TextView = creditItemView.findViewById(R.id.text_view_balance)
     val creditItemUtilizationTextView : TextView = creditItemView.findViewById(R.id.text_view_utilization)
     val creditItemLimitTextView: TextView = creditItemView.findViewById(R.id.text_view_limit)
     val creditItemRateTextView: TextView = creditItemView.findViewById(R.id.text_view_rate)
     val creditItemMinimumTextView: TextView = creditItemView.findViewById(R.id.text_view_minimum)
     val creditItemDueDateTextView: TextView = creditItemView.findViewById(R.id.text_view_due_date)*/
    fun bind(item: CreditItem) {
        binding.creditItem = item
        binding.root.setOnClickListener {
            val view = it.findViewById<ConstraintLayout>(R.id.card_layout_expandable)
            TransitionManager.beginDelayedTransition(binding.creditItemCardView.parent as RecyclerView)
            if (view.visibility  == View.GONE){
                view.visibility  = View.VISIBLE
               }else{
                view.visibility  = View.GONE
               }
        }
    }


}
