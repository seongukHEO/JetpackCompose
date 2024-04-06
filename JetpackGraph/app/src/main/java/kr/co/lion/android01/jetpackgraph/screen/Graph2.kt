package kr.co.lion.android01.jetpackgraph.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.lion.android01.jetpackgraph.ui.theme.JetpackGraphTheme


@Composable
fun Graph2() {

    Graph2Pie()

}


@Composable
fun Graph2Pie(){

    val pieSize1 = 25f
    val pieSize2 = 75f
    PieChart(pieSize1 = pieSize1, pieSize2 = pieSize2)

}

@Composable
fun PieChart(
    pieSize1:Float,
    pieSize2:Float
){

    //전체 너비를 구한다
    val totalSize = pieSize1 + pieSize2

    //Box의 가로너비와 세로너비를 가져올 수 있음
    BoxWithConstraints(
        modifier = Modifier.padding(20.dp)
    ) {

        //이런식으로 너비를 가져올 수 있다
        val pieDetailSize = constraints.maxWidth.toFloat()

        Canvas(modifier = Modifier.size(pieDetailSize.dp)){

            val sweep1 = 360 * (pieSize1 / totalSize)

            drawArc(
                color = Color.Red,
                startAngle = 0f,
                sweepAngle = sweep1,
                useCenter = true,
                size = Size(pieDetailSize, pieDetailSize)
            )

            val sweep2 = 360 * (pieSize2 / totalSize)

            drawArc(
                color = Color.Blue,
                startAngle = sweep1,
                sweepAngle = sweep2,
                useCenter = true,
                size = Size(pieDetailSize, pieDetailSize)
            )
        }

    }

}


@Preview(showBackground = true)
@Composable
fun Graph2Preview() {
    JetpackGraphTheme {
        Graph2()
    }
}