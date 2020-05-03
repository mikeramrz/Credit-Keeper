package com.scavdev.creditkeeper.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.scavdev.creditkeeper.R
import com.scavdev.creditkeeper.model.CreditItem

class ExpandableCreditAdapter() :
    RecyclerView.Adapter<CreditItemViewHolder>() {

private  var creditItems = emptyList<CreditItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditItemViewHolder {
        return CreditItemViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.credit_item_card, parent, false))

    }

    override fun getItemCount(): Int {
        return creditItems.size
    }

    override fun onBindViewHolder(holder: CreditItemViewHolder, position: Int) {

        val item = creditItems[position]
        holder.creditItemNameTextView.text = item.creditName
        holder.creditItemBalanceTextView.text = item.outstandingBalance.toString()
        holder.creditItemUtilizationTextView.text = item.utilization.toString()

    }

    internal fun setCreditItems(creditItems:List<CreditItem>){

        this.creditItems =  creditItems
        notifyDataSetChanged()
    }
}