package Controller_NhanVien;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_Admin_QLNV;
import DAO.DAO_NV_Controll;
import Models.DanhGia;
import Models.LichSuLamViec;
import Models.LichTrinhCongTac;
import Models.NhanVien;
import Models.PhanQuyen;

@WebServlet({ "/ThongTinCaNhan", "/SuaThongTinCaNhan", "/TreeView", "/XemDanhGia", "/LSLamViec", "/LTCongTac" })
public class NhanVien_Controll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_Admin_QLNV DAOControll;
	public DAO_NV_Controll DAOControllNV;
	public PhanQuyen phanQuyen;
    public NhanVien_Controll() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_Admin_QLNV();
		DAOControllNV = new DAO_NV_Controll();
		phanQuyen = new PhanQuyen();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
			case "/ThongTinCaNhan":
				LayThongTinCaNhan(request, response);
				break;
			case "/SuaThongTinCaNhan":
				SuaThongTinCaNhan(request, response);
				break;
			case "/TreeView":
				ShowTreeView(request, response);
				break;
			case "/XemDanhGia":
				ShowDanhGia(request, response);
				break;
			case "/LSLamViec":
				ShowLichSuLamViec(request, response);
				break;
			case "/LTCongTac":
				ShowLichTrinhCongTac(request, response);
				break;
			}
	}
	
	public void ShowLichTrinhCongTac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NhanVien nv = (NhanVien)session.getAttribute("NV");
		String VaiTro = nv.getChucVu();
		String MaNV = nv.getMaNV();
		List<LichTrinhCongTac> list = DAOControllNV.LayThongTinLichTrinhCongTac(MaNV);
		
		String form = phanQuyen.LayPhanQuyen(VaiTro);
		
		request.setAttribute("listLTCT", list);
		request.setAttribute("CurrentTab", "XemLichTrinhCongTac");
		
		RequestDispatcher rd = request.getRequestDispatcher(form);  
		rd.forward(request, response);
	}
	
	public void ShowLichSuLamViec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NhanVien nv = (NhanVien)session.getAttribute("NV");
		String VaiTro = nv.getChucVu();
		String MaNV = nv.getMaNV();
		List<LichSuLamViec> list = DAOControllNV.LayThongTinLichSuLamViec(MaNV);
		
		String form = phanQuyen.LayPhanQuyen(VaiTro);
		
		request.setAttribute("listLSLV", list);
		request.setAttribute("CurrentTab", "XemLichSuLamViec");
		
		RequestDispatcher rd = request.getRequestDispatcher(form);  
		rd.forward(request, response);
	}
	
	public void ShowDanhGia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NhanVien nv = (NhanVien)session.getAttribute("NV");
		String VaiTro = nv.getChucVu();
		String MaNV = nv.getMaNV();
		List<DanhGia> list = DAOControllNV.LayThongTinDanhGia(MaNV);
		
		String form = phanQuyen.LayPhanQuyen(VaiTro);
		
		request.setAttribute("listDG", list);
		request.setAttribute("CurrentTab", "XemDanhGia");
		
		RequestDispatcher rd = request.getRequestDispatcher(form);  
		rd.forward(request, response);
	}
	
	public void ShowTreeView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NhanVien nv = (NhanVien)session.getAttribute("NV");
		String VaiTro = nv.getChucVu();
		
		String form = phanQuyen.LayPhanQuyen(VaiTro);
		
		request.setAttribute("CurrentTab", "TreeView");
		
		RequestDispatcher rd = request.getRequestDispatcher(form);  
		rd.forward(request, response);
	}

	public void LayThongTinCaNhan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NhanVien nv = (NhanVien)session.getAttribute("NV");
		String VaiTro = nv.getChucVu();
		
		String form = phanQuyen.LayPhanQuyen(VaiTro);
		
		request.setAttribute("NV", nv);
		request.setAttribute("CurrentTab", "XemThongTinCaNhan");
		request.setAttribute("message", request.getAttribute("message"));
		
		RequestDispatcher rd = request.getRequestDispatcher(form);  
		rd.forward(request, response);
	}

	public void SuaThongTinCaNhan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaNV = request.getParameter("MaNV");
		String HoTen = request.getParameter("HoTen");
		
		String dateParam = request.getParameter("NgaySinh");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = formatter.parse(dateParam);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		java.sql.Date NgaySinh = new java.sql.Date(date.getTime());
		
		String GioiTinh = request.getParameter("GioiTinh");
		String DanToc = request.getParameter("DanToc");
		String TonGiao = request.getParameter("TonGiao");
		String CCCD = request.getParameter("CCCD");
		
		dateParam = request.getParameter("NgayCap");
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date Date = null;
		try {
			Date = formatter.parse(dateParam);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		java.sql.Date NgayCap = new java.sql.Date(Date.getTime());
		
		String NoiCap = request.getParameter("NoiCap");
		String DiaChi = request.getParameter("DiaChi");
		String Email = request.getParameter("Email");
		String SDT = request.getParameter("SDT");
		String ChucVu = request.getParameter("ChucVu");
		String TrinhDo = request.getParameter("TrinhDo").trim();
		String MaChiNhanh = request.getParameter("MaChiNhanh").trim();
		String MaPhongBan = request.getParameter("MaPhongBan").trim();
		String MaBoPhan = request.getParameter("MaBoPhan").trim();
		int Luong = Integer.parseInt(request.getParameter("Luong"));
		
		DAOControll.SuaNV(MaNV, HoTen, NgaySinh, GioiTinh, DanToc, TonGiao, CCCD, NgayCap, NoiCap, DiaChi, Email, SDT,
				 			ChucVu, TrinhDo, MaChiNhanh, MaPhongBan, MaBoPhan, Luong);
		
		HttpSession session = request.getSession();
		session.setAttribute("NV", new NhanVien(MaNV, HoTen, NgaySinh, GioiTinh, DanToc, TonGiao, CCCD, NgayCap, NoiCap, DiaChi, Email, SDT,
				 			ChucVu, TrinhDo, MaChiNhanh, MaPhongBan, MaBoPhan, Luong));
		
		request.setAttribute("message", "Sửa thành công");
		response.sendRedirect("ThongTinCaNhan");
	}
}
