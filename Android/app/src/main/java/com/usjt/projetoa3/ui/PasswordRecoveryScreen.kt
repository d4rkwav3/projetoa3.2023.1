package com.usjt.projetoa3.ui

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.usjt.projetoa3.R
import com.usjt.projetoa3.Router
import com.usjt.projetoa3.ui.theme.ProjetoA3Theme

@Composable
fun PasswordRecoveryInfo(
    @StringRes title: Int,
    @StringRes text: Int,
    @StringRes textFieldHint: Int,
    @StringRes iconContentDescription: Int,
    textFieldValue: String = "",
    textFieldOnValueChange: (String) -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp)
    ) {
        Text(
            text = stringResource(id = title),
            textDecoration = TextDecoration.Underline,
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 20.dp, top = 300.dp)
        )
        Text(
            text = stringResource(id = text),
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 20.dp)
        )
        TextField(
            value = textFieldValue,
            onValueChange = { new -> textFieldOnValueChange(new) },
            label = { Text(text = stringResource(id = textFieldHint)) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = stringResource(id = iconContentDescription),
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

@Composable
fun CreateRecoveryScreen(
    recoveryViewModel: PasswordRecoveryViewModel = PasswordRecoveryViewModel(),
    navController: NavController? = null
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        ProjetoA3Theme {
            val state by recoveryViewModel.State.collectAsState()
            val context = LocalContext.current

            ShowLogo(icon = R.drawable.icon)

            PasswordRecoveryInfo(
                title = R.string.password_recovery_title,
                text = R.string.password_recovery_text,
                textFieldHint = R.string.email,
                iconContentDescription = R.string.email_icon_description,
                textFieldValue = state.email,
                textFieldOnValueChange = { recoveryViewModel.setEmailForRecovery(it) }
            )

            BottomButtons(
                topButtonText = R.string.button_send_upper,
                bottomButtonText = R.string.login_screen_text,
                topButtonAction = {
                    Toast.makeText(
                        context,
                        recoveryViewModel.recoveryMessage,
                        Toast.LENGTH_LONG
                    ).show()
                },
                bottomButtonAction = {
                    navController?.navigate(Router.Login.name)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PasswordRecoveryPreview() {
    CreateRecoveryScreen()
}