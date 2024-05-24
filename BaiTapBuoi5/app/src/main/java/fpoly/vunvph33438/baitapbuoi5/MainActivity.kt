package fpoly.vunvph33438.baitapbuoi5

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fpoly.vunvph33438.baitapbuoi5.ui.theme.BaiTapBuoi5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaiTapBuoi5Theme {
                MainScreen()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    var selectedTab by remember { mutableIntStateOf(2) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(selectedTab) { selectedTab = it }
        }
    ) {
        when (selectedTab) {
            0 -> HomeScreen()
            1 -> HistoryScreen()
            2 -> PaymentScreen()
            3 -> ProfileScreen()
        }
    }
}

@Composable
fun PaymentScreen() {
    var selectedPaymentMethod by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF252121))
            .padding(16.dp)
    ) {
        Text(
            text = "Thanh Toán",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        AddressSection()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Vui lòng chọn một trong những phương thức sau:",
            fontSize = 15.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        PaymentMethodItem(
            methodName = "PayPal",
            imageRes = R.drawable.paypal_logo,
            backgroundColor = Color(0xFFEB8B33),
            isSelected = selectedPaymentMethod == "PayPal"
        ) { selectedPaymentMethod = "PayPal" }
        PaymentMethodItem(
            methodName = "VISA",
            imageRes = R.drawable.visa_logo,
            backgroundColor = Color(0xFFFFFFFF),
            isSelected = selectedPaymentMethod == "VISA"
        ) { selectedPaymentMethod = "VISA" }
        PaymentMethodItem(
            methodName = "Momo",
            imageRes = R.drawable.momo_logo,
            backgroundColor = Color(0xFFD93485),
            isSelected = selectedPaymentMethod == "Momo"
        ) { selectedPaymentMethod = "Momo" }
        PaymentMethodItem(
            methodName = "Zalo Pay",
            imageRes = R.drawable.zalopay_logo,
            backgroundColor = Color(0xFF57BFF7),
            isSelected = selectedPaymentMethod == "Zalo Pay"
        ) { selectedPaymentMethod = "Zalo Pay" }
        PaymentMethodItem(
            methodName = "Thanh toán trực tiếp",
            imageRes = R.drawable.cash_payment_logo,
            backgroundColor = Color(0xFF6EE8E8),
            isSelected = selectedPaymentMethod == "Thanh toán trực tiếp"
        ) { selectedPaymentMethod = "Thanh toán trực tiếp" }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7043))
        ) {
            Text(text = "Tiếp theo", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun AddressSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color.Black)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.location_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(horizontal = 8.dp)
                    .align(Alignment.CenterVertically)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Địa chỉ nhận hàng",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Tri | 2222222", color = Color.White)
                Text(text = "22/333 đường Trung Mỹ Tây 1", color = Color.White)
                Text(text = "phường Tân Thới Nhất", color = Color.White)
                Text(text = "quận 12, Thành phố Hồ Chí Minh", color = Color.White)
            }
        }
    }
}

@Composable
fun PaymentMethodItem(
    methodName: String,
    imageRes: Int,
    isSelected: Boolean,
    backgroundColor: Color,
    onSelect: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onSelect() },
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = methodName, fontSize = 16.sp)
            Spacer(modifier = Modifier.weight(1f))
            RadioButton(
                selected = isSelected,
                onClick = onSelect,
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Black,
                    unselectedColor = Color.Gray
                )
            )
        }
    }
}

@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    NavigationBar(
        containerColor = Color(0xFF302c2c)
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Home",
                    tint = if (selectedTab == 0) Color(0xFFF4BA40) else Color.White
                )
            },
            label = {
                Text(
                    "Trang chủ",
                    color = if (selectedTab == 0) Color(0xFFF4BA40) else Color.White
                )
            },
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) },
            alwaysShowLabel = true,
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.DateRange,
                    contentDescription = "History",
                    tint = if (selectedTab == 1) Color(0xFFF4BA40) else Color.White
                )
            },
            label = {
                Text(
                    "Lịch sử",
                    color = if (selectedTab == 1) Color(0xFFF4BA40) else Color.White
                )
            },
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) },
            alwaysShowLabel = true,
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.ShoppingCart,
                    contentDescription = "Cart",
                    tint = if (selectedTab == 2) Color(0xFFF4BA40) else Color.White
                )
            },
            label = {
                Text(
                    "Giỏ hàng",
                    color = if (selectedTab == 2) Color(0xFFF4BA40) else Color.White
                )
            },
            selected = selectedTab == 2,
            onClick = { onTabSelected(2) },
            alwaysShowLabel = true,
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "Profile",
                    tint = if (selectedTab == 3) Color(0xFFF4BA40) else Color.White
                )
            },
            label = {
                Text(
                    "Hồ sơ",
                    color = if (selectedTab == 3) Color(0xFFF4BA40) else Color.White
                )
            },
            selected = selectedTab == 3,
            onClick = { onTabSelected(3) },
            alwaysShowLabel = true,
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun HistoryScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF252121)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Lịch sử", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
    }
}

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF252121)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Trang chủ",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF252121)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Hồ sơ", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentScreenPreview() {
    BaiTapBuoi5Theme {
        MainScreen()
    }
}
