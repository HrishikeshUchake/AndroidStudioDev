package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainGameTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }
}


@Composable
fun CaptainGame() {
    var treasureFound by remember { mutableStateOf(0) }
    val direction = remember { mutableStateOf("North") }
    val StormOrTreasure = remember { mutableStateOf("") }

    Column {
        Text(text = "Captain game")
        Text(text = "Treasure found: ${treasureFound}")
        Text(text = "Direction: ${direction.value}")
        Text(text = "Storm or Treasure: ${StormOrTreasure.value}")
        Button(onClick = {
            direction.value = "East"
            if(Random.nextBoolean()){
                StormOrTreasure.value = "Treasure"
                treasureFound += 1
            }
            else{
                StormOrTreasure.value = "Storm"
            }
        }) {
            Text(text = "Sail East")

        }
    }
}
@Preview(showBackground = true)
@Composable
fun CaptainGamePreview() {
    CaptainGameTheme {
        CaptainGame()
    }
}