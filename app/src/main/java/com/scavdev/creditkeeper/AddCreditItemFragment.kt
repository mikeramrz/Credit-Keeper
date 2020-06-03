package com.scavdev.creditkeeper

import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.scavdev.creditkeeper.databinding.AddCreditItemFragmentBinding
import com.scavdev.creditkeeper.di.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class AddCreditItemFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var addViewModel: AddCreditItemViewModel
    private lateinit var binding: AddCreditItemFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        addViewModel =
            ViewModelProvider(this, viewModelFactory).get(AddCreditItemViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(
            inflater, R.layout.add_credit_item_fragment,
            container, false
        )
        binding.viewModel = addViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val editTextDueDate: TextInputEditText = view.findViewById(R.id.edit_text_due_date)

        editTextDueDate.setOnClickListener {
            val datePickerDialog = DayOfMonthDatePickerDialog(view.context, Calendar.getInstance())
            datePickerDialog.setOnDateSetListener { _, _, _, dayNum ->
                editTextDueDate.setText(dayNum.toString())
            }
            datePickerDialog.show()
        }
    }
}

