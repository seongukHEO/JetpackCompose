package kr.co.lion.android01.jetpackcard1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import kr.co.lion.android01.jetpackcard1.ui.theme.JetPackCard1Theme

//Card

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackCard1Theme {

                Column {
                    CardTest(1)
                    CardTest(2)
                    CardTest(3)
                    CardTest(4)
                }

            }
        }
    }
}

@Composable
fun CardTest(text1:Int){

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp),
        //그림자 만들어주기 elevation
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        //테두리를 둥글게 만들어준다
        shape = RoundedCornerShape(50.dp),
        //테두리를 만든다.
        border = BorderStroke(1.dp, color = Color.Black)
    ){
        //Card안에 Box가 들어갔고 크기를 Card에 맞게 꽉 채웠다
        Box (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "$text1",
                fontSize = 30.sp
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackCard1Theme {
        Column {
            CardTest(1)
            CardTest(2)
            CardTest(3)
            CardTest(4)
        }
    }
}