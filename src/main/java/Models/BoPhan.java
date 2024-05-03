package Models;

public class BoPhan {
	private String MaBoPhan;
	private String MaPhongBan;
	private String TenBoPhan;
	
	public BoPhan(String maBoPhan, String maPhongBan, String tenBoPhan) {
		super();
		MaBoPhan = maBoPhan;
		MaPhongBan = maPhongBan;
		TenBoPhan = tenBoPhan;
	}
	
	public BoPhan() {
		super();
	}

	public String getMaBoPhan() {
		return MaBoPhan;
	}

	public void setMaBoPhan(String maBoPhan) {
		MaBoPhan = maBoPhan;
	}

	public String getMaPhongBan() {
		return MaPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		MaPhongBan = maPhongBan;
	}

	public String getTenBoPhan() {
		return TenBoPhan;
	}

	public void setTenBoPhan(String tenBoPhan) {
		TenBoPhan = tenBoPhan;
	}
}
