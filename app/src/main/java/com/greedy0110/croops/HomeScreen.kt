package com.greedy0110.croops

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greedy0110.croops.ui.theme.*

@Composable
fun MyScoreCard(
    gaugeUnits: List<GaugeUnit> = listOf(GaugeUnit(1f, Color.Red)),
) {
    Surface(
        color = Color.White,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.size(164.dp, 234.dp)
    ) {
        Column(
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 20.dp,
                bottom = 14.dp
            )
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "내 점수",
                    style = MaterialTheme.typography.subtitle1,
                    color = Grey2C
                )
                Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null)
            }

            CircleGauge(
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 20.dp)
                    .size(130.dp, 130.dp),
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
                        color = Grey5
                    )
                }
            }

            Row {
                TextWithDot(text = "상추", modifier = Modifier.weight(1f))
                TextWithDot(text = "지토", modifier = Modifier.weight(1f))
                TextWithDot(text = "무화과", modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun TextWithDot(modifier: Modifier = Modifier, text: String) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val circleRadius = 3.dp
        Canvas(modifier = Modifier.size(circleRadius * 2)) {
            val radius = size.minDimension / 2
            drawCircle(
                color = Color(0xff1FCEA0),
                radius = radius,
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.caption,
            color = Grey4,
            letterSpacing = 0.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreivewTextWithDot() {
    CroopsTheme {
        TextWithDot(text = "상추")
    }
}

@Preview
@Composable
fun PreviewMyScoreCard() {
    val gaugeUnits = listOf(
        GaugeUnit(0.14f, Color(0xffFADF4B)),
        GaugeUnit(0.4f, Color(0xffE8E8E8)),
        GaugeUnit(0.15f, Color(0xff1FCEA0)),
        GaugeUnit(0.31f, Color(0xff599CEE)),
    )

    CroopsTheme {
        MyScoreCard(gaugeUnits = gaugeUnits)
    }
}