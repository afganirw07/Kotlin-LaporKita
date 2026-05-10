package com.example.laporkita.ui.onboarding
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.animation.Crossfade
import androidx.compose.ui.unit.sp
import com.example.laporkita.R
import com.example.laporkita.ui.login.login
import com.example.laporkita.ui.onboarding.ui.theme.LaporKitaTheme
import androidx.compose.ui.platform.LocalContext

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

data class OnBoardingItem(
    val image: Int,
    val title: String,
    val description: String,
    val buttonText: String
)

val onboardingData = listOf(
    OnBoardingItem(
        R.drawable.boarding1,
        "Laporkan Masalah\nDengan Mudah",
        "Kirim laporan hanya dalam beberapa langkah, tanpa proses yang rumit.",
        "Selanjutnya"
    ),
    OnBoardingItem(
        R.drawable.boarding2,
        "Masuk untuk Akses\nPenuh",
        "Login untuk mengirim laporan, melacak progres, dan mendapatkan notifikasi secara real-time.",
        "Selanjutnya"
    ),
    OnBoardingItem(
        R.drawable.boarding3,
        "Pantau Progres Laporan\nSecara Real-Time",
        "Lihat status dan perkembangan laporanmu secara transparan dan real-time.",
        "Mulai Sekarang"
    )
)

@Composable
fun OnBoardingScreen() {
    var currentPage by remember { mutableStateOf(0) }
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Header(
            currentPage = currentPage,
            onSkipClick = {
                currentPage = onboardingData.lastIndex
            }
        )

        Crossfade(
            targetState = currentPage,
            modifier = Modifier.align(Alignment.Center)
        ) { page ->

            val item = onboardingData[page]

            Content(
                item = item,
                currentPage = page,
                onNextClick = {
                    if (page < onboardingData.lastIndex) {
                        currentPage++
                    } else {
                        val intent = Intent(context, login::class.java)
                        context.startActivity(intent)
                    }
                }
            )
        }
    }
}

@Composable
fun Header(
    currentPage: Int,
    onSkipClick: () -> Unit
) {
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

       if (currentPage != onboardingData.lastIndex){
           TextButton(onClick = onSkipClick) {
               Text(
                   text = "Lewati",
                   fontFamily = Roboto,
                   fontSize = 14.sp,
                   color = Color(0xFF6B7280)
               )
           }
       }
    }
}

@Composable
fun Content(
    item: OnBoardingItem,
    currentPage: Int,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = item.image),
            contentDescription = null,
            modifier = Modifier.size(400.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        TitleText(item.title)
        DescriptionText(item.description)

        Spacer(modifier = Modifier.height(80.dp))

        DotsIndicator(
            totalDots = onboardingData.size,
            selectedIndex = currentPage
        )

        Spacer(modifier = Modifier.height(20.dp))

        NextButton(
            text = item.buttonText,
            onClick = onNextClick,
        )
    }
}

@Composable
fun TitleText(text: String) {
    Text(
        text = text,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 38.sp,
        fontFamily = Roboto,
        textAlign = TextAlign.Center,
        color = Color(0xFF111827)
    )
}

@Composable
fun DescriptionText(text: String) {
    Text(
        text = text,
        fontSize = 15.sp,
        lineHeight = 22.sp,
        fontFamily = Roboto,
        textAlign = TextAlign.Center,
        color = Color(0xFF6B7280),
        modifier = Modifier.padding(top = 12.dp)
    )
}

@Composable
fun NextButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFEF4444)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontFamily = Roboto,
                fontSize = 15.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
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
                    .height(8.dp)
                    .width(if (index == selectedIndex) 25.dp else 8.dp)
                    .size(if (index == selectedIndex) 12.dp else 8.dp)
                    .background(
                        color = if (index == selectedIndex)
                            Color(0xFFEF4444)
                        else
                            Color(0xFFD1D5DB),
                        shape = RoundedCornerShape( 50)
                    )
            )
        }
    }
}