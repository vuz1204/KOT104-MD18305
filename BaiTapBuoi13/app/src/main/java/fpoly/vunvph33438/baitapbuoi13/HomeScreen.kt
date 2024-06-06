package fpoly.vunvph33438.baitapbuoi13

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fpoly.vunvph33438.baitapbuoi13.repository.Repository
import fpoly.vunvph33438.baitapbuoi13.room.StudentDB
import fpoly.vunvph33438.baitapbuoi13.viewmodel.StudentViewModel

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val db = StudentDB.getInstance(context)
    val repository = Repository(db)
    val myViewModel = StudentViewModel(repository)
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Main") {
        composable("Main") {
            MainScreen(viewModel = myViewModel, navController = navController)
        }
        composable("Card/{uid}/{hoTen}/{mssv}/{diemTB}/{daRaTruong}") {
            CardScreen(
                navController = navController,
                viewModel = myViewModel,
                uid = it.arguments?.getString("uid"),
                hoTen = it.arguments?.getString("hoTen"),
                mssv = it.arguments?.getString("mssv"),
                diemTB = it.arguments?.getString("diemTB"),
                daRaTruong = it.arguments?.getString("daRaTruong")
            )
        }
    }
}