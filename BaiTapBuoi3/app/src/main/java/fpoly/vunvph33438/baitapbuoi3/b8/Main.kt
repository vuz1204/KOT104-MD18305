import fpoly.vunvph33438.baitapbuoi3.b8.QuanLyTheMuon
import fpoly.vunvph33438.baitapbuoi3.b8.TheMuon
import java.util.Scanner

fun main() {
    val quanLyTheMuon = QuanLyTheMuon()
    val scanner = Scanner(System.`in`)

    var luaChon: Int
    do {
        println("===== MENU =====")
        println("1. Thêm thẻ mượn")
        println("2. Xóa thẻ mượn")
        println("3. Xem danh sách thẻ mượn")
        println("0. Thoát")
        print("Nhập lựa chọn của bạn: ")
        luaChon = scanner.nextInt()
        scanner.nextLine()

        when (luaChon) {
            1 -> {
                println("Nhập thông tin thẻ mượn mới:")
                print("Mã thẻ mượn: ")
                val maTheMuon = scanner.nextLine()
                print("Ngày mượn: ")
                val ngayMuon = scanner.nextInt()
                print("Hạn trả: ")
                val hanTra = scanner.nextInt()
                print("Số hiệu sách: ")
                val soHieuSach = scanner.nextInt()
                scanner.nextLine()

                println("Chọn sinh viên từ danh sách:")
                quanLyTheMuon.inDanhSachSinhVien()
                print("Nhập số thứ tự của sinh viên: ")
                val indexSinhVien = scanner.nextInt()
                scanner.nextLine()

                val sinhVien = quanLyTheMuon.getSinhVienByIndex(indexSinhVien - 1)
                if (sinhVien != null) {
                    val theMuonMoi = TheMuon().apply {
                        this.maTheMuon = maTheMuon
                        this.ngayMuon = ngayMuon
                        this.hanTra = hanTra
                        this.soHieuSach = soHieuSach
                        this.sinhVien = sinhVien
                    }
                    quanLyTheMuon.themTheMuon(theMuonMoi)
                    println("Đã thêm thẻ mượn thành công.")
                } else {
                    println("Không tìm thấy sinh viên có số thứ tự $indexSinhVien.")
                }
            }

            2 -> {
                print("Nhập mã thẻ mượn cần xóa: ")
                val maTheMuon = scanner.nextLine()
                quanLyTheMuon.xoaTheMuon(maTheMuon)
            }

            3 -> {
                quanLyTheMuon.xemDanhSachTheMuon()
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
