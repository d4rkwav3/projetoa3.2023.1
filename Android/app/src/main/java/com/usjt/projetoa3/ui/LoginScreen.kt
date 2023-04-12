package com.usjt.projetoa3.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.usjt.projetoa3.R

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
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "My Health Logo",
                modifier = Modifier
                    .padding(top = 40.dp, bottom = 5.dp)
                    .size(300.dp)
            )
            Text(
                text = "My Health",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                modifier = Modifier.padding(top = 180.dp)
            )
        }
    }
}

@Composable
fun LoginInput() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = "",
            onValueChange = { /*TODO*/},
            label = { Text(text = "E-mail") },
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
            visualTransformation = PasswordVisualTransformation()
        )
    }
}

@Composable
fun NewUserButtonForgetMyPass() {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(
                text = "CADASTRAR-SE",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 30.dp,end = 30.dp)
            )
        }
        Text(
            text = "Esqueci minha senha",
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 40.dp)
                .clickable { /*TODO*/ }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        ProjetoA3Theme {
            ShowLogo()
            LoginInput()
            NewUserButtonForgetMyPass()
        }
    }
}