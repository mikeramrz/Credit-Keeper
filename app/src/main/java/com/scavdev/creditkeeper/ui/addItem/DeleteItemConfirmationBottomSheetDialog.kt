package com.scavdev.creditkeeper.ui.addItem


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.scavdev.creditkeeper.R
import com.scavdev.creditkeeper.adapters.ExpandableCreditAdapter
import com.scavdev.creditkeeper.di.ViewModelFactory
import com.scavdev.creditkeeper.model.ICreditRepository
import com.scavdev.creditkeeper.ui.home.HomeViewModel
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import javax.inject.Singleton

class DeleteItemConfirmationBottomSheetDialog(
    private val creditItemID: Int, private val creditName: String) : BottomSheetDialogFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var mainViewModel: HomeViewModel

    private lateinit var buttonNo: Button
    private lateinit var buttonYes: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            inflater.inflate(R.layout.bottom_sheet_delete_item_confirmation, container, false)

        buttonNo = view.findViewById(R.id.bottom_sheet_delete_confirmation_button_no)
        buttonYes = view.findViewById(R.id.bottom_sheet_delete_confirmation_button_yes)

        buttonNo.setOnClickListener {
            dismiss()
        }

        buttonYes.setOnClickListener {
            mainViewModel.removeItem(creditItemID, creditName)
            dismiss()
        }

        return view
    }
}