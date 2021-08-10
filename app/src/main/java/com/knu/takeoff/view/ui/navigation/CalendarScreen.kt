package com.knu.takeoff.view.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun CalendarScreen(name: String) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        TopAppBar(
            title = { Text(text = name, fontSize = 18.sp) },
            backgroundColor = Color.White,
            contentColor = Color.Black
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .wrapContentSize(Alignment.Center) ){
            Text(text = "CalendarScreen", textAlign = TextAlign.Center)
        }
    }

}

@Preview
@Composable
fun CalendarScreenPreview() {
    CalendarScreen("Calendar")
}