package kr.co.lion.android01.coupangbannerjet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kr.co.lion.android01.coupangbannerjet.ui.theme.CoupangBannerJetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoupangBannerJetTheme {
                // A surface container using the 'background' color from the theme
                PracticeBanner()
            }
        }
    }
}

@Composable
fun PracticeBanner(){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        val scroll = rememberScrollState()
        Column(
            modifier = Modifier.verticalScroll(scroll)
        ) {
            TopBanner()
            BodyIconButton()
            CenterBannerArea()
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopBanner(){

    val pageState = rememberPagerState()
    val pageCount = 5

    val textList = listOf(
        "광고 문구 1",
        "광고 문구 2",
        "광고 문구 3",
        "광고 문구 4",
        "광고 문구 5"
    )

    Box(
        modifier = Modifier.padding(top = 20.dp)
    ){
        HorizontalPager(
            count = pageCount,
            state = pageState,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Gray)
        ) {
            Text(
                text = textList[it],
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }

        HorizontalPagerIndicator(
            pagerState = pageState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(15.dp)
        )

    }

}


@Composable
fun BodyIconButton(){

    val scroll = rememberScrollState()

    Row(
        modifier = Modifier
            .horizontalScroll(scroll)
            .padding(10.dp)
    ) {
        val textList = listOf(
            "아이템1",
            "아이템2",
            "아이템3",
            "아이템4",
            "아이템5",
            "아이템6",
            "아이템7",
            "아이템8",
            "아이템9",
            "아이템10",
        )

        val iconList = listOf(
            Icons.Default.Add,
            Icons.Default.Face,
            Icons.Default.Favorite,
            Icons.Default.Warning,
            Icons.Default.Home,
            Icons.Default.Search,
            Icons.Default.Edit,
            Icons.Default.Delete,
            Icons.Default.AccountCircle,
            Icons.Default.Lock,
        )

        textList.forEachIndexed { index, text ->

            Column(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .width(100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = iconList[index % iconList.size],
                    contentDescription = null
                )

                Text(text = text)
                
                Spacer(modifier = Modifier.padding(20.dp))

                Icon(
                    imageVector = iconList[index % iconList.size],
                    contentDescription = null
                )

                Text(text = text)
            }
        }



    }

}


@Composable
fun CenterBannerArea(){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(800.dp)
            .padding(20.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "베너 영역",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoupangBannerJetTheme {
       PracticeBanner()
    }
}