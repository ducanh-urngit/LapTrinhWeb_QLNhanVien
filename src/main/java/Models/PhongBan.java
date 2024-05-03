package Models;

public class PhongBan {
	private String MaPhongBan;
	private String MaChiNhanh;
	private String TenPhongBan;
	private String MaTruongPhong;
	private String MaPhoTruongPhong;
	
	public PhongBan(String maPhongBan, String maChiNhanh, String tenPhongBan, String maTruongPhong,
			String maPhoTruongPhong) {
		super();
		MaPhongBan = maPhongBan;
		MaChiNhanh = maChiNhanh;
		TenPhongBan = tenPhongBan;
		MaTruongPhong = maTruongPhong;
		MaPhoTruongPhong = maPhoTruongPhong;
	}

	public PhongBan() {
		super();
	}

	public String getMaPhongBan() {
		return MaPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		MaPhongBan = maPhongBan;
	}

	public String getMaChiNhanh() {
		return MaChiNhanh;
	}

	public void setMaChiNhanh(String maChiNhanh) {
		MaChiNhanh = maChiNhanh;
	}

	public String getTenPhongBan() {
		return TenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		TenPhongBan = tenPhongBan;
	}

	public String getMaTruongPhong() {
		return MaTruongPhong;
	}

	public void setMaTruongPhong(String maTruongPhong) {
		MaTruongPhong = maTruongPhong;
	}

	public String getMaPhoTruongPhong() {
		return MaPhoTruongPhong;
	}

	public void setMaPhoTruongPhong(String maPhoTruongPhong) {
		MaPhoTruongPhong = maPhoTruongPhong;
	}
}
