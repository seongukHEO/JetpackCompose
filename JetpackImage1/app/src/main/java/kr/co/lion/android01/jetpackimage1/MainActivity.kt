package kr.co.lion.android01.jetpackimage1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kr.co.lion.android01.jetpackimage1.ui.theme.JetpackImage1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackImage1Theme {
                PracticeTextField()

            }
        }
    }
}

@Composable
fun MyImageText(){
    Image(
        painter = painterResource(id = R.drawable.china_gh), contentDescription = "Heo",
        modifier = Modifier.fillMaxSize()
    )
}


//TextField를 다시 연습해보자
@Composable
fun PracticeTextField(){
    //기본값
    var textState by remember {
        mutableStateOf("")
    }

    //결과값
    var resultState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = textState,
            onValueChange = {textState = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "여기다가 입력하시오"
        )})
        Button(onClick = {
            resultState = textState
        },
            modifier = Modifier.fillMaxWidth()
            ) {
            Text(text = "입력하기")

        }

        Text(text = "결과 : $resultState")
    }

}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackImage1Theme {
        PracticeTextField()

    }
}