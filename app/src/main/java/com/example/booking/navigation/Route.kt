package com.example.booking.navigation

abstract class BookingRoute {
    abstract val route: String
}

sealed class HomeRoute: BookingRoute(){
    class Home : HomeRoute(){
        override val route = Route

        companion object {
            const val Route = "Home"
        }
    }
}

sealed class SplashRoute: BookingRoute(){
    class Splash : SplashRoute(){
        override val route = Route

        companion object {
            const val Route = "Splash"
        }
    }
}
