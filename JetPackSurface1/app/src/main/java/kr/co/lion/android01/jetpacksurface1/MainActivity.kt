package kr.co.lion.android01.jetpacksurface1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.lion.android01.jetpacksurface1.ui.theme.JetPackSurface1Theme

//Surface : 컨텐츠를 담아 놓는 컨테이너
//컨텐츠 : 버튼, 텍스트, 박스 등등

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackSurface1Theme {
                MySurface2()
            }
        }
    }
}


@Composable
fun MySurface1(){

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        color = Color.Green,
        shape = RoundedCornerShape(20.dp),
        shadowElevation = 20.dp
    ) {
        Button(
            onClick = {},
            //Surface의 색상과 어울리게 만들어짐
            colors = ButtonDefaults.outlinedButtonColors(
                //이건 버튼의 컬러
                contentColor = Color.Red
            )

        ) {
            Text(
                text = "클릭해보세요"
            )
        }
    }
}


@Composable
fun MySurface2(){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray,
        border = BorderStroke(2.dp, color = Color.Red),
        //이건 만들어진 content에 대한 컬러
        contentColor = Color.Blue
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.size(200.dp),
                color = Color.Red,

            ) {
                Text(
                    text = "이건 컴포즈"
                )

            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "이건 컴포즈 예시"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackSurface1Theme {
        MySurface2()
    }
}