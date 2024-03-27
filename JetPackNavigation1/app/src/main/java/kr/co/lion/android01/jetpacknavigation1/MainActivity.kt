package kr.co.lion.android01.jetpacknavigation1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.co.lion.android01.jetpacknavigation1.ui.theme.JetPackNavigation1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackNavigation1Theme {

                MyNav()
            }
        }
    }
}


@Composable
fun MyScreen1(navController: NavHostController){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "화면 1",
            fontSize = 50.sp
        )
        Button(onClick = {
            navController.navigate("myScreen2")
        }) {
            Text(
                text = "2번 화면으로 가기",
                fontSize = 30.sp
            )
        }
    }

}

@Composable
fun MyScreen2(navController: NavHostController){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "화면 2",
            fontSize = 50.sp
        )
        Button(onClick = {
            navController.navigate("myScreen3")
        }) {
            Text(
                text = "3번 화면으로 가기",
                fontSize = 30.sp
            )
        }
    }

}

@Composable
fun MyScreen3(navController: NavHostController){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "화면 3",
            fontSize = 50.sp
        )
        Button(onClick = {
            navController.navigate("myScreen1")
        }) {
            Text(
                text = "1번 화면으로 가기",
                fontSize = 30.sp
            )
        }
    }

}

@Composable
fun MyNav(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "myScreen1"){
        composable("myScreen1"){
            MyScreen1(navController = navController)
        }
        composable("myScreen2"){
            MyScreen2(navController = navController)
        }
        composable("myScreen3"){
            MyScreen3(navController = navController)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackNavigation1Theme {
        MyNav()

    }
}