package fpoly.vunvph33438.baitapbuoi3.b8

class QuanLyTheMuon {
    private var danhSachTheMuon = mutableListOf<TheMuon>()
    private val danhSachSinhVien = mutableListOf<SinhVien>()

    init {
        danhSachSinhVien.add(SinhVien().apply {
            hoTen = "Nguyễn Văn Vũ"
            tuoi = 19
            lop = "MD18305"
        })
        danhSachSinhVien.add(SinhVien().apply {
            hoTen = "Bùi Quang Vinh"
            tuoi = 20
            lop = "MD18306"
        })
    }

    fun themTheMuon(theMuon: TheMuon) {
        danhSachTheMuon.add(theMuon)
    }

    fun xoaTheMuon(maTheMuon: String) {
        val theMuonCanXoa = danhSachTheMuon.find { it.maTheMuon == maTheMuon }
        if (theMuonCanXoa != null) {
            danhSachTheMuon.remove(theMuonCanXoa)
            println("Đã xóa thẻ mượn có mã thẻ mượn $maTheMuon.")
        } else {
            println("Không tìm thấy thẻ mượn có mã thẻ mượn $maTheMuon để xóa.")
        }
    }

    fun xemDanhSachTheMuon() {
        println("Danh sách thẻ mượn:")
        danhSachTheMuon.forEachIndexed { index, theMuon ->
            println("${index + 1}. Mã thẻ mượn: ${theMuon.maTheMuon}, Ngày mượn: ${theMuon.ngayMuon}, Hạn trả: ${theMuon.hanTra}, Số hiệu sách: ${theMuon.soHieuSach}, Sinh viên: ${theMuon.sinhVien?.hoTen}")
        }
    }

    fun getSinhVienByIndex(index: Int): SinhVien? {
        return if (index >= 0 && index < danhSachSinhVien.size) {
            danhSachSinhVien[index]
        } else {
            null
        }
    }

    fun inDanhSachSinhVien() {
        println("Danh sách sinh viên:")
        danhSachSinhVien.forEachIndexed { index, sinhVien ->
            println("${index + 1}. ${sinhVien.hoTen}")
        }
    }
}