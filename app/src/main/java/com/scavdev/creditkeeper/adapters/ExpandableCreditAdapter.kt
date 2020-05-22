package com.scavdev.creditkeeper.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

import androidx.recyclerview.widget.RecyclerView
import com.scavdev.creditkeeper.databinding.CreditItemCardBinding
import com.scavdev.creditkeeper.databinding.CreditItemCardBinding.bind
import com.scavdev.creditkeeper.model.CreditItem

 class ExpandableCreditAdapter() :
    RecyclerView.Adapter<CreditItemViewHolder>(){

private  var creditItems = emptyList<CreditItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditItemViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var creditItemCardBinding = CreditItemCardBinding.inflate(layoutInflater, parent, false)
        return CreditItemViewHolder(creditItemCardBinding)
        /*val d = CreditItemViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.credit_item_card, parent, false))*/


    }

    override fun getItemCount(): Int {
        return creditItems.size
    }


    override fun onBindViewHolder(holder: CreditItemViewHolder, position: Int) {

       var creditItem = creditItems[position]
       holder.bind(creditItem)

    }

    internal fun setCreditItems(creditItems:List<CreditItem>){

        this.creditItems =  creditItems
        notifyDataSetChanged()
    }

}