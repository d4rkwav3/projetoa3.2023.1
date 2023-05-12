package com.usjt.projetoa3.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.usjt.projetoa3.ui.theme.ProjetoA3Theme

@Composable
fun CreateUserAccount(
    name: String? = null,
    nameOnValueChange: (String) -> Unit = {},
    email: String? = null,
    emailOnValueChange: (String) -> Unit = {},
    password: String? = null,
    passwordOnValueChange: (String) -> Unit = {},
    confirmPassword: String? = null,
    confirmPasswordOnValueChange: (String) -> Unit = {},
    age: String? = null,
    ageOnValueChange: (String) -> Unit = {},
    weight: String? = null,
    weightOnValueChange: (String) -> Unit = {},
    height: String? = null,
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
            value = name ?: "",
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
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = email ?: "",
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
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = password ?: "",
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
            modifier = Modifier.fillMaxWidth()
        )
        Row {
            TextField(
                value = age ?: "",
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
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.weight(2f)
            )
            Spacer(modifier = Modifier.width(15.dp))
            TextField(
                value = weight ?: "",
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
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.weight(2f)
            )
        }
        Row() {
            TextField(
                value = height ?: "",
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
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
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
            var confirmPassword by remember { mutableStateOf("") }

            ShowLogo(
                icon = R.drawable.icon,
                iconTopPadding = 30,
                iconSize = 120,
                textTopPadding = 145,
                textSize = 24
            )
            CreateUserAccount(
                name = info.name,
                nameOnValueChange = { newAccount.setName(it) },
                email = info.email,
                emailOnValueChange = { newAccount.setEmail(it) },
                password = info.password,
                passwordOnValueChange = { newAccount.setPassword(it) },
                confirmPassword = confirmPassword,
                confirmPasswordOnValueChange = {
                    confirmPassword = it
                    newAccount.confirmPassword(it)
                },
                age = newAccount.tempAge,
                ageOnValueChange = { newAccount.setAge(it) },
                weight = newAccount.tempWeight,
                weightOnValueChange = { newAccount.setWeight(it) },
                height = newAccount.tempHeight,
                heightOnValueChange = { newAccount.setHeight(it) },
            )
            AccountTypeButtons()
            BottomButtons(
                topButtonText = R.string.button_continue_upper,
                bottomButtonText = R.string.login_screen_text
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateUserPreview() {
    CreateNewUserScreen()
}