package Models;

import java.sql.Date;

public class QuyetDinh {
	private String MaQuyetDinh;
	private String NoiDung;
	private Date NgayApDung;
	private int LanSuaDoi;
	private Date NgaySuaDoi;
	private Date NgayKy;
	
	public QuyetDinh(String maQuyetDinh, String noiDung, Date ngayApDung, int lanSuaDoi, Date ngaySuaDoi, Date ngayKy) {
		super();
		MaQuyetDinh = maQuyetDinh;
		NoiDung = noiDung;
		NgayApDung = ngayApDung;
		LanSuaDoi = lanSuaDoi;
		NgaySuaDoi = ngaySuaDoi;
		NgayKy = ngayKy;
	}

	public QuyetDinh() {
		super();
	}

	public String getMaQuyetDinh() {
		return MaQuyetDinh;
	}

	public void setMaQuyetDinh(String maQuyetDinh) {
		MaQuyetDinh = maQuyetDinh;
	}

	public String getNoiDung() {
		return NoiDung;
	}

	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}

	public Date getNgayApDung() {
		return NgayApDung;
	}

	public void setNgayApDung(Date ngayApDung) {
		NgayApDung = ngayApDung;
	}

	public int getLanSuaDoi() {
		return LanSuaDoi;
	}

	public void setLanSuaDoi(int lanSuaDoi) {
		LanSuaDoi = lanSuaDoi;
	}

	public Date getNgaySuaDoi() {
		return NgaySuaDoi;
	}

	public void setNgaySuaDoi(Date ngaySuaDoi) {
		NgaySuaDoi = ngaySuaDoi;
	}

	public Date getNgayKy() {
		return NgayKy;
	}

	public void setNgayKy(Date ngayKy) {
		NgayKy = ngayKy;
	}
}
