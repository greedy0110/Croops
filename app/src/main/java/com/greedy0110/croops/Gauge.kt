package com.greedy0110.croops

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class GaugeUnit(
    val proportion: Float,
    val color: Color
)

@Composable
fun CircleGauge(
    modifier: Modifier = Modifier,
    gaugeUnits: List<GaugeUnit> = listOf(GaugeUnit(1f, Color.Red)),
    strokeWidth: Dp = 15f.dp,
    content: @Composable BoxScope.() -> Unit = {}
) {
    val stroke = with(LocalDensity.current) { Stroke(strokeWidth.toPx()) }
    Box(modifier = modifier) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val innerRadius = (size.minDimension - stroke.width) / 2
            val halfSize = size / 2.0f
            val topLeft = Offset(
                halfSize.width - innerRadius,
                halfSize.height - innerRadius
            )

            var startAngle = -90f
            gaugeUnits.map { (proportion, color) ->
                val sweepAngle = proportion * 360f
                drawArc(
                    color = color,
                    startAngle = startAngle,
                    sweepAngle = sweepAngle + 1f,
                    size = Size(innerRadius * 2, innerRadius * 2),
                    topLeft = topLeft,
                    useCenter = false,
                    style = stroke
                )
                startAngle += sweepAngle
            }
        }
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCircleGauge() {
    val gaugeUnits = listOf(
        GaugeUnit(0.14f, Color(0xffFADF4B)),
        GaugeUnit(0.4f, Color(0xffE8E8E8)),
        GaugeUnit(0.15f, Color(0xff1FCEA0)),
        GaugeUnit(0.31f, Color(0xff599CEE)),
    )

    CircleGauge(modifier = Modifier.size(130.dp, 130.dp), gaugeUnits = gaugeUnits)
}

