package Models;

public class ThongTinDangNhap {
	protected String MaNV;
	protected String TaiKhoan;
	protected String MatKhau;
	
	public ThongTinDangNhap(String maNV) {
		super();
		MaNV = maNV;
	}

	public ThongTinDangNhap() {
		super();
	}

	public ThongTinDangNhap(String maNV, String taiKhoan, String matKhau) {
		super();
		MaNV = maNV;
		TaiKhoan = taiKhoan;
		MatKhau = matKhau;
	}

	public ThongTinDangNhap(String maNV, String matKhau) {
		super();
		MaNV = maNV;
		MatKhau = matKhau;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getTaiKhoan() {
		return TaiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		TaiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
}
