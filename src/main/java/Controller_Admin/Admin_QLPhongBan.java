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

import DAO.DAO_Admin_QLPhongBan;
import Models.PhongBan;

@WebServlet({ "/QLPhongBan", "/ThemPhongBan", "/SuaPhongBan", "/XoaPB", "/ThemPB", "/SuaPB" })
public class Admin_QLPhongBan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_Admin_QLPhongBan DAOControll;
    public Admin_QLPhongBan() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_Admin_QLPhongBan();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
			 case "/QLPhongBan": 
				 ShowListPhongBan(request, response); 
				 break; 
			 case "/ThemPhongBan": 
				 ShowFormThem(request, response); 
				 break;
			 case "/SuaPhongBan": 
				 ShowFormThem(request, response); 
				 break;
			 case "/ThemPB": 
				 ThemPB(request, response); 
				 break;
			 case "/SuaPB": 
				 SuaPB(request, response); 
				 break;
			 case "/XoaPB": 
				 XoaPB(request, response); 
				 break;
		}
	}

	public void ShowListPhongBan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PhongBan> list = DAOControll.SelectAllPhongBan();
		request.setAttribute("listPB", list);
		request.setAttribute("CurrentTab", "QLPhongBan");
		RequestDispatcher dispatcher = request.getRequestDispatcher("formAdmin.jsp");
		dispatcher.forward(request, response);
	}

	public void ShowFormThem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaPB = request.getParameter("MaPB");
		PhongBan PB = DAOControll.LayPB(MaPB);
		request.setAttribute("PB", PB);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormAdminCon/PhongBan/ThemPhongBan.jsp");
		dispatcher.forward(request, response);
	}
	
	public void ThemPB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaPB = request.getParameter("MaPhongBan");
		String MaCN = request.getParameter("MaChiNhanh");
		String TenPB = request.getParameter("TenPhongBan");
		String MaTruongPhong = request.getParameter("MaTruongPhong");
		String MaPhoTruongPhong = request.getParameter("MaPhoTruongPhong");
		
		DAOControll.ThemPB(MaPB, MaCN, TenPB, MaTruongPhong , MaPhoTruongPhong );
		
		response.sendRedirect("QLPhongBan");
	}
	
	public void SuaPB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaPB = request.getParameter("MaPhongBan");
		String MaCN = request.getParameter("MaChiNhanh");
		String TenPB = request.getParameter("TenPhongBan");
		String MaTruongPhong = request.getParameter("MaTruongPhong");
		String MaPhoTruongPhong = request.getParameter("MaPhoTruongPhong");
		
		DAOControll.SuaPB(MaPB, MaCN, TenPB, MaTruongPhong , MaPhoTruongPhong );
		
		response.sendRedirect("QLPhongBan");
	}
	
	public void XoaPB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaPB = request.getParameter("MaPB");
		
		DAOControll.XoaPB(MaPB);
		
		response.sendRedirect("QLPhongBan");
	}

}
