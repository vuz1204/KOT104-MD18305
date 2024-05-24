package fpoly.vunvph33438.lab1_ph33438

import androidx.compose.ui.text.toUpperCase

fun main() {
    val soA = 5
    val soB = 10

    val tinhTong2 = { soA: Int, soB: Int ->
        {
            val a = 5
            val b = 10
            val c = a + b
            (soA + soB)
        }
    }

    val chiaDoi = { soA: Float -> soA / 2 }

    val nhanDoi: (Int) -> Int = { it * 2 }

    println("Nhan doi so 5: ${nhanDoi(5)}")
    println("Chia doi so 5: ${chiaDoi(5f)}")

    // Scope function
    val a = 5
    val nhanDoi2 = a.let { it * 2 }
    println("Nhan doi so 5: $nhanDoi2")

    fun tinhTong(soA: Int, soB: Int): Int {
        return (soA + soB)
    }

    val tenSV = "Nguyen Van Vu"
    val tenInHoa = with(tenSV) {
        tenSV.toUpperCase()
    }

    println(tenInHoa)

    println("Cach 1: tong 2 so la: ${tinhTong(soA, soB)}")
    println("Cach 2: tong 2 so la: ${tinhTong(soA, soB)}()")
}

fun getStringLength(str: String?): Int? {
    return str?.run {
        if (isEmpty())
            return 0
        length
    }
}

class Buoi3 {
}