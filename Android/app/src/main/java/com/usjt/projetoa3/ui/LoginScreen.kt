package com.usjt.projetoa3.ui

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.usjt.projetoa3.R
import com.usjt.projetoa3.ui.theme.ProjetoA3Theme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext

@Composable
fun ShowLogo() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "My Health Logo",
                modifier = Modifier
                    .padding(top = 60.dp, bottom = 5.dp)
                    .size(150.dp)
            )
            Text(
                text = stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                modifier = Modifier.padding(top = 200.dp)
            )
        }
    }
}

@Composable
fun LoginInput(
    emailFieldValue: String = "",
    passwordFieldValue: String = "",
    emailOnValueChange: (String) -> Unit = { },
    passwordOnValueChange: (String) -> Unit = { }
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = emailFieldValue,
            onValueChange = { next -> emailOnValueChange(next) },
            label = { Text(text = stringResource(id = R.string.email)) },
            placeholder = { Text(text = stringResource(id = R.string.type_your_email)) },
            leadingIcon = { Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "",
                tint = Color.Black
            )},
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Black,
            )
        )
        TextField(
            value = passwordFieldValue,
            onValueChange = { next -> passwordOnValueChange(next) },
            label = { Text(text = stringResource(id = R.string.password)) },
            placeholder = { Text(text = stringResource(id = R.string.type_your_password)) },
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
            visualTransformation = PasswordVisualTransformation()
        )
    }
}

@Composable
fun BottomButtons(
    @StringRes topButtonText: Int,
    @StringRes bottomButtonText: Int,
    topButtonAction: () -> Unit = { }
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 70.dp, end = 70.dp)
    ) {
        Button(
            onClick = { topButtonAction() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = topButtonText),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
        Text(
            text = stringResource(id = bottomButtonText),
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 40.dp)
                .clickable { /*TODO*/ }
        )
    }
}

@Composable
fun RegisterClickableText(
    @StringRes clickableText: Int,
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = clickableText),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .padding(top = 160.dp, bottom = 40.dp)
                .clickable { /*TODO*/ }
        )
    }
}

@Composable
fun CreateLoginScreen(
    loginViewModel: LoginViewModel = LoginViewModel(),
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        ProjetoA3Theme {
            ShowLogo()
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val context = LocalContext.current
                val loginState by loginViewModel.loginState.collectAsState()

                Spacer(modifier = Modifier.height(60.dp))

                LoginInput(
                    loginState.email,
                    loginState.password,
                    { loginViewModel.setUserEmail(it) },
                    { loginViewModel.setUserPassword(it) }
                )

                Spacer(modifier = Modifier.height(40.dp))

                BottomButtons(
                    topButtonText = R.string.button_sign_in_upper,
                    bottomButtonText = R.string.forgot_my_password,
                    topButtonAction = {
                        Toast.makeText(
                            context,
                            "${loginState.email}\n${loginState.password}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
            }
            RegisterClickableText(clickableText = R.string.register)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    CreateLoginScreen()
}