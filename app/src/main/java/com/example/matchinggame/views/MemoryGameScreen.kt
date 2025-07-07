package com.example.matchinggame.views

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matchinggame.data.MemoryCard
import kotlinx.coroutines.delay

@SuppressLint("ContextCastToActivity", "UnusedBoxWithConstraintsScope")
@Composable
fun MemoryGameScreen() {
    val emojis = listOf("😊", "🎮", "🌟", "🔥", "💖", "🍀", "🐱", "🌈", "🚀")
    val context = LocalContext.current as? Activity
    
    var cards by remember { mutableStateOf(listOf<MemoryCard>()) }
    var selectedIndices by remember { mutableStateOf(listOf<Int>()) }
    var score by remember { mutableStateOf(0) }
    var highScore by remember { mutableStateOf(0) }
    var timeLeft by remember { mutableStateOf(60) }
    var isRunning by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var gameStarted by remember { mutableStateOf(false) }

    // game time logic
    LaunchedEffect(isRunning) {
        if(isRunning) {
            while (timeLeft > 0) {
                delay(1000) // time is getting decreased
                timeLeft -= 1
            }
            isRunning = false
            cards = cards.map { it.copy(isFaceUp = false, isMatched = false) }
            if(score > highScore) {
                highScore = score
            }
            showDialog = true
        }
    }
    // FlipLogic
    LaunchedEffect(selectedIndices) {
        if (selectedIndices.size == 2) {
            delay(600)
            val firstCard = cards[selectedIndices[0]]
            val secondCard = cards[selectedIndices[1]]

            cards = cards.map {
                when(it.id) {
                    firstCard.id, secondCard.id -> {
                        if(firstCard.emoji == secondCard.emoji && firstCard.id != secondCard.id) {
                            score += 1
                            it.copy(isMatched = true)
                        } else {
                            it.copy(isFaceUp = false)
                        }
                    }

                    else -> it
                }
            }
            selectedIndices = listOf()
        }
    }
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
            .background(color = Color(0xFF121212))
            .padding(12.dp)
    ) {
        val cardWidth = maxWidth / 3
        val cardHeight = maxHeight / 6

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            if(gameStarted) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier.padding(end = 12.dp)
                            .wrapContentWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF1E88E5)
                        )
                    ) {
                        Text(
                            text = "$timeLeft",
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    LinearProgressIndicator(
                        progress = timeLeft / 60f,
                        modifier = Modifier.weight(1f).height(10.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        color = Color.Cyan,
                        trackColor = Color.DarkGray
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            // game grid
            if (gameStarted) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    userScrollEnabled = false,
                    modifier = Modifier.weight(1f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    items(cards.size) { index ->
                        MemoryCardView(
                            card = cards[index],
                            width = cardWidth,
                            height = cardHeight,
                            onCardClick =  {
                                if (!cards[index].isFaceUp && !cards[index].isMatched && selectedIndices.size < 2) {
                                    cards = cards.map {
                                        if (it.id == cards[index].id) {
                                            it.copy(isFaceUp = true)
                                        } else it
                                    }
                                    selectedIndices = selectedIndices + index
                                }
                            }
                        )
                    }
                }
            }
            //start button
            if(!gameStarted) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Card(
                        onClick = {
                            cards = (emojis + emojis)
                                .shuffled().mapIndexed{ index, emoji -> MemoryCard(index, emoji) }
                            selectedIndices = listOf()
                            score = 0
                            timeLeft = 60
                            isRunning = true
                            showDialog = false
                            gameStarted = true
                        },
                        colors = CardDefaults.cardColors(
                            contentColor = Color.White,
                            containerColor = Color(0xFF1E88E5),
                            disabledContainerColor = Color(0xFF1E88E5),
                            disabledContentColor = Color.White
                        ),
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(0.7f)
                            .height(120.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .clickable{}
                    ) {
                        Box (
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(
                                text = "Start Game",
                                fontSize = 22.sp,
                                color = Color.White,
                            )
                        }
                    }
                }
            }
        }
        if(showDialog) {
            AlertDialog(
                onDismissRequest = {},
                confirmButton = {
                    TextButton(onClick = {
                        cards = (emojis + emojis)
                            .shuffled().mapIndexed{ index, emoji -> MemoryCard(index, emoji) }
                        selectedIndices = listOf()
                        score = 0
                        timeLeft = 60
                        isRunning = true
                        showDialog = false
                    }) {
                        Text(text = "Play Again")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { context?.finish()}) {
                        Text(text = "Exit")
                    }
                },
                title = { Text(text = "Game Over") },
                text = {
                    Text(
                        text = "Your Score: $score High Score: $highScore",
                        color = Color.White
                    )
                },
                containerColor = Color(0xFF2C2C2C)
            )
        }
    }
}