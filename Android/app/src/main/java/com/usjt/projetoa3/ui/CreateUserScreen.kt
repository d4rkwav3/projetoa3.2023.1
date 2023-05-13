package com.usjt.projetoa3.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.usjt.projetoa3.R
import com.usjt.projetoa3.Router
import com.usjt.projetoa3.data.User
import com.usjt.projetoa3.model.DataValidation
import com.usjt.projetoa3.model.EmailValidation
import com.usjt.projetoa3.model.PasswordValidation
import com.usjt.projetoa3.ui.theme.ProjetoA3Theme
import kotlinx.coroutines.newSingleThreadContext

@Composable
fun CreateUserAccount(
    userInfo: User,
    dataValidation: DataValidation,
    emailValidation: EmailValidation,
    passwordValidation: PasswordValidation,
    nameOnValueChange: (String) -> Unit = {},
    emailOnValueChange: (String) -> Unit = {},
    passwordOnValueChange: (String) -> Unit = {},
    confirmPassword: String? = null,
    confirmPasswordOnValueChange: (String) -> Unit = {},
    ageOnValueChange: (String) -> Unit = {},
    weightOnValueChange: (String) -> Unit = {},
    heightOnValueChange: (String) -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp, bottom = 60.dp, end = 40.dp)
    ) {
        TextField(
            value = userInfo.name ?: "",
            onValueChange = { new -> nameOnValueChange(new) },
            label = { Text(text = stringResource(id = R.string.full_name)) },
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
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = userInfo.email ?: "",
            onValueChange = { new -> emailOnValueChange(new) },
            label = { Text(text = stringResource(id = R.string.email)) },
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
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = userInfo.password ?: "",
            onValueChange = { new -> passwordOnValueChange(new) },
            label = { Text(text = stringResource(id = R.string.password)) },
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
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = confirmPassword ?: "",
            onValueChange = { new -> confirmPasswordOnValueChange(new) },
            label = { Text(text = stringResource(id = R.string.password_confirmation)) },
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
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Row {
            TextField(
                value = userInfo.age?.toString() ?: "",
                onValueChange = { new -> ageOnValueChange(new) },
                label = { Text(text = stringResource(id = R.string.age)) },
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
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword,
                    imeAction = ImeAction.Next
                ),
                singleLine = true,
                modifier = Modifier.weight(2f)
            )
            Spacer(modifier = Modifier.width(15.dp))
            TextField(
                value = userInfo.weight?.toString() ?: "",
                onValueChange = { new -> weightOnValueChange(new) },
                label = { Text(text = stringResource(id = R.string.weight)) },
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
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword,
                    imeAction = ImeAction.Next
                ),
                singleLine = true,
                modifier = Modifier.weight(2f)
            )
        }
        Row() {
            TextField(
                value = userInfo.height?.toString() ?: "",
                onValueChange = { new -> heightOnValueChange(new) },
                label = { Text(text = stringResource(id = R.string.height)) },
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
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword,
                    imeAction = ImeAction.Done
                ),
                singleLine = true,
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
            text = stringResource(id = R.string.warning_1),
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
                Text(text = stringResource(id = R.string.button_free_upper))
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
                Text(text = stringResource(id = R.string.button_paid_upper))
            }
        }
        Text(
            text = stringResource(id = R.string.warning_2),
            textDecoration = TextDecoration.Underline,
            fontSize = 12.sp,
        )
    }
}

@Composable
fun CreateNewUserScreen(
    newAccount: CreateUserViewModel = CreateUserViewModel(),
    navController: NavController? = null
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        ProjetoA3Theme {
            val info by newAccount.userData.collectAsState()
            val dataCheck by newAccount.dataValidation.collectAsState()
            val emailCheck by newAccount.emailValidation.collectAsState()
            val passCheck by newAccount.passwordValidation.collectAsState()
            var confirmPassword by remember { mutableStateOf("") }

            ShowLogo(
                icon = R.drawable.icon,
                iconTopPadding = 30,
                iconSize = 120,
                textTopPadding = 145,
                textSize = 24
            )
            CreateUserAccount(
                userInfo = info,
                dataValidation = dataCheck,
                emailValidation = emailCheck,
                passwordValidation = passCheck,
                nameOnValueChange = { newAccount.setName(it) },
                emailOnValueChange = { newAccount.setEmail(it) },
                passwordOnValueChange = { newAccount.setPassword(it) },
                confirmPassword = confirmPassword,
                confirmPasswordOnValueChange = {
                    confirmPassword = it
                    newAccount.confirmPassword(it)
                },
                ageOnValueChange = { newAccount.setAge(it) },
                weightOnValueChange = { newAccount.setWeight(it) },
                heightOnValueChange = { newAccount.setHeight(it) }
            )
            AccountTypeButtons()
            BottomButtons(
                topButtonText = R.string.button_continue_upper,
                bottomButtonText = R.string.login_screen_text,
                bottomButtonAction = { navController?.navigate(Router.Login.name) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateUserPreview() {
    CreateNewUserScreen()
}