package kr.co.lion.android01.jetpackshowhide1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.lion.android01.jetpackshowhide1.ui.theme.JetPackShowHide1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackShowHide1Theme {
                MyShowHideEX2()
            }
        }
    }
}

//버튼을 클릭하면 새로운 버튼이 나온다
@Composable
fun MyShowHideEX(){

    var isButtonVisible by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            isButtonVisible = !isButtonVisible
        }) {
            if (isButtonVisible == true){
                Text(
                    text = "숨기기",
                    fontSize = 50.sp,
                )
            }else{
                Text(
                    text = "보이기",
                    fontSize = 50.sp
                )
            }
        }
        Spacer(modifier = Modifier.size(30.dp))
        
        if (isButtonVisible == true){
            Button(onClick = {
                
            }) {
                Text(
                    text = "짠짠짠",
                    fontSize = 50.sp
                )

            }
        }
    }
}


@Composable
fun MyShowHideEX2(){

    var switchState by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.padding(30.dp)
    ) {
        Switch(
            checked = switchState,
            onCheckedChange = {
                switchState = it
            }
        )

        Text(
            text = if (switchState) "ON" else "Off",
            fontSize = 50.sp
        )

        if (switchState == true){
            Text(text = "얍얍", fontSize = 20.sp)
        }

    }

}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackShowHide1Theme {
      MyShowHideEX2()
    }
}