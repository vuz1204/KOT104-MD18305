package fpoly.vunvph33438.assignment_ph33438.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import fpoly.vunvph33438.assignment_ph33438.screens.DetailsScreen
import fpoly.vunvph33438.assignment_ph33438.screens.HomeScreen
import fpoly.vunvph33438.assignment_ph33438.screens.LoginScreen
import fpoly.vunvph33438.assignment_ph33438.screens.SignUpScreen
import fpoly.vunvph33438.assignment_ph33438.screens.SplashScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "Home") {

        composable(route = "Splash") {
            SplashScreen(navController)
        }

        composable(route = "Login") {
            LoginScreen(navController)
        }

        composable(route = "SignUp") {
            SignUpScreen(navController)
        }

        composable(route = "Home") {
            HomeScreen()
        }

        composable(route = "Detail") {
            DetailsScreen()
        }
    }
}
