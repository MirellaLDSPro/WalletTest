package dev.mlds.wallettest.ui.create

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.mlds.wallettest.R
import dev.mlds.wallettest.domain.models.CardModel
import dev.mlds.wallettest.domain.models.Resource
import dev.mlds.wallettest.ui.components.EditableComponent
import dev.mlds.wallettest.ui.components.EditableImageComponent
import dev.mlds.wallettest.ui.components.PrimaryButton
import dev.mlds.wallettest.ui.components.ToolbarWallet
import dev.mlds.wallettest.ui.theme.WalletLigthTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun CardCreateScreen(
    viewModel: CreateCardViewModel = koinViewModel(),
    backClick: () -> Unit = {},
    nextPage: () -> Unit = {}
) {

    val context = LocalContext.current
    val card = viewModel.card.observeAsState()
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(WalletLigthTheme.colors.background)
        ) {
            Image(
                painter = painterResource(R.drawable.background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

            when (card.value) {
                is Resource.Success -> {
                    nextPage()
                }

                is Resource.Loading -> {
                    CircularProgressIndicator()
                }

                is Resource.HttpError -> {
                    Toast.makeText(
                        context,
                        stringResource(id = R.string.request_error),
                        Toast.LENGTH_LONG
                    ).show()
                }

                is Resource.Error -> {
                    Toast.makeText(
                        context,
                        stringResource(id = R.string.request_conection_error),
                        Toast.LENGTH_LONG
                    ).show()
                }

                else -> Unit
            }

            Column {
                ToolbarWallet(
                    isTransient = true,
                    primaryIconClick = backClick
                )
                CreateForm() {
                    viewModel.postCard(it)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateForm(
    clickNext: (cardModel: CardModel) -> Unit
) {
    var cardNumberValue by remember { mutableStateOf("") }
    var nameValue by remember { mutableStateOf("") }
    var valueDate by remember { mutableStateOf("") }
    var valuePassword by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ProvideTextStyle(
            value = WalletLigthTheme.typography.title
        ) {
            Text(
                color = WalletLigthTheme.colors.text,
                text = stringResource(id = R.string.label_home)
            )
        }
        Spacer(modifier = Modifier.size(22.dp))
        EditableImageComponent(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(id = R.string.card_number),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onChangeText = { cardNumberValue = it }
        )
        Spacer(modifier = Modifier.size(22.dp))
        EditableComponent(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(id = R.string.card_titular_person),
            onChangeText = { nameValue = it }
        )
        Spacer(modifier = Modifier.size(22.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProvideTextStyle(
                value = WalletLigthTheme.typography.body
            ) {
                TextField(
                    value = valueDate,
                    onValueChange = { valueDate = it },
                    modifier = Modifier
                        .weight(1f),
                    placeholder = {
                        Text(
                            color = WalletLigthTheme.colors.primary,
                            text = stringResource(id = R.string.card_final_date)
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = WalletLigthTheme.colors.primary,
                        disabledTextColor = WalletLigthTheme.colors.textEnabled
                    ),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            ProvideTextStyle(
                value = WalletLigthTheme.typography.body
            ) {
                TextField(
                    value = valuePassword,
                    onValueChange = { valuePassword = it },
                    modifier = Modifier
                        .weight(1f),
                    placeholder = {
                        Text(
                            color = WalletLigthTheme.colors.primary,
                            text = stringResource(id = R.string.card_security_code)
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = WalletLigthTheme.colors.primary,
                        disabledTextColor = WalletLigthTheme.colors.textEnabled
                    ),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    ),
                    visualTransformation = if (showPassword) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    }
                )
            }
        }
        Spacer(modifier = Modifier.size(22.dp))
        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                clickNext(
                    CardModel(
                        cvv = valuePassword,
                        name = nameValue,
                        number = cardNumberValue
                    )
                )
            },
            enabled = nameValue.isNotEmpty() && cardNumberValue.isNotEmpty() && valuePassword.isNotEmpty(),
            content = {
                Text(text = stringResource(id = R.string.next_button))
            }
        )
    }
}

@Preview(name = "Create card screen", showBackground = true)
@Composable
fun CardCreateScreenPreview() {
    WalletLigthTheme {
        CardCreateScreen()
    }
}