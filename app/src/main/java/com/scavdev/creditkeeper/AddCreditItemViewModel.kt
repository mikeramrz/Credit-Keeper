package com.scavdev.creditkeeper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.scavdev.creditkeeper.model.ICreditRepository
import javax.inject.Inject

class AddCreditItemViewModel @Inject constructor(private val creditRepository: ICreditRepository): ViewModel() {
    val text = MutableLiveData<String>("heyo")


}
