package kr.co.lion.android01.jetpacktext1

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
import kr.co.lion.android01.jetpacktext1.ui.theme.JetpackText1Theme


//button과 Toast

class ButtonActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackText1Theme {
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
            containerColor = Color.Yellow,
            contentColor = Color.Black
        ),
        modifier = Modifier
            .width(200.dp)
            .height(300.dp)
            ) {
        Text(
            text = "버튼버튼버튼버튼버버튼 버튼입니다",
            lineHeight = 50.sp,
            fontSize = 30.sp,
            color = Color.Red

        )

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    JetpackText1Theme {
        MyBtn()
    }
}