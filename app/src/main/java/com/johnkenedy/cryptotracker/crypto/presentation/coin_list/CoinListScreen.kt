package com.johnkenedy.cryptotracker.crypto.presentation.coin_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.johnkenedy.cryptotracker.crypto.presentation.coin_list.components.CoinListItem
import com.johnkenedy.cryptotracker.crypto.presentation.coin_list.components.previewCoin
import com.johnkenedy.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun CoinListScreenRoot(
    viewModel: CoinListViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    CoinListScreenScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun CoinListScreenScreen(
    state: CoinListState,
    onAction: (CoinListAction) -> Unit,
    modifier: Modifier = Modifier
) {
    if (state.isLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.coins) { coinUi ->
                CoinListItem(
                    coinUi = coinUi,
                    onClick = {  },
                    modifier = Modifier.fillMaxWidth()
                )
                HorizontalDivider()
            }
        }
    }

}

@PreviewLightDark
@Composable
private fun Preview() {
    CryptoTrackerTheme {
        CoinListScreenScreen(
            state = CoinListState(
                isLoading = false,
                coins = (1 .. 100).map {
                    previewCoin.copy(id = it.toString())
                }
            ),
            onAction = {},
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
        )
    }
}