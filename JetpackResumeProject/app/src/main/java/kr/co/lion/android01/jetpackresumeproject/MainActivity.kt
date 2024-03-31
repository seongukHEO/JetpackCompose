package kr.co.lion.android01.jetpackresumeproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    var context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.my_face),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(shape = RoundedCornerShape(30.dp))
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "자기소개",
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )


            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "안녕하세요 안드로이드 개발자 허성욱입니다.\n저는 Kotlin을 사용하여 개발을 하며 항상 더 나은 코드를 만들기 위해 노력합니다\n또한 UI에 관심이 많아 사람들의 관심을 끌만한 UI를 만들어 적용시킵니다 ",
                fontSize = 15.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = Color.Gray, thickness = 1.dp)
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "핸드폰 번호 : 010-7182-0864",
                modifier = Modifier.padding(10.dp)
            )


            Text(
                text = "이메일 : heoseonguk3@gmail.com",
                modifier = Modifier.padding(10.dp)
            )

            Button(onClick = {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:01071820864"))
                context.startActivity(intent)
            },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "전화 걸기")
            }

            Button(onClick = {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:heoseonguk3@gmail.com")
                }
                context.startActivity(intent)
            },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "메일 발송")
            }
        }
    }

}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackResumeProjectTheme {
        MyResume()
    }
}