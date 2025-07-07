package com.example.practiceproject

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.math.exp

@Composable
fun TellUsPage(
    navController: NavController
) {
    var gender by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedAgeRange by remember { mutableStateOf("Age Range") }

    val ageRanges = listOf("18-24", "25-34", "35-44", "45+")

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp,end = 20.dp, top = 150.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Tell us About yourself",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Who do you shop for?",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            GenderButton("Men", gender == "Men") { gender = "Men" }
            GenderButton("Women", gender == "Women") { gender = "Women" }
        }
        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "How Old are you ?", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(12.dp))

        Box {
            OutlinedButton(
                onClick = { expanded = true },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black, containerColor = Color(0xFFF1F1F1)),
                border = BorderStroke(0.dp, Color.Transparent)
            ) {
                Text(selectedAgeRange)
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.ArrowDropDown, contentDescription = null)
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                ageRanges.forEach { age ->
                    DropdownMenuItem(
                        onClick = {
                            selectedAgeRange = age
                            expanded = false
                        },
                        text = { Text(age) }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(300.dp))

        Button(
            onClick = {navController.navigate("home")},
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB47CFF)),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(text = "Finish", color = Color.White)
        }
    }
}

@Composable
fun GenderButton(
    label: String, selected: Boolean, onClick: () -> Unit
) {
    val backgroundColor = if (selected) Color(0xFF8e6cef) else Color(0xFFF1F1F1)
    val textColor = if (selected) Color.White else Color.Black

    Box(
        modifier = Modifier.width(120.dp).height(50.dp)
            .clip(RoundedCornerShape(50))
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Text(
            text = label,
            color = textColor,
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TellUsPagePreview() {
//    TellUsPage()
}