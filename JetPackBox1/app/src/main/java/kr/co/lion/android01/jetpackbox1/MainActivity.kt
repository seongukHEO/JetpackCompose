package kr.co.lion.android01.jetpackbox1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.lion.android01.jetpackbox1.ui.theme.JetPackBox1Theme

//Box
//적당히 레이아웃 항목을 겹쳐서 내가 원하는 위치에 배치할 수 있다
//간단히 생각하면 Flutter에서 Container와 매우 비슷하네

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackBox1Theme {
                BoxEX()
            }
        }
    }
}

@Composable
fun BoxEX(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red)

    ){
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Yellow)
                .padding(16.dp)
                .align(Alignment.TopStart)
        ){
            Text(text = "왼쪽위")
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Gray)
                .padding(16.dp)
                .align(Alignment.TopCenter)
        ){
            Text(text = "중앙위")
        }
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Green)
                .padding(16.dp)
                .align(Alignment.TopEnd)
        ){
            Text(text = "오른쪽 위")
        }

        Button(onClick = { },
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Text(text = "중앙 왼쪽")
        }
        Button(onClick = { },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = "중앙 ")
        }
        Button(onClick = { },
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Text(text = "중앙 오른쪽")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackBox1Theme {
        BoxEX()
    }
}