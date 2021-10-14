package com.greedy0110.croops

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greedy0110.croops.ui.theme.*

val Blue599 = Color(0xff599CEE)
val Blue059 = Color(0x7f05196E)

@Composable
fun MyScoreCard(
    gaugeUnits: List<GaugeUnit> = listOf(GaugeUnit(1f, Color.Red)),
) {
    Surface(
        color = Color.White,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.fillMaxWidth(0.5f),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 20.dp,
                bottom = 14.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "내 점수",
                    style = MaterialTheme.typography.subtitle1,
                    color = Grey2C
                )
                Icon(painter = painterResource(id = R.drawable.ic_arrow), contentDescription = null)
            }

            CircleGauge(
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 20.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f),
                gaugeUnits = gaugeUnits
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(SpanStyle(fontSize = 24.sp)) {
                                append("60")
                            }
                            withStyle(SpanStyle(fontSize = 14.sp)) {
                                append("점")
                            }
                        },
                        style = MaterialTheme.typography.h3,
                        color = Blue0519
                    )
                    Text(
                        text = "\uD83C\uDF31새싹 농부",
                        style = MaterialTheme.typography.caption,
                        fontWeight = FontWeight.SemiBold,
                        color = Grey5
                    )
                }
            }

            Row {
                val names = listOf("상추", "지토", "무화과")
                val colors = listOf(
                    Color(0xff1FCEA0),
                    Color(0xff599CEE),
                    Color(0xffFADF4B)
                )
                for (i in names.indices) {
                    val name = names[i]
                    TextWithDot(text = name, color = colors[i])
                    if (i != names.lastIndex) Spacer(modifier = Modifier.size(8.dp))
                }
            }
        }
    }
}

@Composable
fun TextWithDot(modifier: Modifier = Modifier, text: String, color: Color) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val circleRadius = 3.dp
        Canvas(modifier = Modifier.size(circleRadius * 2)) {
            val radius = size.minDimension / 2
            drawCircle(
                color = color,
                radius = radius,
            )
        }
        Spacer(modifier = Modifier.size(3.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.caption,
            color = Grey4,
            letterSpacing = 0.sp
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun PreviewTextWithDot() {
    CroopsTheme {
        TextWithDot(text = "상추", color = Color(0xffFADF4B))
    }
}

//@Preview(showBackground = true)
@Composable
fun PreviewMyScoreCard() {
    val gaugeUnits = listOf(
        GaugeUnit(0.14f, Color(0xffFADF4B)),
        GaugeUnit(0.4f, Color(0xffE8E8E8)),
        GaugeUnit(0.15f, Color(0xff1FCEA0)),
        GaugeUnit(0.31f, Color(0xff599CEE)),
    )

    CroopsTheme {
        Box(modifier = Modifier.size(300.dp), contentAlignment = Alignment.Center) {
            MyScoreCard(gaugeUnits = gaugeUnits)
        }
    }
}

data class CroopData(
    val nickName: String,
    val kindName: String,
    val days: Int,
    val temperature: Float,
    val humidity: Int,
    val color: Color,
    val accentColor: Color
)

@Composable
fun CroopCard(modifier: Modifier = Modifier, croopData: CroopData) {
    val nickName = croopData.nickName
    val kindName = croopData.kindName
    val days = croopData.days
    val temperature = croopData.temperature
    val humidity = croopData.humidity
    val color = croopData.color
    val accentColor = croopData.accentColor

    val titles = listOf("기온", "습도")
    val contents = listOf("$temperature℃", "$humidity%")

    Surface(
        color = color,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier,
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(top = 24.dp, bottom = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp, end = 16.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        text = nickName,
                        fontSize = 22.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = kindName,
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.7f)
                    )
                }

                Surface(
                    modifier = Modifier.padding(top = 4.dp),
                    shape = RoundedCornerShape(9.dp),
                    color = accentColor
                ) {
                    Text(
                        modifier = Modifier.padding(
                            start = 8.dp,
                            end = 8.dp,
                            top = 2.dp,
                            bottom = 2.dp
                        ),
                        text = "D+$days",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }

            for (i in titles.indices) {
                Divider(
                    Modifier.padding(start = 9.dp, end = 9.dp, bottom = 7.dp),
                    color = GreyE8,
                    thickness = 0.5.dp
                )
                Row(modifier = Modifier.padding(start = 22.dp, end = 22.dp, bottom = 3.dp)) {
                    ProvideTextStyle(
                        value = TextStyle(
                            color = GreyE8,
                            fontSize = 12.sp
                        )
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = titles[i],
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = contents[i],
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCroopCard() {

    val croop1 = CroopData(
        nickName = "지토",
        kindName = "토마토",
        days = 180,
        temperature = 22.6f,
        humidity = 67,
        color = Blue599,
        accentColor = Blue059
    )

    val croop2 = CroopData(
        nickName = "상추",
        kindName = "청상추",
        days = 24,
        temperature = 25f,
        humidity = 75,
        color = Color(0xff1FCEA0),
        accentColor = Color(0xff34B492)
    )


    CroopsTheme {
        Row(modifier = Modifier.size(300.dp)) {
            CroopCard(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .aspectRatio(0.7f)
                    .weight(1f),
                croopData = croop1
            )
            CroopCard(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .aspectRatio(0.7f)
                    .weight(1f),
                croopData = croop2
            )
        }
    }
}