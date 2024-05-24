package fpoly.vunvph33438.lab1_ph33438

fun main() {
    println("Lab 1 - MD18305")

    // Khai báo biến: cách 1 - dùng val
    val a = 1
    val b = 2
    val c = a + b
    println("Tổng 2 số $a và $b là $c")

    // Khai báo biến - ra kiểu dữ liệu
    val soThuNhat: Int = 3
    val soThuHai: Float = 4f

    val mess: String = "Tích 2 số $soThuNhat và $soThuHai là: ${soThuNhat * soThuHai}"
    println(mess)
    println(phepChia(6f, 3f))
}

fun phepChia(soA: Float, soB: Float): Float {

    if (soB == 0f) {
        return 0f
    }

    val thuong = soA / soB

    return thuong
}

class Lab1 {}