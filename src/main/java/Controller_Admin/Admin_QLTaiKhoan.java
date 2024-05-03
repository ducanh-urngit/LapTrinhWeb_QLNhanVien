package Controller_Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO_Admin_QLTaiKhoan;
import Models.ThongTinDangNhap;

@WebServlet({ "/QLTaiKhoan", "/ThemTaiKhoan", "/SuaTaiKhoan", "/XoaTK", "/ThemTK", "/SuaTK" })
public class Admin_QLTaiKhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_Admin_QLTaiKhoan DAOControll;
    public Admin_QLTaiKhoan() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_Admin_QLTaiKhoan();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
			 case "/QLTaiKhoan": 
				 ShowListTaiKhoan(request, response); 
				 break; 
			 case "/ThemTaiKhoan": 
				 ShowFormThem(request, response); 
				 break;
			 case "/SuaTaiKhoan": 
				 ShowFormThem(request, response); 
				 break;
			 case "/ThemTK": 
				 ThemTK(request, response); 
				 break;
			 case "/SuaTK": 
				 SuaTK(request, response); 
				 break;
			 case "/XoaTK": 
				 XoaTK(request, response); 
				 break;
		}
	}

	public void ShowListTaiKhoan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ThongTinDangNhap> list = DAOControll.SelectAllTaiKhoan();
		request.setAttribute("listTK", list);
		request.setAttribute("CurrentTab", "QLTaiKhoan");
		RequestDispatcher dispatcher = request.getRequestDispatcher("formAdmin.jsp");
		dispatcher.forward(request, response);
	}
	
	public void ShowFormThem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaNV = request.getParameter("MaTK");
		ThongTinDangNhap TK = DAOControll.LayTK(MaNV);
		request.setAttribute("TK", TK);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormAdminCon/TaiKhoan/ThemTaiKhoan.jsp");
		dispatcher.forward(request, response);
	}
	
	public void ThemTK(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaNV = request.getParameter("MaNhanVien");
		String TK = request.getParameter("TaiKhoan");
		String MK = request.getParameter("MatKhau");
		
		DAOControll.ThemTK(MaNV, TK, MK);
		
		response.sendRedirect("QLTaiKhoan");
	}
	
	public void SuaTK(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaNV = request.getParameter("MaNhanVien");
		String TK = request.getParameter("TaiKhoan");
		String MK = request.getParameter("MatKhau");
		
		DAOControll.SuaTK(MaNV, TK, MK);
		
		response.sendRedirect("QLTaiKhoan");
	}

	public void XoaTK(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaNV = request.getParameter("MaTK");
		
		DAOControll.XoaTK(MaNV);
		
		response.sendRedirect("QLTaiKhoan");
	}

}
