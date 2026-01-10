package com.johnkenedy.cryptotracker.crypto.data.networking

import com.johnkenedy.cryptotracker.core.data.networking.constructUrl
import com.johnkenedy.cryptotracker.core.data.networking.safeCall
import com.johnkenedy.cryptotracker.core.domain.util.NetworkError
import com.johnkenedy.cryptotracker.core.domain.util.Result
import com.johnkenedy.cryptotracker.core.domain.util.map
import com.johnkenedy.cryptotracker.crypto.data.mappers.toCoin
import com.johnkenedy.cryptotracker.crypto.data.mappers.toCoinPrice
import com.johnkenedy.cryptotracker.crypto.data.networking.dto.CoinHistoryDto
import com.johnkenedy.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import com.johnkenedy.cryptotracker.crypto.domain.Coin
import com.johnkenedy.cryptotracker.crypto.domain.CoinDataSource
import com.johnkenedy.cryptotracker.crypto.domain.CoinPrice
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.time.ZoneId
import java.time.ZonedDateTime

class RemoteCoinDataSource(
    private val httpClient: HttpClient
) : CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { responseDto ->
            responseDto.data.map { it.toCoin() }
        }
    }

    override suspend fun getCoinHistory(
        coinID: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {
        val startMillis = start
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()
        val endMillis = end
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        return safeCall<CoinHistoryDto> {
            httpClient.get(
                urlString = constructUrl("/assets/$coinID/history")
            ) {
                parameter("interval", "h6")
                parameter("start", startMillis)
                parameter("end", endMillis)
            }
        }.map { response ->
            response.data.map { it.toCoinPrice() }
        }
    }
}