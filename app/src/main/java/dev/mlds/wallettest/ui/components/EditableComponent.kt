package dev.mlds.wallettest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.mlds.wallettest.R
import dev.mlds.wallettest.ui.theme.WalletLigthTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditableImageComponent(
    label: String = "Teste",
    showRigthIcon: Boolean = true,
    modifier: Modifier = Modifier,
    onChangeText: (value: String) -> Unit,
    visualTransformation: VisualTransformation? = null,
    keyboardOptions: KeyboardOptions? = null
) {
    var value by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        ProvideTextStyle(
            value = WalletLigthTheme.typography.body
        ) {
            Text(
                color = WalletLigthTheme.colors.text,
                modifier = Modifier.fillMaxWidth(),
                text = label
            )
        }

        TextField(
            modifier = modifier,
            value = value,
            onValueChange = {
                value = it
                onChangeText(it)
            },
            keyboardOptions = keyboardOptions ?: KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = WalletLigthTheme.colors.primary,
                cursorColor = WalletLigthTheme.colors.primary,
                disabledTextColor = WalletLigthTheme.colors.textEnabled
            ),
            textStyle = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            ),
            leadingIcon = {
                if (showRigthIcon) {
                    Image(
                        painter = painterResource(R.drawable.ic_camera),
                        contentDescription = "Imagem"
                    )
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditableComponent(
    modifier: Modifier = Modifier,
    label: String? = null,
    content: @Composable (() -> Unit)? = null,
    onChangeText: (value: String) -> Unit,
    keyboardOptions: KeyboardOptions? = null
) {
    var value by remember { mutableStateOf("") }

    Column {
        label?.let {
            ProvideTextStyle(
                value = WalletLigthTheme.typography.body
            ) {
                Text(
                    color = WalletLigthTheme.colors.text,
                    modifier = modifier,
                    text = label
                )
            }
        }

        content?.invoke() ?: TextField(
            modifier = modifier.fillMaxWidth(),
            value = value,
            onValueChange = {
                value = it
                onChangeText(it)
            },
            keyboardOptions = keyboardOptions ?: KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = WalletLigthTheme.colors.primary,
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
}

@Preview(name = "Editable component")
@Composable
fun EditableComponentPreview() {
    WalletLigthTheme {
        Column {
            EditableImageComponent(
                onChangeText = {},
                visualTransformation = PasswordVisualTransformation()
            )
            EditableComponent(
                label = "Test",
                onChangeText = {},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
    }
}