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

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getData: GetData,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Model>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Model>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when (mainStateEvent) {
                is MainStateEvent.GetDataEvents -> {
                    getData.execute()
                        .onEach { dataState -> _dataState.value = dataState }
                        .launchIn(viewModelScope)
                }
                is MainStateEvent.None -> {
                    //Doesn't matter for now.
                }
            }
        }
    }
}

sealed class MainStateEvent {
    object GetDataEvents : MainStateEvent()
    object None : MainStateEvent()
}