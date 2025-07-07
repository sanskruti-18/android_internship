package com.example.practiceproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp as dp

@Composable
fun SignInEmail(
    onContinueClick: (String) -> Unit = {},
    onCreateAccountClick: () -> Unit = {},
    onAppleClick: () -> Unit = {},
    onGoogleClick: () -> Unit = {},
    onFacebookClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf(TextFieldValue("")) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 20.dp, vertical = 100.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Sign In",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Address") },
            colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color(0xFFE7E5E5)),
            modifier = Modifier.padding(bottom = 20.dp).width(400.dp)
        )

        Button(
            onClick = {onContinueClick(email.text)},
            modifier = Modifier.width(390.dp)
                .height(45.dp), shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8e6cef))
        ) {
            Text("Continue",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        Row (
            modifier = Modifier
//                .fillMaxSize()
                .padding(top = 10.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Don't have an Account?",
                fontSize = 14.sp
            )
            Text(
                text = "Create One",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.clickable{ onCreateAccountClick() }
            )
        }
        Spacer(modifier = Modifier.height(60.dp))

        SocialLoginButton(
            icon = R.drawable.ic_apple,
            text = "Continue with Apple",
            onClick = onAppleClick
        )
        Spacer(modifier = Modifier.height(8.dp))

        SocialLoginButton(
            icon = R.drawable.ic_google,
            text = "Continue With Google",
            onClick = onGoogleClick
        )

        Spacer(modifier = Modifier.height(8.dp))

        SocialLoginButton(
            icon = R.drawable.ic_facebook,
            text = "Continue With Facebook",
            onClick = onFacebookClick
        )
    }
}

@Composable
fun SocialLoginButton(
    @DrawableRes icon: Int,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .width(40.dp).height(48.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFf4f4f4))
    ) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Image(painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = text,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    SignInEmail()
}