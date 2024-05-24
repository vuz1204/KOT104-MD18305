package fpoly.vunvph33438.lab1_ph33438

fun main() {
    val xe1 = XeHoi("Xe 1", 100f)
    val xe2 = XeHoi("Xe 2", 100f, 1996)

    xe1.tenXe = "Tên xe mới 2024"

    println(xe1.hienThiThongTinXe())
    println(xe2.hienThiThongTinXe())

    val tenSV: String? = "Vũ"
    getMSSV2(tenSV!!)
}

fun getMSSV2(tenSV: String) {
    if (tenSV == null) {
        println("Tên SV không được null")
    } else {
        println("Tên SV là: $tenSV")
    }
}

class XeHoi(var tenXe: String, var giaXe: Float) {

    var namSX: Int? = null

    constructor(tenXe: String, giaXe: Float, namSX: Int) : this(tenXe, giaXe) {
        if (namSX != null) {
            this.namSX = namSX
        }
    }

    fun hienThiThongTinXe(): String {
        if (namSX == null || namSX == 0) {
            return "Tên xe: $tenXe, giá xe: $giaXe"
        } else {
            return "Tên xe: $tenXe, giá xe: $giaXe, năm sản xuất: $namSX"
        }
    }
}