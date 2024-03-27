package kr.co.lion.android01.jetpackcolume


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.lion.android01.jetpackcolume.ui.theme.JetpackColumeTheme

//Colume
//spacer
//divider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackColumeTheme {
                ColumnTest1()
                PracticeButton()

            }
        }
    }
}

@Composable
fun ColumnTest1(){
    Column (
        modifier = Modifier.padding(30.dp)
    ){
        Text(
            text = "안녕하세요 1",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.padding(30.dp))
        Divider(
            thickness = 4.dp,
            color = Color.Red
        )
        Text(
            text = "반갑습니다 1",
            fontSize = 30.sp,
        )
    }

}

@Composable
fun PracticeButton(){
    Column {
        Button(onClick = {

        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red

            ),
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
        ) {
            Text(
                text = "버튼이지롱",
                fontSize = 20.sp
            )
    }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackColumeTheme {
        ColumnTest1()
        PracticeButton()

    }
}