package fpoly.vunvph33438.lab4_ph33438

class StudentModel {
    var mssv: String? = null
    var hoTen: String? = null
    var diemTB: Float = 0f
    var isDaRaTruong: Boolean = false

    constructor()

    constructor(mssv: String?, hoTen: String?, diemTB: Float, daRaTruong: Boolean) {
        this.mssv = mssv
        this.hoTen = hoTen
        this.diemTB = diemTB
        this.isDaRaTruong = daRaTruong
    }

    val phieuDiem: PhieuDiemModel
        get() {
            val phieuDiemModel = PhieuDiemModel(mssv!!, 8.5f, "22/5/2024") // Goi ma kotlin tu java
            return phieuDiemModel
        }
}
