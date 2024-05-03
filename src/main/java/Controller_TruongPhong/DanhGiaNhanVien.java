package Controller_TruongPhong;

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
import DAO.DAO_GiamDoc;
import DAO.DAO_TruongPhong;
import Models.NhanVien;
import Models.PhanQuyen;

@WebServlet({ "/DanhGiaNV", "/DanhGia", "/ThucHienDanhGia" })
public class DanhGiaNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_TruongPhong DAOControll_TP;
	public DAO_GiamDoc DAOControll_GD;
	public DAO_Admin_QLNV DAOControll_Ad;
	public PhanQuyen phanQuyen;
    public DanhGiaNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll_TP = new DAO_TruongPhong();
		DAOControll_GD = new DAO_GiamDoc();
		DAOControll_Ad = new DAO_Admin_QLNV();
		phanQuyen = new PhanQuyen();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action)
		{
		case "/DanhGiaNV": 
			ShowNhanVienDeDanhGia(request, response); 
			 break;
		case "/DanhGia": 
			 ShowFormDanhGia(request, response); 
			 break;
		case "/ThucHienDanhGia": 
			ThucHienDanhGia(request, response); 
			 break;
		}
	}

	public void ThucHienDanhGia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaQD = request.getParameter("MaQuyetDinh");
		String MaNV = request.getParameter("MaNhanVien");
		String Hinhthuc = request.getParameter("HinhThuc");
		String NoiDung = request.getParameter("NoiDung");

		String dateParam = request.getParameter("NgayKy");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = formatter.parse(dateParam);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		java.sql.Date NgayKy = new java.sql.Date(date.getTime());
		
		DAOControll_TP.DanhGiaNhanVien(MaQD, MaNV, Hinhthuc, NoiDung, NgayKy);

		response.sendRedirect("DanhGiaNV");
	}
	
	public void ShowFormDanhGia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaNV = request.getParameter("MaNV");
		request.setAttribute("MaNV", MaNV);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormTruongPhongCon/DanhGiaNhanVien/"
																	+ "FormDanhGiaNhanVien.jsp");
		dispatcher.forward(request, response);
	}
	
	public void ShowNhanVienDeDanhGia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NhanVien NV = (NhanVien)session.getAttribute("NV");
		String VaiTro = NV.getChucVu();
		
		List<NhanVien> list = null;
		switch (VaiTro) {
		case "Truong phong":
			String MaPB = NV.getMaPhongBan();
			list = DAOControll_TP.SelectNV(MaPB);
			break;
		case "Giam doc":
			String MaCN = NV.getMaChiNhanh();
			list = DAOControll_GD.SelectNV(MaCN);
			break;
		case "Admin":
			list = DAOControll_Ad.SelectAllNV();
			break;
		default:
			break;
		}
		
		request.setAttribute("listNV", list);
		request.setAttribute("CurrentTab", "DanhGiaNhanVien");
		String form = phanQuyen.LayPhanQuyen(VaiTro);
		RequestDispatcher dispatcher = request.getRequestDispatcher(form);
		dispatcher.forward(request, response);
	}

}
