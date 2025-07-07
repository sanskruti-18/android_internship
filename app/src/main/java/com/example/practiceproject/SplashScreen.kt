package com.example.practiceproject

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("screen1") {
            popUpTo("splash") { inclusive = true }
        }
    }
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background((Color(0xFF8e6cef)))
    ) {
        Text(
            text = "Clot",
            style = TextStyle(
                fontSize = 70.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 8.sp,
                color = Color.White
            ),
            modifier = Modifier.align((Alignment.Center))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
//    SplashScreen()
}