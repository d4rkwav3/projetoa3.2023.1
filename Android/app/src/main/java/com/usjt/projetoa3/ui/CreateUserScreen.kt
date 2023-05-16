package com.usjt.projetoa3.ui

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.usjt.projetoa3.R
import com.usjt.projetoa3.Router
import com.usjt.projetoa3.data.NewUser
import com.usjt.projetoa3.model.DataValidation
import com.usjt.projetoa3.model.EmailValidation
import com.usjt.projetoa3.model.PasswordValidation
import com.usjt.projetoa3.ui.theme.ProjetoA3Theme

@Composable
fun CreateUserAccount(
    userInfo: NewUser,
    dataValidation: DataValidation,
    emailValidation: EmailValidation,
    passwordValidation: PasswordValidation,
    nameOnValueChange: (String) -> Unit = {},
    emailOnValueChange: (String) -> Unit = {},
    passwordOnValueChange: (String) -> Unit = {},
    confirmPasswordOnValueChange: (String) -> Unit = {},
    ageOnValueChange: (String) -> Unit = {},
    weightOnValueChange: (String) -> Unit = {},
    heightOnValueChange: (String) -> Unit = {},
    isNameInvalid: Boolean = false,
    isEmailInvalid: Boolean = false,
    isPasswordInvalid: Boolean = false,
    isPasswordConfirmed: Boolean = false,
    isAgeInvalid: Boolean = false,
    isWeightInvalid: Boolean = false,
    isHeightInvalid: Boolean = false
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(start = 40.dp, bottom = 60.dp, end = 40.dp)
    ) {
        if(isNameInvalid)
            Text(
                text = stringResource(id = R.string.invalid_name),
                color = Color.Red,
                maxLines = 1,
                textAlign = TextAlign.Center,
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth()
            )
        TextField(
            value = userInfo.name ?: "",
            onValueChange = {
                    new -> nameOnValueChange(new)
                    dataValidation.validateName(new)
                            },
            label = { Text(text = stringResource(id = R.string.full_name)) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                    tint = when(isNameInvalid) {
                        false -> Color.Black
                        true -> Color.Red
                    }
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
            isError = isNameInvalid,
            modifier = Modifier
                .fillMaxWidth()
        )
        if(isEmailInvalid)
            Text(
                text = stringResource(id = R.string.invalid_email),
                color = Color.Red,
                maxLines = 1,
                textAlign = TextAlign.Center,
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth()
            )
        TextField(
            value = userInfo.email ?: "",
            onValueChange = {
                    new -> emailOnValueChange(new)
                    emailValidation.validateEmail(new)
                            },
            label = {
                if(isEmailInvalid) {
                    Text(text = stringResource(id = R.string.invalid_email))
                } else {
                    Text(text = stringResource(id = R.string.email))
                }
                    },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "",
                    tint = when(isEmailInvalid) {
                        false -> Color.Black
                        true -> Color.Red
                    }
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
        if(isPasswordInvalid) {
            Text(
                text = stringResource(id = R.string.invalid_password_1),
                color = Color.Red,
                maxLines = 1,
                textAlign = TextAlign.Center,
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = stringResource(id = R.string.invalid_password_2),
                color = Color.Red,
                maxLines = 1,
                textAlign = TextAlign.Center,
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }
        TextField(
            value = userInfo.password ?: "",
            onValueChange = {
                    new -> passwordOnValueChange(new)
                    passwordValidation.validatePassword(new)
                            },
            label = {
                if(isPasswordInvalid) {
                    Text(text = stringResource(id = R.string.invalid_password_1))
                } else {
                    Text(text = stringResource(id = R.string.password))
                }
            },
            leadingIcon = { Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "",
                tint = when(isPasswordInvalid) {
                    false -> Color.Black
                    true -> Color.Red
                }
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
        if(isPasswordConfirmed)
            Text(
                text = stringResource(id = R.string.invalid_password_confirmation),
                color = Color.Red,
                maxLines = 1,
                textAlign = TextAlign.Center,
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth()
            )
        TextField(
            value = userInfo.confirmPassword ?: "",
            onValueChange = {
                    new -> confirmPasswordOnValueChange(new)
                    passwordValidation.confirmPassword(userInfo.password ?: "", new)
                            },
            label = {
               Text(text = stringResource(id = R.string.password_confirmation))
            },
            leadingIcon = { Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "",
                tint = when(isPasswordConfirmed) {
                    false -> Color.Black
                    true -> Color.Red
                }
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
        if(isAgeInvalid)
            Text(
                text = stringResource(id = R.string.invalid_age),
                color = Color.Red,
                maxLines = 1,
                textAlign = TextAlign.Center,
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth()
            )
        if(isWeightInvalid)
            Text(
                text = stringResource(id = R.string.invalid_weight),
                color = Color.Red,
                maxLines = 1,
                textAlign = TextAlign.Center,
                fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth()
            )
        Row {
            TextField(
                value = userInfo.age?.toString() ?: "",
                onValueChange = {
                        new -> ageOnValueChange(new)
                        dataValidation.validateAge(new.toInt())
                                },
                label = {
                    Text(text = stringResource(id = R.string.age))
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "",
                        tint = when(isAgeInvalid) {
                            false -> Color.Black
                            true -> Color.Red
                        }
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
                modifier = Modifier.weight(2f),
                isError = isAgeInvalid
            )
            Spacer(modifier = Modifier.width(15.dp))
            TextField(
                value = userInfo.weight?.toString() ?: "",
                onValueChange = { new -> weightOnValueChange(new) },
                label = {
                    Text(text = stringResource(id = R.string.weight))
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Accessibility,
                        contentDescription = "",
                        tint = when(isWeightInvalid) {
                            false -> Color.Black
                            true -> Color.Red
                        }
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
        Row {
            if(isHeightInvalid)
                Text(
                    text = stringResource(id = R.string.invalid_height),
                    color = Color.Red,
                    maxLines = 1,
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            TextField(
                value = userInfo.height?.toString() ?: "",
                onValueChange = {
                        new -> heightOnValueChange(new)
                                },
                label = {
                    Text(text = stringResource(id = R.string.height))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.altura_24dp),
                        contentDescription = "",
                        tint = when(isHeightInvalid) {
                            false -> Color.Black
                            true -> Color.Red
                        }
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
                confirmPasswordOnValueChange = { newAccount.confirmPassword(it) },
                ageOnValueChange = { newAccount.setAge(it) },
                weightOnValueChange = { newAccount.setWeight(it) },
                heightOnValueChange = { newAccount.setHeight(it) },
                isNameInvalid = dataCheck.isNameInvalid,
                isEmailInvalid = emailCheck.isEmailInvalid,
                isPasswordInvalid = passCheck.isPasswordInvalid,
                isPasswordConfirmed = passCheck.isPasswordConfirmed,
                isAgeInvalid = dataCheck.isAgeInvalid,
                isWeightInvalid = dataCheck.isWeightInvalid,
                isHeightInvalid = dataCheck.isHeightInvalid
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