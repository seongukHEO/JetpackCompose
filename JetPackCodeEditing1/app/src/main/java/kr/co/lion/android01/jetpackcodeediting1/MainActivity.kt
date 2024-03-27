package kr.co.lion.android01.jetpackcodeediting1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import kr.co.lion.android01.jetpackcodeediting1.ui.theme.JetPackCodeEditing1Theme

//코드 재활용
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackCodeEditing1Theme {
                MyTextArea2()
            }
        }
    }
}

@Composable
fun MyTextAreal1(){

    Column() {
        Text(
            text = "안녕",
            fontSize = 100.sp,
            color = Color.Red
        )
        Text(
            text = "나는",
            fontSize = 100.sp,
            color = Color.Blue
        )
        Text(
            text = "허성욱이야",
            fontSize = 100.sp,
            color = Color.Green
        )
    }
}

@Composable
fun MyTextArea2(){

    Column() {
        MyTextFormat(text = "안녕", fontSize = 100.sp, color = Color.Red)
        MyTextFormat(text = "나는", fontSize = 100.sp, color = Color.Green)
        MyTextFormat(text = "누구야", fontSize = 100.sp, color = Color.Yellow)
    }

}


@Composable
fun MyTextFormat(text:String, fontSize:TextUnit, color:Color){
    Text(
        text = text,
        fontSize = fontSize,
        color = color
    )
}


@Composable
fun MyTextArea3(){
    MyTextFormat2{
        Text(text = "안녕", fontSize = 100.sp, color = Color.Red)
    }
}

@Composable
fun MyTextFormat2(content: @Composable () -> Unit){
    content()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackCodeEditing1Theme {
       MyTextArea2()
    }
}