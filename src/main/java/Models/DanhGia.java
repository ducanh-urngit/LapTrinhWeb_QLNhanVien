package Models;

import java.sql.Date;

public class DanhGia {
	private String MaQuyetDinh;
	private String MaNhanVien;
	private String HinhThuc;
	private String NoiDung;
	private Date NgayKy;
	
	public DanhGia(String maQuyetDinh, String maNhanVien, String hinhThuc, String noiDung, Date ngayKy) {
		super();
		MaQuyetDinh = maQuyetDinh;
		MaNhanVien = maNhanVien;
		HinhThuc = hinhThuc;
		NoiDung = noiDung;
		NgayKy = ngayKy;
	}

	public DanhGia() {
		super();
	}

	public String getMaQuyetDinh() {
		return MaQuyetDinh;
	}

	public void setMaQuyetDinh(String maQuyetDinh) {
		MaQuyetDinh = maQuyetDinh;
	}

	public String getMaNhanVien() {
		return MaNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}

	public String getHinhThuc() {
		return HinhThuc;
	}

	public void setHinhThuc(String hinhThuc) {
		HinhThuc = hinhThuc;
	}

	public String getNoiDung() {
		return NoiDung;
	}

	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}

	public Date getNgayKy() {
		return NgayKy;
	}

	public void setNgayKy(Date ngayKy) {
		NgayKy = ngayKy;
	}
}
