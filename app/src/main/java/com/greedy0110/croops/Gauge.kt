package com.greedy0110.croops

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CircleGauge() {

    val proportions = listOf(0.14f, 0.4f, 0.15f, 0.31f)
    val colors = listOf(
        Color(0xffFADF4B),
        Color(0xffE8E8E8),
        Color(0xff1FCEA0),
        Color(0xff599CEE),
    )

    val strokeWidth = 15f
    val stroke =
        with(LocalDensity.current) { Stroke(strokeWidth.dp.toPx(), cap = StrokeCap.Butt) }
    Canvas(Modifier.fillMaxSize()) {
        val innerRadius = (size.minDimension - stroke.width) / 2
        val halfSize = size / 2.0f
        val topLeft = Offset(
            halfSize.width - innerRadius,
            halfSize.height - innerRadius
        )

        var startAngle = -90f
        proportions.mapIndexed { index, proportion ->
            val sweepAngle = proportion * 360f
            drawArc(
                color = colors[index],
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
}

@Preview
@Composable
fun PreviewCircleGauge() {
    Box(Modifier.size(130.dp, 130.dp)) {
        CircleGauge()
    }
}

