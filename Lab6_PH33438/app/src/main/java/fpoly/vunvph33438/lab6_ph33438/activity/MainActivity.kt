package fpoly.vunvph33438.lab6_ph33438.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import fpoly.vunvph33438.lab6_ph33438.Movie
import fpoly.vunvph33438.lab6_ph33438.MovieScreen
import fpoly.vunvph33438.lab6_ph33438.ui.screens.CinemaSeatBookingScreen
import fpoly.vunvph33438.lab6_ph33438.ui.screens.createTheaterSeating

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            MovieScreen(Movie.getSampleMovies())
            CinemaSeatBookingScreen(
                createTheaterSeating(
                    totalRows = 12,
                    totalSeatsPerRow = 9,
                    aislePositionInRow = 4,
                    aislePositionInColumn = 5
                ), totalSeatsPerRow = 9
            )
        }
    }
}

