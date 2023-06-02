package com.usjt.projetoa3.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.usjt.projetoa3.ui.theme.ProjetoA3Theme


@Composable
fun CreateHomeScreen(
//    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory),
    navController: NavController? = null
) {
    Scaffold(
        topBar = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .height(64.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Dashboard",
                    color = Color.White,
                    fontSize = 28.sp,
                    modifier = Modifier.padding(start = 12.dp, top = 12.dp)
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "Option",
                        tint = Color.White,
                        modifier = Modifier.size(42.dp).padding(top = 10.dp)
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = MaterialTheme.colors.primary,
                onClick = { /*TODO*/ }
            ) { Icon(imageVector = Icons.Filled.Add, contentDescription = "Plus") }
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Text(
                text = "Dashboard a implementar",
                textAlign = TextAlign.Center,
                fontSize = 48.sp,
                modifier = Modifier.fillMaxWidth()
            )
    }
    }
}

@Preview
@Composable
fun HomePreview() {
    ProjetoA3Theme() {
        CreateHomeScreen()
    }
}