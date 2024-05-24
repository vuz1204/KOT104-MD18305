package fpoly.vunvph33438.lab1_ph33438

fun main() {
    // Khai báo và sử dụng mảng

    val arrX = intArrayOf(1, 2, 3, 4)

    println(arrX.asList())

    println("Các phần tử trong mảng X:")
    // Cách 1
    for (x in arrX) {
        println(x)
    }

    arrX[0] = 5
    arrX[1] = 7
    arrX[arrX.size - 1] = 8

    // Danh sách
    val listX = arrX.asList().toMutableList()
    listX.add(6)

    // Cách 2
    for (i in arrX.indices) {
        println("Phần tử thứ $i trong list x: ${arrX[i]}")
    }

    val listY = mutableListOf(3, 4, 5, 6)
    listY.add(0, 1)
    listY.removeAt(listY.size - 1)
    println("ListY: $listY")

    println("Nhập tên SV:")
    var s = readLine()
    if (s != null) {
        println(getMSSV(s))
    }
}

private val MAP_DSSV: Map<String, String> =
    mutableMapOf("Nguyễn Văn Vũ" to "PH33438", "Bùi Quang Vinh" to "PH33437")

// Cú pháp when trong kotlin (thay thế switch case)
fun getMSSV(tenSV: String): String? {
    when (tenSV) {
        "Nguyễn Văn Vũ" -> {
            return MAP_DSSV.get(tenSV)
        }

        "Bùi Quang Vinh" -> {
            return MAP_DSSV.get(tenSV)
        }
    }

    return "Không có dữ liệu"
}

class DemoArray {}