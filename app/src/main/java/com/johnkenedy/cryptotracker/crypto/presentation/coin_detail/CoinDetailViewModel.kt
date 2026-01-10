package com.johnkenedy.cryptotracker.crypto.presentation.coin_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnkenedy.cryptotracker.crypto.presentation.coin_list.CoinListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class CoinDetailViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(CoinListState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = CoinListState()
        )

    fun onAction(action: CoinDetailAction) {
        when (action) {
            else -> TODO("Handle actions")
        }
    }

}