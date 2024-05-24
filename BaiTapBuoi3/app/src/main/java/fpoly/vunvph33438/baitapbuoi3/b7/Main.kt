package fpoly.vunvph33438.baitapbuoi3.b7

import java.util.Scanner

fun main() {
    val quanLyGV = CBGV()
    val scanner = Scanner(System.`in`)

    var luaChon: Int
    do {
        println("===== MENU =====")
        println("1. Thêm giáo viên")
        println("2. Xóa giáo viên")
        println("3. Tính lương thực lĩnh")
        println("0. Thoát")
        print("Nhập lựa chọn của bạn: ")
        luaChon = scanner.nextInt()
        scanner.nextLine()

        when (luaChon) {
            1 -> {
                println("Nhập thông tin giáo viên mới:")
                print("Họ tên: ")
                val hoTen = scanner.nextLine()
                print("Tuổi: ")
                val tuoi = scanner.nextInt()
                scanner.nextLine()
                print("Quê quán: ")
                val queQuan = scanner.nextLine()
                print("Mã số giáo viên (MSGV): ")
                val MSGV = scanner.nextLine()
                print("Lương cứng: ")
                val luongCung = scanner.nextDouble()
                print("Lương thưởng: ")
                val luongThuong = scanner.nextDouble()
                print("Tiền phạt: ")
                val tienPhat = scanner.nextDouble()

                val gvMoi = Nguoi().apply {
                    this.hoTen = hoTen
                    this.tuoi = tuoi
                    this.queQuan = queQuan
                    this.MSGV = MSGV
                    this.luongCung = luongCung
                    this.luongThuong = luongThuong
                    this.tienPhat = tienPhat
                }

                quanLyGV.themGiaoVien(gvMoi)
                println("Đã thêm giáo viên thành công.")
            }

            2 -> {
                print("Nhập MSGV của giáo viên cần xóa: ")
                val MSGV = scanner.nextLine()
                quanLyGV.xoaGiaoVien(MSGV)
            }

            3 -> {
                print("Nhập MSGV của giáo viên cần tính lương: ")
                val MSGV = scanner.nextLine()
                quanLyGV.tinhLuong(MSGV)
            }

            0 -> {
                println("Thoát chương trình.")
            }

            else -> {
                println("Lựa chọn không hợp lệ. Vui lòng chọn lại.")
            }
        }
    } while (luaChon != 0)
}

class Main {
}
