package com.example.matchinggame.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matchinggame.data.MemoryCard

@Composable
fun MemoryCardView(
    card: MemoryCard, width: Dp, height: Dp, onCardClick: () -> Unit
) {
    val isFront = card.isFaceUp || card.isMatched
    val gradient = Brush.verticalGradient(
        colors = if(isFront) {
            listOf(Color(0xFF424242),
                Color(0xFF121212))
        }
        else{
            listOf(Color(0xFF418FCC),
                Color(0xFF2B388C)
            )
        }
    )
    Box(
        modifier = Modifier
            .size(width * 0.85f, height * 0.85f)
            .clip(RoundedCornerShape(12.dp))
            .background(brush = gradient)
            .clickable(enabled = !card.isFaceUp && !card.isMatched) {onCardClick()},
        contentAlignment = Alignment.Center
    ) {
        if(isFront) {
            Text(text = card.emoji, color = Color.White, fontSize = 25.sp)
        } else {
            Text(text = "❓", color = Color.White.copy(alpha = 0.5f), fontSize = 20.sp)
        }
    }
}
