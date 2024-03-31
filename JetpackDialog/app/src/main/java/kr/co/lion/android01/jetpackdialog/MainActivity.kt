package kr.co.lion.android01.jetpackdialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kr.co.lion.android01.jetpackdialog.ui.theme.JetpackDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackDialogTheme {
                MyDialog()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDialog(){
    
    //기본적으로 dialog는 false 상태에 있다
    var dialogFlag by remember {
        mutableStateOf(false)
    }

    var textState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { dialogFlag = true }) {
            Text(text = "나와라 ~~!")
        }
        
        if (dialogFlag){
            AlertDialog(
                onDismissRequest = { /*TODO*/ },
                title = { Text(text = "Dialog Title")},
                text = {
                       TextField(value = textState, onValueChange = {textState = it})
                },
                confirmButton = {
                    Button(
                        onClick = { dialogFlag = false},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Blue
                        )
                    ) {
                        Text(text = "OK")
                    }
                },
                dismissButton = {
                    Button(onClick = {  dialogFlag = false }) {
                        Text(text = "NO")
                    }
                }
            ) 
            
        }
        //이거야
        if (textState.isNotEmpty()){
            Text(text = "입력된 텍스트 : $textState")
        }
    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackDialogTheme {
        MyDialog()
    }
}