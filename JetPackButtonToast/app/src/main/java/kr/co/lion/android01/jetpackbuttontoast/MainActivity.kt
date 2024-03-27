package kr.co.lion.android01.jetpackbuttontoast

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.lion.android01.jetpackbuttontoast.ui.theme.JetPackButtonToastTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackButtonToastTheme {
                // A surface container using the 'background' color from the theme
                MyBtn()
            }
        }
    }
}

@Composable
fun MyBtn(){
    val context = LocalContext.current
    Button(onClick = {
                     Toast.makeText(context, "클릭완료", Toast.LENGTH_SHORT).show()

    },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.Black
        ),
        modifier = Modifier
            .width(200.dp)
            .height(300.dp)
        ) {
        Text(
            text = "버튼버튼버튼버튼버튼버튼버튼 버튼입니다",
            lineHeight = 50.sp,
            fontSize = 20.sp,
            color = Color.Yellow
        )
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackButtonToastTheme {
        MyBtn()
    }
}