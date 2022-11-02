package com.osmancancinar.skeleton.framework.presentation.viewmodel

import androidx.lifecycle.*
import com.osmancancinar.skeleton.business.domain.models.Model
import com.osmancancinar.skeleton.business.domain.state.DataState
import com.osmancancinar.skeleton.business.interactors.GetData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * View Model for Detail Fragment, uses getData to manage data.
 */
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getData: GetData,
) : ViewModel() {

    // Data State as Live Data
    private val _dataState: MutableLiveData<DataState<Model>> = MutableLiveData()

    val dataState: LiveData<DataState<Model>>
        get() = _dataState

    // Gets data by setting state.
    fun setStateEvent(detailStateEvent: DetailStateEvent, itemId: Int) {
        viewModelScope.launch {
            when (detailStateEvent) {
                is DetailStateEvent.GetDataEvents -> {
                    getData.executeDetail(itemId)
                        .onEach { dataState -> _dataState.value = dataState }
                        .launchIn(viewModelScope)
                }
                is DetailStateEvent.None -> {
                    //Doesn't matter for now.
                }
            }
        }
    }
}

// Custom Data State
sealed class DetailStateEvent {
    object GetDataEvents : DetailStateEvent()
    object None : DetailStateEvent()
}