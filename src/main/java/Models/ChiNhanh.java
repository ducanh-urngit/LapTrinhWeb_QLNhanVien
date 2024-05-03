package Models;

public class ChiNhanh {
	private String MaChiNhanh;
	private String TenChiNhanh;
	private String DiaChi;
	private String MaGiamDoc;
	private String MaPhoGiamDoc;
	
	public ChiNhanh(String maChiNhanh, String tenChiNhanh, String diaChi, String maGiamDoc, String maPhoGiamDoc) {
		super();
		MaChiNhanh = maChiNhanh;
		TenChiNhanh = tenChiNhanh;
		DiaChi = diaChi;
		MaGiamDoc = maGiamDoc;
		MaPhoGiamDoc = maPhoGiamDoc;
	}

	public ChiNhanh() {
		super();
	}

	public String getMaChiNhanh() {
		return MaChiNhanh;
	}

	public void setMaChiNhanh(String maChiNhanh) {
		MaChiNhanh = maChiNhanh;
	}

	public String getTenChiNhanh() {
		return TenChiNhanh;
	}

	public void setTenChiNhanh(String tenChiNhanh) {
		TenChiNhanh = tenChiNhanh;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getMaGiamDoc() {
		return MaGiamDoc;
	}

	public void setMaGiamDoc(String maGiamDoc) {
		MaGiamDoc = maGiamDoc;
	}

	public String getMaPhoGiamDoc() {
		return MaPhoGiamDoc;
	}

	public void setMaPhoGiamDoc(String maPhoGiamDoc) {
		MaPhoGiamDoc = maPhoGiamDoc;
	}
}
