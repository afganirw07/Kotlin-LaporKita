package com.example.laporkita.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.laporkita.ui.theme.LaporKitaTheme
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaporKitaTheme {
                Greeting()
                }
            }
        }
    }

@Composable
fun Greeting() {
    Text(
        "Afgan Irwansyah Hidayat",
        modifier = Modifier.fillMaxSize()
            .wrapContentSize(),
        fontSize = 30.sp
    )
}

