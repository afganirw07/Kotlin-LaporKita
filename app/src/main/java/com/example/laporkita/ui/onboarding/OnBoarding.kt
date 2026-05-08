package com.example.laporkita.ui.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laporkita.R
import com.example.laporkita.ui.onboarding.ui.theme.LaporKitaTheme

class OnBoardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaporKitaTheme {
                OnBoardingScreen()
            }
        }
    }
}


val Roboto = FontFamily(
    Font(R.font.roboto_regular)
)


@Composable
fun OnBoardingScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Header()

        Content(
            modifier = Modifier.align(Alignment.Center)
        )
    }
}


@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(120.dp)
        )

        TextButton(onClick = { println("Hello World") }) {
            Text(
                text = "Lewati",
                fontFamily = Roboto,
                fontSize = 14.sp,
                color = Color(0xFF6B7280)
            )
        }
    }
}


@Composable
fun Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.boarding1),
            contentDescription = "Onboarding Image",
            modifier = Modifier.size(320.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        TitleText()
        DescriptionText()

        Spacer(modifier = Modifier.height(32.dp))

        DotsIndicator(
            totalDots = 3,
            selectedIndex = 0
        )

        Spacer(modifier = Modifier.height(32.dp))

        NextButton()
    }
}


@Composable
fun TitleText() {
    Text(
        text = "Laporkan Masalah\nDengan Mudah",
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 38.sp,
        fontFamily = Roboto,
        textAlign = TextAlign.Center,
        color = Color(0xFF111827)
    )
}

@Composable
fun DescriptionText() {
    Text(
        text = "Kirim laporan hanya dalam beberapa langkah, tanpa proses yang rumit.",
        fontSize = 15.sp,
        lineHeight = 22.sp,
        fontFamily = Roboto,
        textAlign = TextAlign.Center,
        color = Color(0xFF6B7280),
        modifier = Modifier.padding(top = 12.dp)
    )
}


@Composable
fun NextButton() {
    Button(
        onClick = { /* TODO */ },
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFEF4444)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Selanjutnya",
                fontFamily = Roboto,
                fontSize = 15.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Next",
                tint = Color.White
            )
        }
    }
}


@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(totalDots) { index ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(if (index == selectedIndex) 12.dp else 8.dp)
                    .background(
                        color = if (index == selectedIndex)
                            Color(0xFFEF4444)
                        else
                            Color(0xFFD1D5DB),
                        shape = CircleShape
                    )
            )
        }
    }
}