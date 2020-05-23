package com.scavdev.creditkeeper.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.scavdev.creditkeeper.databinding.CreditItemCardBinding
import com.scavdev.creditkeeper.model.CreditItem

class ExpandableCreditAdapter() :
    RecyclerView.Adapter<CreditItemViewHolder>(){

private  var creditItems = emptyList<CreditItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val creditItemCardBinding = CreditItemCardBinding.inflate(layoutInflater, parent, false)
        return CreditItemViewHolder(creditItemCardBinding)

    }

    override fun getItemCount(): Int {
        return creditItems.size
    }


    override fun onBindViewHolder(holder: CreditItemViewHolder, position: Int) {
       holder.bind(creditItems[position])
    }

    internal fun setCreditItems(creditItems:List<CreditItem>){
        this.creditItems =  creditItems
        notifyDataSetChanged()
    }

    class CreditItemCardViewListener(val clickListener: (credItemId: Int) -> Unit){
        fun onClick(creditItem: CreditItem) = clickListener(creditItem.id)
    }

}