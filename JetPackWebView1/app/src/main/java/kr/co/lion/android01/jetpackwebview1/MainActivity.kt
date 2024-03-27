package kr.co.lion.android01.jetpackwebview1

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import kr.co.lion.android01.jetpackwebview1.ui.theme.JetPackWebView1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackWebView1Theme {
                MyWebView("https://github.com/seongukHEO")

            }
        }
    }
}

@Composable
fun MyWebView(url:String){

    AndroidView(factory = {
        WebView(it).apply {
            loadUrl(url)
        }
    })
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackWebView1Theme {
        MyWebView("https://github.com/seongukHEO")

    }
}