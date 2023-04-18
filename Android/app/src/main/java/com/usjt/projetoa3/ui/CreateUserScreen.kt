package com.usjt.projetoa3.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.usjt.projetoa3.R
import com.usjt.projetoa3.ui.theme.BottomButtons
import com.usjt.projetoa3.ui.theme.ProjetoA3Theme
import com.usjt.projetoa3.ui.theme.ShowLogo

@Composable
fun CreateUserAccount() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp, end = 40.dp)
    ) {
        TextField(
            value = "",
            onValueChange = { /*TODO*/ },
            label = { Text(text = "Nome completo") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
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
        TextField(
            value = "",
            onValueChange = { /*TODO*/},
            label = { Text(text = "Senha") },
            leadingIcon = { Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "",
                tint = Color.Black
            )},
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Black,
            ),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = "",
            onValueChange = { /*TODO*/},
            label = { Text(text = "Confirmação de senha") },
            leadingIcon = { Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "",
                tint = Color.Black
            )},
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Black,
            ),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Row {
            TextField(
                value = "",
                onValueChange = { /*TODO*/ },
                label = { Text(text = "Idade") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "",
                        tint = Color.Black
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Black,
                ),
                modifier = Modifier.weight(2f)
            )
            Spacer(modifier = Modifier.width(15.dp))
            TextField(
                value = "",
                onValueChange = { /*TODO*/ },
                label = { Text(text = "Peso") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Accessibility,
                        contentDescription = "",
                        tint = Color.Black
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Black,
                ),
                modifier = Modifier.weight(2f)
            )
        }
        Row() {
            TextField(
                value = "",
                onValueChange = { /*TODO*/ },
                label = { Text(text = "Altura") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.altura_24dp),
                        contentDescription = "",
                        tint = Color.Black
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Black,
                ),
                modifier = Modifier.weight(2f)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Spacer(modifier = Modifier.weight(2f))
        }
    }
}

@Composable
fun AccountTypeButtons() {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp, bottom = 140.dp, end = 40.dp)
    ) {
        Text(
            text = "*Selecione a versão que deseja utilizar:",
            textDecoration = TextDecoration.Underline,
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                enabled = false,
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    disabledBackgroundColor = Color.DarkGray,
                    disabledContentColor = Color.White
                ),
                modifier = Modifier.weight(2f)
            ) {
                Text(text = "GRATUITA")
            }
            Spacer(modifier = Modifier.width(15.dp))
            Button(
                enabled = false,
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    disabledBackgroundColor = Color.DarkGray,
                    disabledContentColor = Color.White
                ),
                modifier = Modifier.weight(2f)
            ) {
                Text(text = "PAGA")
            }
        }
        Text(
            text = "*Essa opção pode ser alterada posteriormente",
            textDecoration = TextDecoration.Underline,
            fontSize = 12.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CreateUserPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        ProjetoA3Theme {
            ShowLogo()
            CreateUserAccount()
            AccountTypeButtons()
            BottomButtons(
                topButtonText = R.string.button_continue_upper,
                bottomButtonText = R.string.login_screen_text
            )
        }
    }
}