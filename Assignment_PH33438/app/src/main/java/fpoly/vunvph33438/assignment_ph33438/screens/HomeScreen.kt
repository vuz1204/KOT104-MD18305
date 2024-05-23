package fpoly.vunvph33438.assignment_ph33438.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fpoly.vunvph33438.assignment_ph33438.R

data class Product(val name: String, val price: String, val imageRes: Int)

val products = listOf(
    Product("Black Simple Lamp", "$12.00", R.drawable.black_simple_lamp),
    Product("Minimal Stand", "$25.00", R.drawable.minimal_stand),
    Product("Coffee Chair", "$20.00", R.drawable.coffee_chair),
    Product("Simple Desk", "$50.00", R.drawable.simple_desk)
)

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Make home BEAUTIFUL", fontWeight = FontWeight.Bold, fontSize = 18.sp) },
                actions = {
                    IconButton(onClick = { /* Handle search click */ }) {
                        Icon(painterResource(id = R.drawable.ic_search), contentDescription = "Search")
                    }
                    IconButton(onClick = { /* Handle cart click */ }) {
                        Icon(painterResource(id = R.drawable.ic_cart), contentDescription = "Cart")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(icon = { Icon(painterResource(id = R.drawable.ic_home), contentDescription = "Home") }, selected = true, onClick = {})
                BottomNavigationItem(icon = { Icon(painterResource(id = R.drawable.ic_favorite), contentDescription = "Favorites") }, selected = false, onClick = {})
                BottomNavigationItem(icon = { Icon(painterResource(id = R.drawable.ic_notifications), contentDescription = "Notifications") }, selected = false, onClick = {})
                BottomNavigationItem(icon = { Icon(painterResource(id = R.drawable.ic_profile), contentDescription = "Profile") }, selected = false, onClick = {})
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            CategoryTabs()
            ProductGrid(products)
        }
    }
}

@Composable
fun CategoryTabs() {
    TabRow(selectedTabIndex = 0) {
        Tab(selected = true, onClick = { /* Handle tab click */ }) { Text("Popular") }
        Tab(selected = false, onClick = { /* Handle tab click */ }) { Text("Chair") }
        Tab(selected = false, onClick = { /* Handle tab click */ }) { Text("Table") }
        Tab(selected = false, onClick = { /* Handle tab click */ }) { Text("Armchair") }
        Tab(selected = false, onClick = { /* Handle tab click */ }) { Text("Bed") }
        Tab(selected = false, onClick = { /* Handle tab click */ }) { Text("Lamp") }
    }
}

@Composable
fun ProductGrid(products: List<Product>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products) { product ->
            ProductItem(product)
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle item click */ }
    ) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(product.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(product.price, color = Color.Gray, fontSize = 14.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
