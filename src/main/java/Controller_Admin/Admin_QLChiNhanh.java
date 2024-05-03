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

import DAO.DAO_Admin_QLChiNhanh;
import Models.ChiNhanh;

@WebServlet({ "/QLChiNhanh", "/ThemChiNhanh", "/SuaChiNhanh", "/XoaCN", "/ThemCN", "/SuaCN" })
public class Admin_QLChiNhanh extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_Admin_QLChiNhanh DAOControll;
    public Admin_QLChiNhanh() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_Admin_QLChiNhanh();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
			 case "/QLChiNhanh": 
				 ShowListChiNhanh(request, response); 
				 break; 
			 case "/ThemChiNhanh": 
				 ShowFormThem(request, response); 
				 break;
			 case "/SuaChiNhanh": 
				 ShowFormThem(request, response); 
				 break;
			 case "/ThemCN": 
				 ThemCN(request, response); 
				 break;
			 case "/SuaCN": 
				 SuaCN(request, response); 
				 break;
			 case "/XoaCN": 
				 XoaCN(request, response); 
				 break;
		}
	}

	private void XoaCN(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaCN = request.getParameter("MaCN");
		
		DAOControll.XoaCN(MaCN);
		
		response.sendRedirect("QLChiNhanh");
	}
	
	private void SuaCN(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaCN = request.getParameter("MaChiNhanh");
		String TenCN = request.getParameter("TenChiNhanh");
		String DiaChi = request.getParameter("DiaChi");
		String MaGiamDoc = request.getParameter("MaGiamDoc");
		String MaPhoGiamDoc = request.getParameter("MaPhoGiamDoc");
		
		DAOControll.SuaCN(MaCN, TenCN, DiaChi, MaGiamDoc, MaPhoGiamDoc);
		
		response.sendRedirect("QLChiNhanh");
	}
	
	public void ThemCN(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaCN = request.getParameter("MaChiNhanh");
		String TenCN = request.getParameter("TenChiNhanh");
		String DiaChi = request.getParameter("DiaChi");
		String MaGiamDoc = request.getParameter("MaGiamDoc");
		String MaPhoGiamDoc = request.getParameter("MaPhoGiamDoc");
		
		DAOControll.ThemCN(MaCN, TenCN, DiaChi, MaGiamDoc, MaPhoGiamDoc);
		
		response.sendRedirect("QLChiNhanh");
	}
	
	public void ShowFormThem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaCN = request.getParameter("MaCN");
		ChiNhanh CN = DAOControll.LayCN(MaCN);
		request.setAttribute("CN", CN);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormAdminCon/ChiNhanh/ThemChiNhanh.jsp");
		dispatcher.forward(request, response);
	}

	public void ShowListChiNhanh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ChiNhanh> list = DAOControll.SelectAllChiNhanh();
		request.setAttribute("listCN", list);
		request.setAttribute("CurrentTab", "QLChiNhanh");
		RequestDispatcher dispatcher = request.getRequestDispatcher("formAdmin.jsp");
		dispatcher.forward(request, response);
	}

}
