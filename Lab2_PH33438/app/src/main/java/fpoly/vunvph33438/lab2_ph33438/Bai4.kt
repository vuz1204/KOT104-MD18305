package fpoly.vunvph33438.lab2_ph33438

import java.util.Scanner

class SinhVien(
    var tenSV: String,
    var MSSV: String,
    var diemTB: Float,
    var daTotNghiep: Boolean?,
    var tuoi: Int?
)

class QuanLySinhVien {
    val danhSachSinhVien = mutableListOf<SinhVien>()

    fun themSinhVien(sv: SinhVien) {
        danhSachSinhVien.add(sv)
    }

    fun xoaSinhVien(MSSV: String) {
        val svCanXoa = danhSachSinhVien.find { it.MSSV == MSSV }
        if (svCanXoa != null) {
            danhSachSinhVien.remove(svCanXoa)
            println("Đã xóa sinh viên có MSSV $MSSV.")
        } else {
            println("Không tìm thấy sinh viên có MSSV $MSSV để xóa.")
        }
    }

    fun suaSinhVien(
        MSSV: String,
        tenMoi: String,
        diemTBMoi: Float,
        daTotNghiepMoi: Boolean?,
        tuoiMoi: Int?
    ) {
        val svCanSua = danhSachSinhVien.find { it.MSSV == MSSV }
        if (svCanSua != null) {
            svCanSua.apply {
                tenSV = tenMoi
                diemTB = diemTBMoi
                daTotNghiep = daTotNghiepMoi
                tuoi = tuoiMoi
            }
            println("Đã sửa thông tin sinh viên có MSSV $MSSV.")
        } else {
            println("Không tìm thấy sinh viên có MSSV $MSSV để sửa.")
        }
    }

    fun xemDanhSachSinhVien() {
        println("Danh sách sinh viên:")
        danhSachSinhVien.forEachIndexed { index, sv ->
            println("${index + 1}. Tên: ${sv.tenSV}, MSSV : ${sv.MSSV}, Điểm TB: ${sv.diemTB}, Đã tốt nghiệp: ${sv.daTotNghiep}, Tuổi: ${sv.tuoi}")
        }
    }
}

fun main() {
    val quanLySV = QuanLySinhVien()
    val scanner = Scanner(System.`in`)

    var luaChon: Int
    do {
        println("===== MENU =====")
        println("1. Thêm sinh viên")
        println("2. Xóa sinh viên")
        println("3. Sửa thông tin sinh viên")
        println("4. Xem danh sách sinh viên")
        println("0. Thoát")
        print("Nhập lựa chọn của bạn: ")
        luaChon = scanner.nextInt()
        scanner.nextLine()

        when (luaChon) {
            1 -> {
                println("Nhập thông tin sinh viên mới:")
                print("Tên SV: ")
                val tenSV = scanner.nextLine()
                print("MSSV : ")
                val MSSV = scanner.nextLine()
                print("Điểm TB: ")
                val diemTB = scanner.nextFloat()
                print("Đã tốt nghiệp (true/false): ")
                val daTotNghiep = scanner.nextBoolean()
                print("Tuổi: ")
                val tuoi = scanner.nextInt()
                quanLySV.themSinhVien(SinhVien(tenSV, MSSV, diemTB, daTotNghiep, tuoi))
                println("Đã thêm sinh viên thành công.")
            }

            2 -> {
                print("Nhập MSSV của sinh viên cần xóa: ")
                val MSSV = scanner.nextLine()
                quanLySV.xoaSinhVien(MSSV)
            }

            3 -> {
                println("Nhập MSSV của sinh viên cần sửa:")
                print("MSSV : ")
                val MSSV = scanner.nextLine()
                val svCanSua = quanLySV.danhSachSinhVien.find { it.MSSV == MSSV }
                if (svCanSua != null) {
                    print("Tên SV mới: ")
                    val tenSV = scanner.nextLine()
                    print("Điểm TB mới: ")
                    val diemTB = scanner.nextFloat()
                    print("Đã tốt nghiệp mới (true/false): ")
                    val daTotNghiep = scanner.nextBoolean()
                    print("Tuổi mới: ")
                    val tuoi = scanner.nextInt()
                    quanLySV.suaSinhVien(MSSV, tenSV, diemTB, daTotNghiep, tuoi)
                } else {
                    println("Không tìm thấy sinh viên có MSSV $MSSV để sửa.")
                }
            }

            4 -> {
                quanLySV.xemDanhSachSinhVien()
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

class Bai4 {
}