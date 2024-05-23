package fpoly.vunvph33438.assignment_ph33438.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import fpoly.vunvph33438.assignment_ph33438.R
import fpoly.vunvph33438.assignment_ph33438.ui.theme.Gelasio
import fpoly.vunvph33438.assignment_ph33438.ui.theme.Nunitosans

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.background_splash_screen),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "MAKE YOUR",
                fontSize = 24.sp,
                fontWeight = FontWeight.W600,
                fontFamily = Gelasio,
                color = Color("#606060".toColorInt()),
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "HOME BEAUTIFUL",
                fontSize = 30.sp,
                fontWeight = FontWeight.W700,
                fontFamily = Gelasio,
                color = Color("#303030".toColorInt()),
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "The best simple place where you\n" +
                        "discover most wonderful furnitures\n" +
                        "and make your home beautiful",
                fontSize = 18.sp,
                fontFamily = Nunitosans,
                color = Color.Gray,
                lineHeight = 30.sp,
                modifier = Modifier.align(Alignment.End)
            )

            Spacer(modifier = Modifier.height(150.dp))

            Button(
                onClick = { },
                shape = RoundedCornerShape(8),
                colors = ButtonDefaults.buttonColors(containerColor = Color("#303030".toColorInt())),
                modifier = Modifier.height(54.dp).width(159.dp)
            ) {
                Text(text = "Get Started", color = Color.White, fontFamily = Gelasio, fontSize = 18.sp, fontWeight = FontWeight.W600)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}
