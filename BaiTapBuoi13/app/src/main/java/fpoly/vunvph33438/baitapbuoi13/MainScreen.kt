@file:JvmName("MainActivityKt")

package fpoly.vunvph33438.baitapbuoi13

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import fpoly.vunvph33438.baitapbuoi13.room.StudentModel
import fpoly.vunvph33438.baitapbuoi13.viewmodel.StudentViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: StudentViewModel, navController: NavController) {
    var hoTen by remember { mutableStateOf("") }
    var mssv by remember { mutableStateOf("") }
    var diemTB by remember { mutableStateOf("") }
    var daRaTruong by remember { mutableStateOf(false) }
    val empty by remember { mutableStateOf("") }
    val showDialog = remember { mutableStateOf(false) }
    val students by viewModel.students.collectAsState(initial = emptyList())

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Quản lý sinh viên",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.background
                )
            }, colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primary)
        )
    }, floatingActionButton = {
        FloatingActionButton(
            onClick = { showDialog.value = true },
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.background,
            shape = CircleShape
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = null)
        }
    }) { it ->
        if (students.isEmpty()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                Text(text = "Danh sách sinh viên trống")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(), contentPadding = PaddingValues(10.dp)
            ) {
                items(students) {
                    Card(
                        onClick = {
                            navController.navigate(
                                "Card/${Uri.encode(it.uid.toString())}/${Uri.encode(it.hoTen)}/${
                                    Uri.encode(
                                        it.mssv
                                    )
                                }/${
                                    Uri.encode(
                                        it.diemTB.toString()
                                    )
                                }/${Uri.encode(it.daRaTruong.toString())}"
                            )
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(5.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column {
                            Text(
                                modifier = Modifier.padding(14.dp),
                                fontSize = 24.sp,
                                color = MaterialTheme.colorScheme.primary,
                                text = it.uid.toString()
                            )
                            Text(
                                modifier = Modifier.padding(14.dp),
                                fontSize = 24.sp,
                                text = it.hoTen.toString()
                            )
                            Text(
                                modifier = Modifier.padding(14.dp),
                                fontSize = 24.sp,
                                text = it.mssv.toString()
                            )
                            Text(
                                modifier = Modifier.padding(14.dp),
                                fontSize = 24.sp,
                                text = it.diemTB.toString()
                            )
                            Text(
                                modifier = Modifier.padding(14.dp),
                                fontSize = 24.sp,
                                text = if (it.daRaTruong == true) "Đã ra trường" else "Chưa ra trường"
                            )
                        }
                    }
                }
            }
        }

        if (showDialog.value) {
            AlertDialog(onDismissRequest = { showDialog.value = false }, dismissButton = {
                Button(onClick = {
                    showDialog.value = false
                    hoTen = empty
                    mssv = empty
                    diemTB = empty
                    daRaTruong = false
                }) {
                    Text(text = "Cancel")
                }
            }, confirmButton = {
                if (hoTen.isNotEmpty() && mssv.isNotEmpty() && diemTB.isNotEmpty()) {
                    Button(onClick = {
                        val diemTBFloat = diemTB.toFloatOrNull() ?: 0f
                        val daRaTruongBoolean = daRaTruong
                        viewModel.addStudent(
                            StudentModel(
                                0, hoTen, mssv, diemTBFloat, daRaTruongBoolean
                            )
                        )
                        showDialog.value = false
                        hoTen = empty
                        mssv = empty
                        diemTB = empty
                        daRaTruong = false
                    }) {
                        Text(text = "Save")
                    }
                }
            }, title = {
                Text(
                    text = "Add student",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(5.dp)
                )
            }, text = {
                Column {
                    OutlinedTextField(
                        value = hoTen,
                        onValueChange = { hoTen = it },
                        label = { Text(text = "Ho ten") },
                        placeholder = { Text(text = "Nhap ho ten") },
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    OutlinedTextField(
                        value = mssv,
                        onValueChange = { mssv = it },
                        label = { Text(text = "Mssv") },
                        placeholder = { Text(text = "Nhap mssv") },
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    OutlinedTextField(
                        value = diemTB,
                        onValueChange = { diemTB = it },
                        label = { Text(text = "Diem tb") },
                        placeholder = { Text(text = "Nhap Diem tb") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        Text(text = "Đã ra trường")
                        Switch(
                            checked = daRaTruong,
                            onCheckedChange = { daRaTruong = it },
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            })
        }
    }
}
