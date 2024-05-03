package Models;

import java.sql.Date;

public class HopDong {
	private String MaHopDong;
	private String NoiDung;
	private Date NgayApDung;
	private int LanSuaDoi;
	private Date NgaySuaDoi;
	private Date NgayKy;
	
	public HopDong(String maHopDong, String noiDung, Date ngayApDung, int lanSuaDoi, Date ngaySuaDoi, Date ngayKy) {
		super();
		MaHopDong = maHopDong;
		NoiDung = noiDung;
		NgayApDung = ngayApDung;
		LanSuaDoi = lanSuaDoi;
		NgaySuaDoi = ngaySuaDoi;
		NgayKy = ngayKy;
	}

	public HopDong() {
		super();
	}

	public String getMaHopDong() {
		return MaHopDong;
	}

	public void setMaHopDong(String maHopDong) {
		MaHopDong = maHopDong;
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
