package com.johnkenedy.cryptotracker.crypto.domain

import com.johnkenedy.cryptotracker.core.domain.util.NetworkError
import com.johnkenedy.cryptotracker.core.domain.util.Result
import java.time.ZonedDateTime

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
    suspend fun getCoinHistory(
        coinID: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError>
}
