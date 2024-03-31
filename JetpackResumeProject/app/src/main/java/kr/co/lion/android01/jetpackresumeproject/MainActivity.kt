package kr.co.lion.android01.jetpackresumeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kr.co.lion.android01.jetpackresumeproject.ui.theme.JetpackResumeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackResumeProjectTheme {
                MyResume()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyResume(){

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "허성욱 이력서") }

            )
        }
    ) {paddingValues ->
        MyResumeContent(paddingValues)
    }
}

@Composable
fun MyResumeContent(paddingValues: PaddingValues) {

}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackResumeProjectTheme {
        MyResume()
    }
}