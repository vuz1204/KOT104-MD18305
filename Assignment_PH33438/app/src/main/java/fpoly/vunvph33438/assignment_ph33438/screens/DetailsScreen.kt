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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import fpoly.vunvph33438.assignment_ph33438.R
import fpoly.vunvph33438.assignment_ph33438.ui.theme.Gelasio
import fpoly.vunvph33438.assignment_ph33438.ui.theme.Nunitosans

@Composable
fun DetailsScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(480.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.minimal_stand_detail),
                contentDescription = "Minimal Stand",
                modifier = Modifier
                    .width(357.dp)
                    .height(480.dp)
                    .align(Alignment.CenterEnd),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .padding(33.dp)
                    .shadow(elevation = 8.dp, shape = RoundedCornerShape(4.dp))
                    .size(40.dp)
                    .background(Color.White),
                contentAlignment = Alignment.Center,
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
            }

            Box(
                modifier = Modifier
                    .padding(vertical = 130.dp, horizontal = 20.dp)
                    .shadow(elevation = 8.dp, shape = RoundedCornerShape(40.dp))
                    .height(230.dp)
                    .width(64.dp)
                    .background(Color.White),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.color1_detail),
                            contentDescription = "Color 1",
                            modifier = Modifier.fillMaxSize(),
                            tint = Color.Unspecified
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.color2_detail),
                            contentDescription = "Color 2",
                            modifier = Modifier.fillMaxSize(),
                            tint = Color.Unspecified
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.color3_detail),
                            contentDescription = "Color 3",
                            modifier = Modifier.fillMaxSize(),
                            tint = Color.Unspecified
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                "Minimal Stand",
                fontSize = 24.sp,
                fontWeight = FontWeight.W500,
                fontFamily = Gelasio
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "$ 50", fontSize = 30.sp, fontWeight = FontWeight.W700, fontFamily = Nunitosans
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                            .background(
                                Color("#F0F0F0".toColorInt()), shape = RoundedCornerShape(6.dp)
                            ),
                        contentAlignment = Alignment.Center,
                    ) {
                        IconButton(onClick = { /* TODO: Decrease quantity */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_minus),
                                contentDescription = "Decrease"
                            )
                        }
                    }
                    Text(
                        "01",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W600,
                        fontFamily = Nunitosans,
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )
                    Box(
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                            .background(
                                Color("#F0F0F0".toColorInt()), shape = RoundedCornerShape(6.dp)
                            ),
                        contentAlignment = Alignment.Center,
                    ) {
                        IconButton(onClick = { /* TODO: Increase quantity */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_plus),
                                contentDescription = "Increase"
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "Rating",
                    tint = Color.Yellow
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text("4.5", fontSize = 18.sp, fontWeight = FontWeight.W700, fontFamily = Nunitosans)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    "(50 reviews)",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.W600,
                    fontFamily = Nunitosans,
                    modifier = Modifier.padding(start = 15.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
                fontSize = 15.sp,
                color = Color.Gray,
                fontWeight = FontWeight.W300,
                fontFamily = Nunitosans
            )
            Spacer(modifier = Modifier.height(16.dp))

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .height(56.dp)
                        .width(60.dp)
                        .background(
                            Color("#F0F0F0".toColorInt()), shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite",
                        )
                    }
                }
                Button(
                    onClick = { /* TODO: Add to cart */ },
                    modifier = Modifier
                        .width(300.dp)
                        .height(60.dp)
                        .shadow(elevation = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color("#303030".toColorInt())),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        "Add to cart",
                        fontSize = 20.sp,
                        fontFamily = Nunitosans,
                        fontWeight = FontWeight.W600
                    )
                }
            }
        }
    }
}


