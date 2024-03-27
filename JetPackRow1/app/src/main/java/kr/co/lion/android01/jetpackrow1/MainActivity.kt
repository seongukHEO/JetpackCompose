package kr.co.lion.android01.jetpackrow1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kr.co.lion.android01.jetpackrow1.ui.theme.JetPackRow1Theme

//Row : 가로 정렬
//Column : 세로 정렬

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackRow1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RowTest()
                }
            }
        }
    }
}

@Composable
fun RowTest(){
    Row(
        modifier = Modifier.fillMaxSize().background(Color.Gray),
        //가로로 동일한 간격
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Item1",
            style = TextStyle(background = Color.Blue),
            fontSize = 30.sp
        )

        Text(
            text = "Item2",
            style = TextStyle(background = Color.Red),
            fontSize = 30.sp
        )

        Text(
            text = "Item3",
            style = TextStyle(background = Color.Green),
            fontSize = 30.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackRow1Theme {
        RowTest()
    }
}