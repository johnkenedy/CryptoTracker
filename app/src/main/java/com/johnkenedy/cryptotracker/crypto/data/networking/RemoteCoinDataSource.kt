package com.johnkenedy.cryptotracker.crypto.data.networking

import com.johnkenedy.cryptotracker.core.data.networking.constructUrl
import com.johnkenedy.cryptotracker.core.data.networking.safeCall
import com.johnkenedy.cryptotracker.core.domain.util.NetworkError
import com.johnkenedy.cryptotracker.core.domain.util.Result
import com.johnkenedy.cryptotracker.core.domain.util.map
import com.johnkenedy.cryptotracker.crypto.data.mappers.toCoin
import com.johnkenedy.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import com.johnkenedy.cryptotracker.crypto.domain.Coin
import com.johnkenedy.cryptotracker.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { responseDto ->
            responseDto.data.map { it.toCoin() }
        }
    }
}