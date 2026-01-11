package com.johnkenedy.cryptotracker.crypto.presentation.coin_list

import com.johnkenedy.cryptotracker.core.domain.util.NetworkError
import com.johnkenedy.cryptotracker.crypto.presentation.models.CoinUi

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
    data class NavigateToCoinDetail(val coinUi: CoinUi): CoinListEvent
}