package com.scavdev.creditkeeper

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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
        binding.viewmodel = addViewModel
        binding.lifecycleOwner = this
        return inflater.inflate(R.layout.add_credit_item_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.button_add)
        val editTextDueDate: TextInputEditText = view.findViewById(R.id.edit_text_due_date)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        editTextDueDate.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                view.context,
                DatePickerDialog.OnDateSetListener { view, _, _, mDay ->
                    editTextDueDate.setText(mDay.toString())
                }, year, month, day
            )
            c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH))
            datePickerDialog.datePicker.minDate = c.timeInMillis
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH))
            datePickerDialog.datePicker.maxDate = c.timeInMillis
            datePickerDialog.show()
        }
        button.setOnClickListener {
            var b = findNavController().popBackStack()
            Log.d("miker", b.toString())
        }
    }
}
