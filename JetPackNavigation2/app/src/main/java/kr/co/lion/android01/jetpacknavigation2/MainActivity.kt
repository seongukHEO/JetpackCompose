package kr.co.lion.android01.jetpacknavigation2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.co.lion.android01.jetpacknavigation2.ui.theme.JetPackNavigation2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackNavigation2Theme {
                MyNav(navHostController = rememberNavController())
            }
        }
    }
}

@Composable
fun MyGridScreen(navController: NavHostController){

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.padding(20.dp),
    ){
        items(15){ number ->

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .border(1.dp, color = Color.Black)
                    .clickable {
                        navController.navigate("myNumberScreen/$number")
                    }
            ){
                Text(
                    text = number.toString(),
                    fontSize = 30.sp
                )
            }
        }
    }
}

@Composable
fun MyNumberScreen(number:String?){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),
    ){
        Text(
            text = number.toString(),
            fontSize = 70.sp
        )
    }
}

//연결
@Composable
fun MyNav(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = "myGridScreen") {
        composable("myGridScreen") {
            MyGridScreen(navHostController)
        }
        composable("myNumberScreen/{number}") {
            MyNumberScreen(number = it.arguments?.getString("number"))
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackNavigation2Theme {
        MyNav(navHostController = rememberNavController())
    }
}