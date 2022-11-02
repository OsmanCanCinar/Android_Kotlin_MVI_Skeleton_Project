package com.osmancancinar.skeleton.framework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.osmancancinar.skeleton.R
import com.osmancancinar.skeleton.business.domain.models.Model
import com.osmancancinar.skeleton.business.domain.state.DataState
import com.osmancancinar.skeleton.databinding.FragmentDetailBinding
import com.osmancancinar.skeleton.framework.presentation.viewmodel.DetailStateEvent
import com.osmancancinar.skeleton.framework.presentation.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main Fragment to display detail page.
 */
@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var toolBarTitle: TextView
    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    private var itemId: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get Safe Args
        arguments?.let {
            itemId = DetailFragmentArgs.fromBundle(it).itemId
        }

        // Set Custom Toolbar
        toolBarTitle = requireActivity().findViewById(R.id.toolbar_title)
        toolBarTitle.setText(R.string.details_text)

        // Set Data State
        itemId?.let { viewModel.setStateEvent(DetailStateEvent.GetDataEvents, it) }

        subscribeObservers()
    }

    // Data Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // View Binding
        //binding = FragmentDetailBinding.inflate(LayoutInflater.from(context), container, false)

        // Data Binding
        binding = DataBindingUtil.inflate<FragmentDetailBinding?>(inflater, R.layout.fragment_detail, container, false)

        return binding.root
    }

    // Subscribes to the live data of Data State
    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when (dataState) {
                is DataState.Success<Model> -> {
                    displayProgressBar(false)
                    feedDataToViews(dataState.data)
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

    // Set data with data binding.
    private fun feedDataToViews(model: Model) {
        // View Binding
        //binding.detailText.text = model.name

        // Data Binding
        binding.model = model
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