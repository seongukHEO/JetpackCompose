package kr.co.lion.android01.jetpackuserdrawerpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kr.co.lion.android01.jetpackuserdrawerpractice.ui.theme.JetpackUserDrawerPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackUserDrawerPracticeTheme {
                MyDrawerPractice()

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDrawerPractice(){

    //우선 drawer메뉴의 상태는 닫힌 상태이다
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val screenList = listOf(
        Screen.Seonguk,
        Screen.Gyerim,
        Screen.Pepe,
        Screen.Kongjaban
    )

    //어떤 메뉴가 선택되어 있는지
    val selectMenu : MutableState<Screen> = remember {
        mutableStateOf(Screen.Seonguk)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "나의 메뉴") },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch { drawerState.open() }
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                }


            )
        }
    ) {paddingValues ->
        ModalNavigationDrawer(
            drawerState = drawerState,
            modifier = Modifier.padding(paddingValues),
            drawerContent = {
                ModalDrawerSheet {
                    screenList.forEach {
                        NavigationDrawerItem(
                            icon = {Icon(it.icon, contentDescription = it.icon.name)},
                            label = { Text(text = it.name) },
                            selected = it == selectMenu.value ,
                            onClick = {
                                selectMenu.value = it
                                scope.launch { drawerState.close() }
                            })
                    }
                }
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    when(selectMenu.value){
                        Screen.Seonguk -> Seonguk()
                        Screen.Gyerim -> Gyerim()
                        Screen.Pepe -> Pepe()
                        Screen.Kongjaban -> Kongjaban()

                    }
                }
            }
        )



    }


}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Seonguk(){

    var textState by remember {
        mutableStateOf("Hello")
    }
    
    TextField(value = textState, onValueChange = {textState = it},
        label = { Text(text = "입력해주세요")}
        )
}

@Composable
fun Gyerim(){
    Button(onClick = {

    }) {
        Text(text = "계림 공듀~")
    }
}

@Composable
fun Pepe(){
    Text(text = "페페지롱~")
}

@Composable
fun Kongjaban(){
    Text(text = "나는야 콩자반!")
}


sealed class Screen(var name:String, var icon: ImageVector){
    object Seonguk : Screen("Seonguk", Icons.Default.AccountCircle)
    object Gyerim : Screen("Gyerim", Icons.Default.AccountCircle)
    object Pepe : Screen("pepe", Icons.Default.Favorite)
    object Kongjaban : Screen("kongjaban", Icons.Default.Lock)

}








@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackUserDrawerPracticeTheme {

    }
}