package com.greedy0110.croops

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.greedy0110.croops.ui.theme.CroopsTheme

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
                Text(text = "내 점수", modifier = Modifier.weight(1f))
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
                        .align(Alignment.Center)
                ) {
                    Text(text = "60점")
                    Text(text = "\uD83C\uDF31새싹 농부")
                }
            }

            Row {
                Text(text = "상추", modifier = Modifier.weight(1f))
                Text(text = "지토", modifier = Modifier.weight(1f))
                Text(text = "무화과", modifier = Modifier.weight(1f))
            }
        }
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