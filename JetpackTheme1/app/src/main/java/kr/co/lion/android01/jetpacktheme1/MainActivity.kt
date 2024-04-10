package kr.co.lion.android01.jetpacktheme1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.co.lion.android01.jetpacktheme1.ui.theme.JetpackTheme1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThemeTest1()
        }
    }
}

@Composable
fun ThemeTest1(){
    JetpackTheme1Theme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Text(text = "Hello")
            //dksus
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThemeTest1()
}