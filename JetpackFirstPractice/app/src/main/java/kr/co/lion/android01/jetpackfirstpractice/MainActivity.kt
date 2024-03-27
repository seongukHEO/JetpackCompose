package kr.co.lion.android01.jetpackfirstpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.lion.android01.jetpackfirstpractice.ui.theme.JetpackFirstPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackFirstPracticeTheme {
                Practice()

            }
        }
    }
}

@Composable
fun Practice(){
    //입력
    var textState by remember {
        mutableStateOf("")
    }
    //결과
    var resultState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = textState,
            onValueChange = {textState = it},
            label = { Text(text = "여기다가 검색")},
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
        )
        Button(onClick = {
            resultState = textState
        },
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "결과")

        }

        Spacer(modifier = Modifier.height(100.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Gray)
                .align(Alignment.CenterHorizontally)
                .height(50.dp)
        ){
            Text(
                text = "결과 : $resultState",
                color = Color.Black
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackFirstPracticeTheme {
        Practice()

    }
}