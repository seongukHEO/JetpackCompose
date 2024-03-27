package kr.co.lion.android01.jetpacktextfield1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.co.lion.android01.jetpacktextfield1.ui.theme.JetpackTextField1Theme
import androidx.compose.runtime.remember as remember


//TextField


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTextField1Theme {
                TestTextField2()
            }
        }
    }
}

@Composable
fun MyTextField1(){


    var textState by remember { mutableStateOf("Hello") }

    TextField(
        value = textState , onValueChange = {
            textState = it
        },
        //label = 힌트의 느낌
        label = {
            Text(text = "입력하는 공간")
        }
    )


}

@Composable
fun MyTextField2(){
    //입력한 부분
    var textState by remember {
        mutableStateOf("")
    }
    //결과값 부분
    var enteredText by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = textState, onValueChange = {textState = it}, modifier = Modifier.fillMaxWidth())
        Button(onClick = {
            enteredText = textState
        },
            modifier = Modifier.fillMaxWidth()
            ) {
            Text(text = "입력하기")

        }
        Text(text = "결과값 테스트 : ${enteredText}")
    }
}







@Composable
fun TestTextField(){

    //text에 들어갈 값
    var textState by remember {
        mutableStateOf("Hello")
    }

    TextField(value = textState, onValueChange = {textState = it},
        label = {
            Text(text = "입력하시오")
        }

    )

}


@Composable
fun TestTextField2(){
    //입력한 부분
    var textState by remember {
        mutableStateOf("")
    }

    //결과값 부분
    var textState2 by remember {
        mutableStateOf("")
    }
    Column {

        TextField(value = textState, onValueChange = {
            textState = it
        })


        Button(onClick = {
            textState2 = textState

        },
            modifier = Modifier.fillMaxWidth()
            ) {
            Text(text = "입력하기")
        }
        Text(text = "결과값 테스트 : $textState2")
    }
}













@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackTextField1Theme {
        TestTextField2()
    }
}