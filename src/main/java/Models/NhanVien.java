package Models;

import java.sql.Date;

public class NhanVien {
	private String MaNV;
	private String HoTen;
	private Date NgaySinh;
	private String GioiTinh;
	private String DanToc;
	private String TonGiao;
	private String CCCD;
	private Date NgayCap;
	private String NoiCap;
	private String DiaChi;
	private String Email;
	private String SDT;
	private String ChucVu;
	private String TringDo;
	private String MaChiNhanh;
	private String MaPhongBan;
	private String MaBoPhan;
	private int Luong;
	
    public NhanVien(String maNV, String hoTen, Date ngaySinh, String gioiTinh, String danToc, String tonGiao,
			String cCCD, Date ngayCap, String noiCap, String diaChi, String email, String sDT, String chucVu,
			String tringDo, String maChiNhanh, String maPhongBan, String maBoPhan, int luong) {
		super();
		MaNV = maNV;
		HoTen = hoTen;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		DanToc = danToc;
		TonGiao = tonGiao;
		CCCD = cCCD;
		NgayCap = ngayCap;
		NoiCap = noiCap;
		DiaChi = diaChi;
		Email = email;
		SDT = sDT;
		ChucVu = chucVu;
		TringDo = tringDo;
		MaChiNhanh = maChiNhanh;
		MaPhongBan = maPhongBan;
		MaBoPhan = maBoPhan;
		Luong = luong;
	}

	public NhanVien(String maNV, String chucVu, String maChiNhanh, String maPhongBan, String maBoPhan) {
		super();
		MaNV = maNV;
		ChucVu = chucVu;
		MaChiNhanh = maChiNhanh;
		MaPhongBan = maPhongBan;
		MaBoPhan = maBoPhan;
	}

	public NhanVien() {
		super();
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getDanToc() {
		return DanToc;
	}

	public void setDanToc(String danToc) {
		DanToc = danToc;
	}

	public String getTonGiao() {
		return TonGiao;
	}

	public void setTonGiao(String tonGiao) {
		TonGiao = tonGiao;
	}

	public String getCCCD() {
		return CCCD;
	}

	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}

	public Date getNgayCap() {
		return NgayCap;
	}

	public void setNgayCap(Date ngayCap) {
		NgayCap = ngayCap;
	}

	public String getNoiCap() {
		return NoiCap;
	}

	public void setNoiCap(String noiCap) {
		NoiCap = noiCap;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getChucVu() {
		return ChucVu;
	}

	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
	}

	public String getTringDo() {
		return TringDo;
	}

	public void setTringDo(String tringDo) {
		TringDo = tringDo;
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

	public int getLuong() {
		return Luong;
	}

	public void setLuong(int luong) {
		Luong = luong;
	}
}
