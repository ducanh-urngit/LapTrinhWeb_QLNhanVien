package Controller_Login_Logout;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_Admin_QLNV;
import DAO.DAO_Login;
import Models.NhanVien;
import Models.PhanQuyen;
import Models.ThongTinDangNhap;

@WebServlet({ "/Login", "/Logout" })
public class Login_Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_Login DAOControll;
	public DAO_Admin_QLNV DAONhanVien;
	public PhanQuyen phanQuyen;
    public Login_Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_Login();
		DAONhanVien = new DAO_Admin_QLNV();
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
			case "/Login":
				Login(request, response);
				break;
			case "/Logout":
				Logout(request, response);
				break;
			}
	}

	public void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String TaiKhoan = request.getParameter("uname");
		String MatKhau = request.getParameter("psw");
		ThongTinDangNhap NV = DAOControll.KiemTraDangNhap(TaiKhoan, MatKhau);
		String MaNV = NV.getMaNV();
		HttpSession session = request.getSession();
		if(MaNV == null)
		{
			request.setAttribute("error", "Thông tin đăng nhập không chính xác!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("formLogin.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			
			NhanVien nv = DAONhanVien.LayNV(MaNV);
			String VaiTro = nv.getChucVu();
			String form = phanQuyen.LayPhanQuyen(VaiTro);
			request.setAttribute("message", "Đăng nhập thành công");
			session.setAttribute("NV", nv);
			RequestDispatcher dispatcher = request.getRequestDispatcher(form);
			dispatcher.forward(request, response);
		}
	}
	
	public void Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		RequestDispatcher rd = request.getRequestDispatcher("formLogin.jsp");  
		rd.forward(request, response);
	}

}
