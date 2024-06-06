package fpoly.vunvph33438.baitapbuoi13.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Student")
data class StudentModel(
    @PrimaryKey(autoGenerate = true) var uid: Int = 0,
    @ColumnInfo(name = "hoTen") var hoTen: String?,
    @ColumnInfo(name = "mssv") var mssv: String?,
    @ColumnInfo(name = "diemTB") var diemTB: Float?,
    @ColumnInfo(name = "daRaTruong") var daRaTruong: Boolean?
)