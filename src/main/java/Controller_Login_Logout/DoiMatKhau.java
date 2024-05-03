package Controller_Login_Logout;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_Login;
import Models.NhanVien;
import Models.ThongTinDangNhap;

@WebServlet("/newPassword")
public class DoiMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO_Login DAOControll;
    public DoiMatKhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_Login();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		NhanVien nv = (NhanVien) session.getAttribute("NV");
		String MaNV = nv.getMaNV();
		String oldPass = request.getParameter("oldPass");
		String newPassword = request.getParameter("password");
		String confPassword = request.getParameter("confPassword");
		ThongTinDangNhap a = DAOControll.LayMatKhau(MaNV, oldPass);
		if (!oldPass.equals(a.getMatKhau()))
		{
			request.setAttribute("status", "resetFailed");
			response.sendRedirect("newPassword.jsp");
		}
		else {
			if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {
				DAOControll.SuaMatKhau(MaNV,newPassword);
				response.sendRedirect("ThongTinCaNhan");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
