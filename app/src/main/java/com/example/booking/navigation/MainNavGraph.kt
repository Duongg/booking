package com.example.booking.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.booking.ui.home.HomeView
import com.example.booking.ui.splash.SplashView

fun NavGraphBuilder.mainNavGraph(
    navController: NavController
){
    composable(route = SplashRoute.Splash.Route){
        SplashView(navController)
    }
    composable(route = HomeRoute.Home.Route){
        HomeView()
    }

}