package fpoly.vunvph33438.assignment_ph33438.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fpoly.vunvph33438.assignment_ph33438.R
import fpoly.vunvph33438.assignment_ph33438.data.Product
import fpoly.vunvph33438.assignment_ph33438.data.products
import fpoly.vunvph33438.assignment_ph33438.navigation.BottomNavigationBar
import fpoly.vunvph33438.assignment_ph33438.navigation.NavigationItem
import fpoly.vunvph33438.assignment_ph33438.navigation.getRouteForIndex
import fpoly.vunvph33438.assignment_ph33438.ui.theme.Gelasio
import fpoly.vunvph33438.assignment_ph33438.ui.theme.Nunitosans

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    var selectedTab by remember { mutableIntStateOf(0) }
    val titles = listOf("Make home", "Favorites", "Notification", "Profile")

    Scaffold(topBar = {
        CustomTopAppBar(
            title = titles[selectedTab], showBeautifulText = selectedTab == 0
        )
    }, bottomBar = {
        BottomNavigationBar(selectedTab = selectedTab) { index ->
            selectedTab = index
            navController.navigate(getRouteForIndex(index)) {
                popUpTo(navController.graph.startDestinationId) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        }
    }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationHost(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(title: String, showBeautifulText: Boolean) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.Gray
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        color = Color.Gray,
                        fontWeight = FontWeight.W400,
                        fontSize = 18.sp,
                        fontFamily = Gelasio
                    )
                    if (showBeautifulText) {
                        Text(
                            text = "BEAUTIFUL",
                            color = Color.Black,
                            fontWeight = FontWeight.W700,
                            fontSize = 20.sp,
                            fontFamily = Gelasio
                        )
                    }
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Cart",
                        tint = Color.Gray
                    )
                }
            }
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black,
        )
    )
}

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) { HomeContent() }
        composable(NavigationItem.Favorites.route) { FavoritesContent() }
        composable(NavigationItem.Notification.route) { NotificationContent() }
        composable(NavigationItem.Profile.route) { ProfileContent() }
    }
}

@Composable
fun HomeContent() {
    val categoryIcons = listOf(
        painterResource(id = R.drawable.popular_category),
        painterResource(id = R.drawable.chair_category),
        painterResource(id = R.drawable.table_category),
        painterResource(id = R.drawable.armchair_category),
        painterResource(id = R.drawable.bed_category)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        ProductCategoryRow(categoryIcons)
        Spacer(modifier = Modifier.height(16.dp))
        ProductList()
    }
}

@Composable
fun ProductCategoryRow(categoryIcons: List<Painter>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val categories = listOf("Popular", "Chair", "Table", "Armchair", "Bed", "Lamp")
        categories.forEachIndexed { index, category ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            if (category == "Popular") Color.Black else Color.Gray.copy(
                                alpha = 0.1f
                            )
                        )
                ) {
                    // Thêm hình ảnh hoặc biểu tượng tương ứng cho mỗi danh mục
                    val icon = categoryIcons.getOrNull(index)
                    if (icon != null) {
                        Image(
                            painter = icon,
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(19.dp)
                                .align(Alignment.Center)
                        )
                    } else {
                        // Nếu không có hình ảnh hoặc biểu tượng, bạn có thể thêm Text thay thế
                        Text(
                            text = category.first().toString(),
                            color = if (category == "Popular") Color.White else Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = category, fontSize = 12.sp, color = Color.Black
                )
            }
        }
    }
}


@Composable
fun ProductList() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)
    ) {
        val rows = products.chunked(2)
        rows.forEachIndexed { index, row ->
            ProductRow(row)
            if (index < rows.size - 1) {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun ProductRow(products: List<Product>) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        products.forEach { product ->
            ProductItem(product)
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(width = 157.dp, height = 253.dp)
                .clip(MaterialTheme.shapes.medium)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 180.dp, height = 200.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(Color.Gray.copy(alpha = 0.1f))
                ) {
                    Image(
                        painter = painterResource(id = product.imageRes),
                        contentDescription = product.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    IconButton(
                        onClick = { /* Handle favorite button click */ },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_detail),
                            contentDescription = "Favorite",
                            tint = Color.Gray
                        )
                    }
                }
                Text(
                    text = product.name,
                    fontWeight = FontWeight(400),
                    fontFamily = Nunitosans,
                    fontSize = 14.sp,
                    maxLines = 1,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
                Text(
                    text = product.price,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = Nunitosans,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }

        }
    }
}

