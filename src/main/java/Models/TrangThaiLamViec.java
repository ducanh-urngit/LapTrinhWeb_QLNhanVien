package Models;

import java.sql.Date;

public class TrangThaiLamViec {
	private String MaNV;
	private String MaQD;
	private Date NgayBatDau;
	private Date NgayKetThuc;
	private String NoiDung;
	private Date NgayKy;
	
	public TrangThaiLamViec(String maNV, String maQD, Date ngayBatDau, Date ngayKetThuc, String noiDung, Date ngayKy) {
		super();
		MaNV = maNV;
		MaQD = maQD;
		NgayBatDau = ngayBatDau;
		NgayKetThuc = ngayKetThuc;
		NoiDung = noiDung;
		NgayKy = ngayKy;
	}

	public TrangThaiLamViec() {
		super();
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getMaQD() {
		return MaQD;
	}

	public void setMaQD(String maQD) {
		MaQD = maQD;
	}

	public Date getNgayBatDau() {
		return NgayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		NgayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return NgayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
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
