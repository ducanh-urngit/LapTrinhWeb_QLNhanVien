package Models;

import java.sql.Date;

public class LichTrinhCongTac {
	private String MaNV;
	private String MaQD;
	private Date NgayBatDau;
	private Date NgayKetThuc;
	private String DiaDiem;
	private String NoiDung;
	private Date NgayKy;
	
	public LichTrinhCongTac(String maNV, String maQD, Date ngayBatDau, Date ngayKetThuc, String diaDiem, String noiDung,
			Date ngayKy) {
		super();
		MaNV = maNV;
		MaQD = maQD;
		NgayBatDau = ngayBatDau;
		NgayKetThuc = ngayKetThuc;
		DiaDiem = diaDiem;
		NoiDung = noiDung;
		NgayKy = ngayKy;
	}

	public LichTrinhCongTac() {
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

	public String getDiaDiem() {
		return DiaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		DiaDiem = diaDiem;
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
