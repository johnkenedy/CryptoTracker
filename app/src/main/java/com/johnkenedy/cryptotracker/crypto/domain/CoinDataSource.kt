package com.johnkenedy.cryptotracker.crypto.domain

import com.johnkenedy.cryptotracker.core.domain.util.NetworkError
import com.johnkenedy.cryptotracker.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}
