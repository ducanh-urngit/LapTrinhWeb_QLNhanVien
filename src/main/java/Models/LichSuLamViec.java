package Models;

import java.sql.Date;

public class LichSuLamViec {
	private String MaNV;
	private Date NgayBatDau;
	private String MaChiNhanh;
	private String MaPhongBan;
	private String MaBoPhan;
	private Date NgayKetThuc;
	
	public LichSuLamViec(String maNV, Date ngayBatDau, String maChiNhanh, String maPhongBan, String maBoPhan,
			Date ngayKetThuc) {
		super();
		MaNV = maNV;
		NgayBatDau = ngayBatDau;
		MaChiNhanh = maChiNhanh;
		MaPhongBan = maPhongBan;
		MaBoPhan = maBoPhan;
		NgayKetThuc = ngayKetThuc;
	}

	public LichSuLamViec() {
		super();
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public Date getNgayBatDau() {
		return NgayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		NgayBatDau = ngayBatDau;
	}

	public String getMaChiNhanh() {
		return MaChiNhanh;
	}

	public void setMaChiNhanh(String maChiNhanh) {
		MaChiNhanh = maChiNhanh;
	}

	public String getMaPhongBan() {
		return MaPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		MaPhongBan = maPhongBan;
	}

	public String getMaBoPhan() {
		return MaBoPhan;
	}

	public void setMaBoPhan(String maBoPhan) {
		MaBoPhan = maBoPhan;
	}

	public Date getNgayKetThuc() {
		return NgayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}
}
