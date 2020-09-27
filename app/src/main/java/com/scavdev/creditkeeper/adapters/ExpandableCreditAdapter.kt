package com.scavdev.creditkeeper.adapters

import android.content.Context
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager

import androidx.recyclerview.widget.RecyclerView
import com.scavdev.creditkeeper.R
import com.scavdev.creditkeeper.databinding.CreditItemCardBinding
import com.scavdev.creditkeeper.model.CreditItem
import com.scavdev.creditkeeper.ui.addItem.DeleteItemConfirmationBottomSheetDialog
import com.scavdev.creditkeeper.ui.home.HomeViewModel
import javax.inject.Inject

class ExpandableCreditAdapter(
    private val fragmentManager: FragmentManager,
    private val homeViewModel: HomeViewModel
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    @Inject
    lateinit var context: Context

    private var creditItems = emptyList<CreditItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditItemViewHolder {

        return CreditItemViewHolder(
            CreditItemCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), fragmentManager
        )

        /*   val layoutInflater = LayoutInflater.from(parent.context)
        val creditItemCardBinding = CreditItemCardBinding.inflate(layoutInflater, parent, false)

        return CreditItemViewHolder(creditItemCardBinding)*/

    }

    override fun getItemCount(): Int {
        return creditItems.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = creditItems[position]
        (holder as CreditItemViewHolder).binding.apply {
            creditItem = item
            executePendingBindings()
            if (holder.binding.cardLayoutExpandable.visibility == View.VISIBLE) {
                holder.binding.cardLayoutExpandable.visibility = View.GONE
            }
        }
    }

    class CreditItemViewHolder(
        val binding: CreditItemCardBinding,
        private val fragmentManager: FragmentManager
    ) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.cardViewDeleteButton.setOnClickListener {
                val creditName = binding.creditItem?.creditName
                binding.creditItem?.id?.let { id ->
                    if (creditName != null) {
                        showDeleteItemConfirmationBottomDialog(id, creditName)
                    }
                }
            }
            binding.root.setOnClickListener {
                val view = it.findViewById<ConstraintLayout>(R.id.card_layout_expandable)
                TransitionManager.beginDelayedTransition(binding.creditItemCardView.parent as ViewGroup)
                when (view.visibility) {
                    View.GONE -> {
                        view.visibility = View.VISIBLE
                    }
                    else -> {
                        view.visibility = View.GONE
                    }
                }
            }
        }

        private fun showDeleteItemConfirmationBottomDialog(itemId: Int, creditName: String) {
            val bottomSheetDialog =
                DeleteItemConfirmationBottomSheetDialog(
                    itemId, creditName
                )
            bottomSheetDialog.show(fragmentManager, "bottom_sheet_delete_confirm")
        }
    }

    internal fun setCreditItems(creditItems: List<CreditItem>) {
        this.creditItems = creditItems
        notifyDataSetChanged()
    }
}
