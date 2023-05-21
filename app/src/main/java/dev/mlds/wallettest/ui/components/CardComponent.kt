package dev.mlds.wallettest.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mlds.wallettest.ui.theme.WalletLigthTheme

@Composable
fun CardComponent() {
    Card(
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(WalletLigthTheme.cardColors.background),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 30.dp)
            ) {
                Text(text = "Green Card")
                Spacer(modifier = Modifier.size(30.dp))
                Text(text = "João Carlos Pereira")
                Text(text = "**** **** **** 3727")
                Row {
                    Text(text = "Validade")
                    Spacer(modifier = Modifier.size(6.dp))
                    Text(text = "06/29")
                }
            }
        }
    }
}

@Preview(name = "Card", showBackground = true)
@Composable
fun CardComponentPreview() {
    WalletLigthTheme {
        CardComponent()
    }
}