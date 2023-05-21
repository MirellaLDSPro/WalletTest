package dev.mlds.wallettest.ui.list

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mlds.wallettest.R
import dev.mlds.wallettest.domain.models.CardsModel
import dev.mlds.wallettest.domain.models.Resource
import dev.mlds.wallettest.ui.components.CardComponent
import dev.mlds.wallettest.ui.components.ThirdButton
import dev.mlds.wallettest.ui.components.TitleComponent
import dev.mlds.wallettest.ui.components.ToolbarWallet
import dev.mlds.wallettest.ui.theme.WalletLigthTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun CardListScreen(
    backClick: () -> Unit = {},
    createClick: () -> Unit = {},
    viewModel: CardListViewModel = koinViewModel()
) {
    val context = LocalContext.current
    val cards = viewModel.cards.observeAsState()
    viewModel.getAllCards()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(WalletLigthTheme.colors.background)
        ) {
            Column(
                Modifier.fillMaxSize()
            ) {
                ToolbarWallet(primaryIconClick = backClick, secondIconClick = createClick)
                TitleComponent()
                Body(cards, context)
            }
        }
    }
}

@Composable
private fun Body(
    data: State<Resource<CardsModel>?>,
    context: Context
) {
    data.value?.let { state ->
        when (state) {
            is Resource.Success -> {
                CardList(state.data)
            }

            is Resource.HttpError -> {
                Toast.makeText(
                    context,
                    stringResource(id = R.string.request_error),
                    Toast.LENGTH_LONG
                ).show()
            }

            else -> Unit
        }
    }
}

@Composable
private fun CardList(cardsModel: CardsModel) {
    var card by remember { mutableStateOf(cardsModel.cards) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        itemsIndexed(card) { index, card ->
            CardComponent(card = card, index = index)
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            ThirdButton(
                onClick = {
                    Log.i(">>>", "Usar este cartão")
                }) {
                Text(text = stringResource(id = R.string.use_this_card))
            }
        }
    }
}

@Preview(name = "CardListScreen Ligth Mode", showBackground = true)
@Composable
fun CardListScreenPreview() {
    WalletLigthTheme {
        CardListScreen()
    }
}