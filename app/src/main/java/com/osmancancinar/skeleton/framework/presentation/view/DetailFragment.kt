package com.osmancancinar.skeleton.framework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.osmancancinar.skeleton.R
import com.osmancancinar.skeleton.business.domain.models.Model
import com.osmancancinar.skeleton.business.domain.state.DataState
import com.osmancancinar.skeleton.databinding.FragmentDetailBinding
import com.osmancancinar.skeleton.framework.presentation.viewmodel.DetailStateEvent
import com.osmancancinar.skeleton.framework.presentation.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var toolBarTitle: TextView
    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    private var itemId: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            itemId = DetailFragmentArgs.fromBundle(it).itemId
        }

        toolBarTitle = requireActivity().findViewById(R.id.toolbar_title)
        toolBarTitle.setText(R.string.details_text)

        itemId?.let { viewModel.setStateEvent(DetailStateEvent.GetDataEvents, it) }

        subscribeObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentDetailBinding.inflate(
                LayoutInflater.from(context),
                container,
                false
            )
        return binding.root
    }

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

    private fun feedDataToViews(model: Model) {
        binding.detailText.text = model.name
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        //binding.progressBar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

    private fun displayError(message: String?) {
        //if (message != null) binding.text.text = message else binding.text.text = "Unknown error."
    }
}