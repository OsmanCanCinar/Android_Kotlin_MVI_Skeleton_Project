package com.osmancancinar.skeleton.framework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.osmancancinar.skeleton.R
import com.osmancancinar.skeleton.business.domain.models.Model
import com.osmancancinar.skeleton.business.domain.state.DataState
import com.osmancancinar.skeleton.databinding.FragmentMainBinding
import com.osmancancinar.skeleton.framework.presentation.viewmodel.MainStateEvent
import com.osmancancinar.skeleton.framework.presentation.viewmodel.MainViewModel
import com.osmancancinar.skeleton.framework.presentation.adapter.RecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main Fragment to display home page.
 */
@AndroidEntryPoint
class MainFragment() : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val recyclerAdapter by lazy { RecyclerViewAdapter() }
    private val viewModel: MainViewModel by viewModels()
    private lateinit var toolBarTitle: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set Custom Toolbar
        toolBarTitle = requireActivity().findViewById(R.id.toolbar_title)
        toolBarTitle.setText(R.string.characters_text)

        // Set Data State
        viewModel.setStateEvent(MainStateEvent.GetDataEvents)

        // Setup Recycler View
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recyclerAdapter
        }

        subscribeObservers()
    }

    // View Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    // Subscribes to the live data of Data State
    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<Model>> -> {
                    displayProgressBar(false)
                    feedDataToAdapter(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    // Feeds the adapter.
    private fun feedDataToAdapter(models: List<Model>) {
        recyclerAdapter.setData(models)
    }

    // Displays progress bar while loading.
    private fun displayProgressBar(isDisplayed: Boolean) {
        binding.progressBar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

    // Displays when error occurs.
    private fun displayError(message: String?) {
        if (message != null) binding.errorText.text = message else binding.errorText.text =
            getString(
                R.string.unknown_error
            )
    }
}