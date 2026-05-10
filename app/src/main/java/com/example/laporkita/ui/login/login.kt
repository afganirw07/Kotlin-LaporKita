package com.example.laporkita.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laporkita.R
import com.example.laporkita.ui.login.ui.theme.LaporKitaTheme
import com.example.laporkita.ui.onboarding.Roboto
import androidx.compose.runtime.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.material3.Text


class login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LaporKitaTheme {
                Login()
            }
        }
    }
}



@Composable
fun Login() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(300.dp)
            )
            Tittle()
            Description()

            Spacer(modifier = Modifier.height(12.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),

            ) {
                InputEmail()
                Spacer(modifier = Modifier.height(20.dp))
                InputPassword()
            }
            Spacer(modifier = Modifier.height(25.dp))
            LoginNow()
            Spacer(modifier = Modifier.height(3.dp))
            RegisterButton()

        }
    }
}

@Composable
fun Tittle(modifier: Modifier = Modifier) {
    Text(
        text = "Masuk ke Akun Anda",
        fontFamily = Roboto,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF000000),
        modifier = modifier
    )
}

@Composable
fun Description(modifier: Modifier = Modifier) {
    Text(
        text = "Silakan masukkan detail akun Anda untuk melanjutkan laporan.",
        fontFamily = Roboto,
        fontSize = 17.sp,
        color = Color(0xFF6B7280),
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 2.dp),
    )
}
@Composable
fun InputEmail() {
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Email",
            fontFamily = Roboto,
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(4.dp))


        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { Text("Masukkan Email") },

            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(30.dp),

            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon",
                    modifier = Modifier.padding(1.dp)
                )
            },

            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFF5722),
                unfocusedBorderColor = Color.Gray,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )
    }
}


@Composable
fun InputPassword() {
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Password",
            fontFamily = Roboto,
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(4.dp))


        OutlinedTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            placeholder = { Text("Masukkan Password") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(30.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Email Icon",
                    modifier = Modifier.padding(1.dp)
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFF5722),
                unfocusedBorderColor = Color.Gray,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )
    }
}

@Composable
fun LoginNow() {
    Button(
        onClick = { println("Test") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .height(50.dp),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Red
        )

    ) {
        Text("Masuk Sekarang",
                fontFamily = Roboto,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp)
    }
}

@Composable
fun RegisterButton() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            "Belum punya akun? ",
            fontFamily = Roboto,
            fontSize = 16.sp
        )
        TextButton(
            onClick = { println("yh") },
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color.Red
            )
        ) {
            Text(
                "Daftar Baru",
                fontFamily = Roboto,
                fontSize = 16.sp
            )
        }
    }
}
