package com.johnkenedy.cryptotracker.crypto.presentation.coin_list

import com.johnkenedy.cryptotracker.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}