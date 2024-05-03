package Controller_Admin;

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

import DAO.DAO_Admin_QLNV;
import Models.NhanVien;

@WebServlet({ "/QLNhanVien", "/Xoa", "/Sua", "/Them", "/SuaNV", "/ThemNV" })
public class Admin_QLNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_Admin_QLNV DAOControll;
    public Admin_QLNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_Admin_QLNV();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
		case "/QLNhanVien":
			ShowListNV(request, response);
			break;
		case "/Xoa":
			deleteNV(request, response);
			break;
		case "/Sua":
			showEditForm(request, response);
			break;
		case "/Them":
			showEditForm(request, response);
			break;
		case "/SuaNV":
			SuaNV(request, response);
			break;
		case "/ThemNV":
			ThemNV(request, response);
			break;
		}
	}

	public void ShowListNV(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<NhanVien> listNV = DAOControll.SelectAllNV();
		request.setAttribute("listNV", listNV);
		request.setAttribute("CurrentTab", "QLNhanVien");
		RequestDispatcher dispatcher = request.getRequestDispatcher("formAdmin.jsp");
		dispatcher.forward(request, response);
	}

	public void deleteNV(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Manv = request.getParameter("MaNV");
		DAOControll.XoaNV(Manv);
		response.sendRedirect("QLNhanVien");
	}

	public void SuaNV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		response.sendRedirect("QLNhanVien");
	}

	public void ThemNV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String TrinhDo = request.getParameter("TrinhDo");
		String MaChiNhanh = request.getParameter("MaChiNhanh");
		String MaPhongBan = request.getParameter("MaPhongBan");
		String MaBoPhan = request.getParameter("MaBoPhan");
		int Luong = Integer.parseInt(request.getParameter("Luong"));
		DAOControll.ThemNV(MaNV, HoTen, NgaySinh, GioiTinh, DanToc, TonGiao, CCCD, NgayCap, NoiCap, DiaChi, Email, SDT,
				ChucVu, TrinhDo, MaChiNhanh, MaPhongBan, MaBoPhan, Luong);

		response.sendRedirect("QLNhanVien");
	}

	public void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String MaNV = request.getParameter("MaNV");
		NhanVien NV = DAOControll.LayNV(MaNV);
		request.setAttribute("NV", NV);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormAdminCon/NhanVien/ThemNhanVien.jsp");
		dispatcher.forward(request, response);
	}

}
