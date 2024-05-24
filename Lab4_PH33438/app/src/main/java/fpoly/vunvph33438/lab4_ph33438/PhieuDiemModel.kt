package fpoly.vunvph33438.lab4_ph33438

class PhieuDiemModel (var mssv: String, var diem: Float, var ngayNhap: String) {
    fun getThongTinSV () : StudentModel {
        var sinhVien = StudentModel() // Goi class java tu kotlin
        sinhVien.mssv = mssv
        // Query database de lay thong tin sv
        return sinhVien
    }
}