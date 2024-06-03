package fpoly.vunvph33438.lab7_ph33438

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            val mainViewModel: MainViewModel = viewModel()
//            val moviesState = mainViewModel.movies.observeAsState(initial = emptyList())
//            MovieScreen(moviesState.value)
            ScreenNavigation()
        }
    }
}
