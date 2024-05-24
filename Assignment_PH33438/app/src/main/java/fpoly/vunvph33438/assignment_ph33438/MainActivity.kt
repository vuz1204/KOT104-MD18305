package fpoly.vunvph33438.assignment_ph33438

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import fpoly.vunvph33438.assignment_ph33438.navigation.AppNavigation
import fpoly.vunvph33438.assignment_ph33438.ui.theme.Assignment_PH33438Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment_PH33438Theme {
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}
