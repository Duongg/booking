package com.example.booking.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.booking.navigation.HomeRoute
import com.example.booking.theme.BookingTheme
import kotlinx.coroutines.delay

@Composable
fun SplashView(navController: NavController){
    LaunchedEffect(key1 = Unit){
        delay(3000)
        navController.popBackStack()
        navController.navigate(HomeRoute.Home.Route)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF01347F)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Booking.com",
            textAlign = TextAlign.Center,
            style = TextStyle(color = Color(0xFFFFFFFF), fontSize = 36.sp, fontWeight = FontWeight.W600)
        )
    }
}


@Preview
@Composable
fun PreviewSplashView(){
    val navController = rememberNavController()
    BookingTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            SplashView(navController)
        }
    }
}