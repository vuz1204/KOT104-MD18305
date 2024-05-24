package fpoly.vunvph33438.assignment_ph33438.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt

@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    NavigationBar(
        containerColor = Color.White
    ) {
        val items = listOf("Trang chủ", "Yêu thích", "Thông báo", "Hồ sơ")
        val icons = listOf(
            Icons.Filled.Home,
            Icons.Filled.Favorite,
            Icons.Filled.Notifications,
            Icons.Filled.Person
        )

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icons[index], contentDescription = item) },
                selected = selectedTab == index,
                onClick = { onTabSelected(index) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color("#999999".toColorInt()),
                    indicatorColor = Color.White
                )
            )
        }
    }
}

fun getRouteForIndex(index: Int): String {
    return when (index) {
        0 -> NavigationItem.Home.route
        1 -> NavigationItem.Favorites.route
        2 -> NavigationItem.Notification.route
        3 -> NavigationItem.Profile.route
        else -> NavigationItem.Home.route
    }
}

sealed class NavigationItem(var route: String) {
    data object Home : NavigationItem("Home")
    data object Favorites : NavigationItem("Favorites")
    data object Notification : NavigationItem("Notification")
    data object Profile : NavigationItem("Profile")
}
