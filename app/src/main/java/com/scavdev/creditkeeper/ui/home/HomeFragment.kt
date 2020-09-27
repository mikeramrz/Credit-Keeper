package com.scavdev.creditkeeper.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.scavdev.creditkeeper.R
import com.scavdev.creditkeeper.adapters.ExpandableCreditAdapter
import com.scavdev.creditkeeper.databinding.CreditItemCardBinding
import com.scavdev.creditkeeper.databinding.FragmentHomeBinding
import com.scavdev.creditkeeper.di.ViewModelFactory
import com.scavdev.creditkeeper.model.InformSnackBarState
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.credit_item_card.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding : FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home,
            container, false
        )
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.credit_list)
        val adapter = ExpandableCreditAdapter(parentFragmentManager, homeViewModel)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        homeViewModel.creditItems.observe(viewLifecycleOwner, Observer { items ->
            items?.let { adapter.setCreditItems(items) }
        })

        homeViewModel.informSnackBarStateLiveData.observe(viewLifecycleOwner, Observer { creditItemEvent ->
            creditItemEvent.getContentOfNotHandled()?.let{
                when(it){
                    is InformSnackBarState.NothingToShow -> Log.d("miker", "nothing to show response")
                    is InformSnackBarState.ItemRemoved ->{
                        Snackbar.make(view, "Removed ${it.creditName}", Snackbar.LENGTH_SHORT).show()
                    }
                }
            }
        })

        val fab: View = view.findViewById(R.id.fab_add_credit_item)
        fab.setOnClickListener {
            /* Snackbar.make(v, "Click!!",Snackbar.LENGTH_SHORT).show()
             homeViewModel.add()
             homeViewModel.add2()*/
            findNavController().navigate(R.id.action_navigation_home_to_addCreditItemFragment)
        }

    }
}
