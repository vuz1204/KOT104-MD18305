package fpoly.vunvph33438.baitapbuoi13

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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

@Composable
fun CardScreen(
    navController: NavController,
    viewModel: StudentViewModel,
    uid: String?,
    hoTen: String?,
    mssv: String?,
    diemTB: String?,
    daRaTruong: String?
) {
    val showDialog = remember { mutableStateOf(false) }
    val updateDialog = remember { mutableStateOf(false) }
    var hoTenUD by remember { mutableStateOf(hoTen ?: "") }
    var mssvUD by remember { mutableStateOf(mssv ?: "") }
    var diemTBUD by remember { mutableStateOf(diemTB ?: "") }
    var daRaTruongUD by remember { mutableStateOf(daRaTruong?.toBoolean() ?: false) }
    val empty by remember { mutableStateOf("") }

    LaunchedEffect(updateDialog.value) {
        if (updateDialog.value) {
            hoTenUD = hoTen ?: ""
            mssvUD = mssv ?: ""
            diemTBUD = diemTB ?: ""
            daRaTruongUD = daRaTruong?.toBoolean() ?: false
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(15.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                Row {
                    Text(
                        text = "Id: ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "" + uid, fontWeight = FontWeight.Bold, fontSize = 30.sp
                    )
                }
                Row {
                    Text(
                        text = "Ho ten: ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "" + hoTen, fontWeight = FontWeight.Bold, fontSize = 30.sp
                    )
                }
                Row {
                    Text(
                        text = "Mssv: ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "" + mssv, fontWeight = FontWeight.Bold, fontSize = 30.sp
                    )
                }
                Row {
                    Text(
                        text = "Diem tb: ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "" + diemTB, fontWeight = FontWeight.Bold, fontSize = 30.sp
                    )
                }
                Row {
                    Text(
                        text = "Da ra truong: ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "" + if (daRaTruong == "true") "Roi" else "Chua",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(MaterialTheme.colorScheme.background)
                ) {

                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    OutlinedIconButton(
                        onClick = { showDialog.value = true },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier.size(height = 50.dp, width = 100.dp)
                    ) {
                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_delete),
                                contentDescription = null
                            )
                            Text(text = "Delete")
                        }
                    }
                    OutlinedIconButton(
                        onClick = { updateDialog.value = true },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier.size(height = 50.dp, width = 100.dp)
                    ) {
                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_edit),
                                contentDescription = null
                            )
                            Text(text = "Update")
                        }
                    }
                }
            }
        }
    }

    if (showDialog.value) {
        AlertDialog(onDismissRequest = { showDialog.value = false }, dismissButton = {
            Button(onClick = { showDialog.value = false }) {
                Text(text = "No")
            }
        }, confirmButton = {
            Button(onClick = {
                if (uid != null) {
                    viewModel.deleteStudent(
                        student = StudentModel(
                            uid = uid.toInt(),
                            hoTen = hoTen,
                            mssv = mssv,
                            diemTB = diemTB?.toFloatOrNull(),
                            daRaTruong = daRaTruong?.toBoolean()
                        )
                    )
                }
                showDialog.value = false
                navController.popBackStack()
            }) {
                Text(text = "Yes")
            }
        }, title = {
            Text(text = "Delete student", fontWeight = FontWeight.Bold, fontSize = 25.sp)
        }, text = {
            Text(text = "Are you sure?", fontSize = 20.sp)
        })
    }

    if (updateDialog.value) {
        AlertDialog(onDismissRequest = { updateDialog.value = false }, dismissButton = {
            Button(onClick = {
                updateDialog.value = false
                hoTenUD = empty
                mssvUD = empty
                diemTBUD = empty
                daRaTruongUD = false
            }) {
                Text(text = "Cancel")
            }
        }, confirmButton = {
            if (hoTenUD.isNotEmpty() && mssvUD.isNotEmpty() && diemTBUD.isNotEmpty()) {
                Button(onClick = {
                    val diemTBFloat = diemTBUD.toFloatOrNull() ?: 0f
                    val daRaTruongBoolean = daRaTruongUD
                    viewModel.updateStudent(
                        StudentModel(
                            uid!!.toInt(), hoTenUD, mssvUD, diemTBFloat, daRaTruongBoolean
                        )
                    )
                    navController.popBackStack()
                    updateDialog.value = false
                    hoTenUD = empty
                    mssvUD = empty
                    diemTBUD = empty
                    daRaTruongUD = false
                }) {
                    Text(text = "Update")
                }
            }
        }, title = {
            Text(
                text = "Update student",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier.padding(5.dp)
            )
        }, text = {
            Column {
                OutlinedTextField(
                    value = hoTenUD,
                    onValueChange = { hoTenUD = it },
                    label = { Text(text = "Ho ten") },
                    placeholder = { Text(text = "Nhap ho ten") },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                OutlinedTextField(
                    value = mssvUD,
                    onValueChange = { mssvUD = it },
                    label = { Text(text = "Mssv") },
                    placeholder = { Text(text = "Nhap mssv") },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                OutlinedTextField(
                    value = diemTBUD,
                    onValueChange = { diemTBUD = it },
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
                        checked = daRaTruongUD,
                        onCheckedChange = { daRaTruongUD = it },
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        })
    }
}
