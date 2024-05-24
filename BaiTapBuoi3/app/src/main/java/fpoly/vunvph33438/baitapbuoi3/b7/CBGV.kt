package fpoly.vunvph33438.baitapbuoi3.b7

class CBGV {
    private val danhSachGiaoVien = mutableListOf<Nguoi>()

    fun themGiaoVien(gv: Nguoi) {
        danhSachGiaoVien!!.add(gv)
    }

    fun xoaGiaoVien(MSGV: String) {
        val gvCanXoa = danhSachGiaoVien.find { it.MSGV == MSGV }
        if (gvCanXoa != null) {
            danhSachGiaoVien.remove(gvCanXoa)
            println("Đã xóa giáo viên có MSGV $MSGV.")
        } else {
            println("Không tìm thấy giáo viên có MSGV $MSGV để xóa.")
        }
    }

    fun tinhLuong(MSGV: String) {
        val gvCanTinh = danhSachGiaoVien.find { it.MSGV == MSGV }
        if (gvCanTinh != null) {
            var luongThucLinh = gvCanTinh.luongCung + gvCanTinh.luongThuong - gvCanTinh.tienPhat
            println("Lương thực lĩnh của giáo viên có MSGV $MSGV là $luongThucLinh.")
        } else {
            println("Không tìm thấy sinh viên có MSGV $MSGV.")
        }
    }
}
