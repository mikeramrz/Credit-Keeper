package com.scavdev.creditkeeper.ui.editItem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.scavdev.creditkeeper.R
import com.scavdev.creditkeeper.di.ViewModelFactory
import com.scavdev.creditkeeper.ui.home.HomeViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditItemBottomSheetDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditItemBottomSheetDialogFragment : BottomSheetDialogFragment() {
    private var param1: Int? = null
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var mainViewModel: HomeViewModel

    private lateinit var buttonMakePayment: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_edit_item_bottom_sheet_dialog, container, false)

        buttonMakePayment = view.findViewById(R.id.bottom_sheet_edit_button_make_min_payment)

        buttonMakePayment.setOnClickListener {
            param1?.let { creditItemId -> mainViewModel.updateMinimumPaymentMade(creditItemId) }
            dismiss()
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment EditItemBottomSheetDialogFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
            EditItemBottomSheetDialogFragment()
                .apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }
}