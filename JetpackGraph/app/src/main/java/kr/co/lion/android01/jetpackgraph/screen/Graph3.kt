package kr.co.lion.android01.jetpackgraph.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.lion.android01.jetpackgraph.ui.theme.JetpackGraphTheme

@Composable
fun Graph3() {
    Grape3Bar()
}

@Composable
fun Grape3Bar(){

    val barDataList = listOf(10, 5, 8, 6, 1, 3, 4, 7)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 120.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BarChart(barDataList)
            Spacer(modifier = Modifier.height(100.dp))
            Text(
                text = "그래프",
                fontSize = 40.sp
            )
        }
    }
}

@Composable
fun BarChart(barDataList: List<Int>) {

    //높이의 기준점을 정해준다
    val maxDataValue = barDataList.max()

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        barDataList.forEach {
            Bar(it, maxDataValue)
        }
    }

}

@Composable
fun Bar(i: Int, maxDataValue: Int) {

    val height = (i.toFloat() / maxDataValue) * 300

    Box(
         modifier = Modifier
             .height(height.dp)
             .width(30.dp)
             .background(Color.Black),
        contentAlignment = Alignment.BottomCenter
    ) {

        Text(text = i.toString(), color = Color.White)
    }

}

@Preview(showBackground = true)
@Composable
fun Graph3Preview() {
    JetpackGraphTheme {
        Graph3()
    }
}