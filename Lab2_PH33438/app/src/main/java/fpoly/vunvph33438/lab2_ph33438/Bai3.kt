package fpoly.vunvph33438.lab2_ph33438

fun main() {
    var year = 0
    var s: String?
    println("Chương trình kiểm tra năm nhuận:")
    do {
        println("Nhập 1 năm:")
        s = readLine()
        while (s == null || s.toInt() < 0) {
            println("Nhập sai năm, nhập lại:")
            s = readLine()
        }
        year = s.toInt()
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            println("Năm $year là năm nhuận")
        } else {
            println("Năm $year không phải là năm nhuận")
        }
        print("Tiếp không?(c/k):")
        s = readLine()
        if (s == "k")
            break;
    } while (true)
    println("Kết thúc chương trình")
}

class Bai3 {
}