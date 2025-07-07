package com.example.practiceproject

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun EmailToReset(
    navController: NavHostController,
    onReturnToLoginClick: () -> Unit = {}
) {
   Column (
       modifier = Modifier
           .fillMaxSize()
           .background(Color.White),
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center
   ) {
       Image(painter = painterResource(id = R.drawable.ic_mail),
           contentDescription = null,
           modifier = Modifier.size(120.dp)
       )

       Spacer(modifier = Modifier.height(15.dp))

       Text(
           text = "We Sent you an Email to reset your password",
           style = TextStyle(
               fontSize = 25.sp,
               fontWeight = FontWeight.Bold,
               textAlign = TextAlign.Center
               )
       )

       Spacer(modifier = Modifier.height(15.dp))

       Button(
           onClick = { navController.navigate("screen2") },
           modifier = Modifier.height(45.dp),
           shape = RoundedCornerShape(20.dp),
           colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8e6cef))
       ) {
           Text(
               text = "Return To Login",
               color = Color.White,
               fontWeight = FontWeight.Bold,
               fontSize = 16.sp
           )
       }
   }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview5() {
//    EmailToReset()
}