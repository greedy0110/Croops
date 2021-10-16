package com.greedy0110.croops

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.greedy0110.croops.ui.theme.CroopTheme
import com.greedy0110.croops.ui.theme.CroopsTheme
import com.greedy0110.croops.ui.theme.Grey97
import com.greedy0110.croops.ui.theme.GreyE8

@Composable
fun HomeScreen(content: @Composable () -> Unit) {
    Scaffold(
        topBar = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(end = 24.dp)
                        .size(36.dp)
                        .clip(CircleShape)
                        .border(width = 1.dp, color = GreyE8, shape = CircleShape),
                    painter = painterResource(id = R.drawable.lena),
                    contentDescription = null
                )
            }
        }
    ) { innerPadding ->
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 24.dp, end = 45.dp)
                    .align(Alignment.End),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("오늘은\n")
                        withStyle(SpanStyle(fontWeight = FontWeight.Medium)) {
                            append("토마토")
                        }
                        append("를\n")
                        append("수확해 볼까요?")
                    },
                    style = CroopTheme.typography.header
                )
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                ) {
                    Icon(
                        modifier = Modifier.padding(end = 4.dp),
                        painter = painterResource(id = R.drawable.ic_icon_list_location_here),
                        contentDescription = null,
                        tint = Blue599
                    )
                    Text(
                        text = "서울, 티케하우스",
                        style = CroopTheme.typography.body2,
                        color = Grey97
                    )
                }
            }
            content()
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    CroopsTheme {
        HomeScreen {
            PreviewCroopsList()
        }
    }
}