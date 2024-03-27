package kr.co.lion.android01.jetpackscaffold

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.simulateHotReload
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.lion.android01.jetpackscaffold.ui.theme.JetPackScaffoldTheme

//Scaffold : 골격을 만들기 쉽게 해준다

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackScaffoldTheme {
                MyScaffoldEX()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyScaffoldEX(){
    
    Scaffold(
        topBar = {
            MyTopBar()
        },
        floatingActionButton = {
            MyFloatingActionButton()
        },
        bottomBar = {
            MyBottomBar()
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Text(text = "이건 Scaffold이다")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(){
    
    TopAppBar(
        title = { Text(text = "Main") },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Add, contentDescription = "add")
            }
        },
        actions = {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.outlinedButtonColors(
                    Color.Red
                ),
                border = BorderStroke(1.dp, color = Color.Black)
            ) {
                Text(
                    text = "Btn",
                    color = Color.Green,

                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(Color.Red)
    )
    
}

@Composable
fun MyFloatingActionButton(){
    FloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Default.Menu, contentDescription = "Menu")
    }
}

@Composable
fun MyBottomBar(){

    BottomAppBar(
        containerColor = Color.Red
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.AccountBox, contentDescription = "Box")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Home, contentDescription = "Home")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Settings, contentDescription = "settings")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackScaffoldTheme {
        MyScaffoldEX()
    }
}