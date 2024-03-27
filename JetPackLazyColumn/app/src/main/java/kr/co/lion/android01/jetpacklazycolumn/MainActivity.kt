package kr.co.lion.android01.jetpacklazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kr.co.lion.android01.jetpacklazycolumn.ui.theme.JetPackLazyColumnTheme

//LazytColumn
//사용자만 보는 부분만 로드한다..?
//필요한 부분만 로드한다

//LazyRow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackLazyColumnTheme {
                MyLazyRowEX()
            }
        }
    }
}

@Composable
fun MyLazyColumnEX(){

    val textList = listOf("a", "b", "c", "d", "g", "H", "E", "O")

    LazyColumn{
        items(textList){ item->
            Text(
                text = item,
                fontSize = 60.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}



@Composable
fun MyLazyRowEX(){
    val textList = listOf("a", "b", "c", "d", "g", "H", "E", "O", "S", "E", "o", "n", "g", "u", "k")

    LazyRow{
        items(textList){item ->
            Text(
                text = item,
                fontSize = 60.sp,
                modifier = Modifier.clickable {
                    println("Clicked item : $item")
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackLazyColumnTheme {
        MyLazyRowEX()
    }
}