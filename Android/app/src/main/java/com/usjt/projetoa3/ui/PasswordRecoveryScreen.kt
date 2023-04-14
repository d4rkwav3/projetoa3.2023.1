package com.usjt.projetoa3.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.usjt.projetoa3.ui.theme.BottomButtons
import com.usjt.projetoa3.ui.theme.ProjetoA3Theme
import com.usjt.projetoa3.ui.theme.ShowLogo

@Composable
fun ConfirmButton() {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

    }
}

@Composable
fun ScreenInfo() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp)
    ) {
        Text(
            text = "Recuperação de Senha",
            textDecoration = TextDecoration.Underline,
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 20.dp, top = 300.dp)
        )
        Text(
            text = "Informe seu e-mail que enviaremos um link para a recuperação de senha",
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 20.dp)
        )
        TextField(
            value = "",
            onValueChange = { /*TODO*/ },
            label = { Text(text = "E-mail") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "",
                    tint = Color.Black
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Black,
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PasswordRecoveryPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        ProjetoA3Theme() {
            ShowLogo()
            ScreenInfo()
            BottomButtons(topButtonText = "ENVIAR", bottomButtonText = "Tela de Login")
        }
    }
}