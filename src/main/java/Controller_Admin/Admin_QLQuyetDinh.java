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

import DAO.DAO_Admin_QLQuyetDinh;
import Models.QuyetDinh;

@WebServlet({ "/QLQuyetDinh", "/ThemQuyetDinh", "/SuaQuyetDinh", "/XoaQD", "/ThemQD", "/SuaQD" })
public class Admin_QLQuyetDinh extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_Admin_QLQuyetDinh DAOControll;
    public Admin_QLQuyetDinh() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_Admin_QLQuyetDinh();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
			 case "/QLQuyetDinh": 
				 ShowListQuyetDinh(request, response); 
				 break; 
			 case "/ThemQuyetDinh": 
				 ShowFormThem(request, response); 
				 break;
			 case "/SuaQuyetDinh": 
				 ShowFormThem(request, response); 
				 break;
			 case "/ThemQD": 
				 ThemQD(request, response); 
				 break;
			 case "/SuaQD": 
				 SuaQD(request, response); 
				 break;
			 case "/XoaQD": 
				 XoaQD(request, response); 
				 break;
		}
	}

	public void ShowListQuyetDinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<QuyetDinh> list = DAOControll.SelectAllQuyetDinh();
		request.setAttribute("listQD", list);
		request.setAttribute("CurrentTab", "QLQuyetDinh");
		RequestDispatcher dispatcher = request.getRequestDispatcher("formAdmin.jsp");
		dispatcher.forward(request, response);
	}
	
	public void ShowFormThem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaQD = request.getParameter("MaQD");
		QuyetDinh QD = DAOControll.LayQD(MaQD);
		request.setAttribute("QD", QD);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormAdminCon/QuyetDinh/ThemQuyetDinh.jsp");
		dispatcher.forward(request, response);
	}
	
	public void ThemQD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaQD = request.getParameter("MaQuyetDinh");
		String ND = request.getParameter("NoiDung");
		//------------------------------------------------------------------------------------------
		String dateParam = request.getParameter("NgayApDung");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = formatter.parse(dateParam);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		java.sql.Date NgayApDung = new java.sql.Date(date.getTime());
		//--------------------------------------------------------------------------------------------------
		int LanSua = 0;
		//--------------------------------------------------------------------------------------------------
		date = new java.util.Date();
		java.sql.Date NgaySuaDoi = new java.sql.Date(date.getTime());
		//--------------------------------------------------------------------------------------------------
		dateParam = request.getParameter("NgayKy");
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		date = null;
		try {
			date = formatter.parse(dateParam);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		java.sql.Date NgayKy = new java.sql.Date(date.getTime());
		
		DAOControll.ThemQD(MaQD, ND, NgayApDung, LanSua, NgaySuaDoi, NgayKy);
		
		response.sendRedirect("QLQuyetDinh");
	}
	
	public void SuaQD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaQD = request.getParameter("MaQuyetDinh");
		String ND = request.getParameter("NoiDung");
		//------------------------------------------------------------------------------------------
		String dateParam = request.getParameter("NgayApDung");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = formatter.parse(dateParam);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		java.sql.Date NgayApDung = new java.sql.Date(date.getTime());
		//--------------------------------------------------------------------------------------------------
		int LanSua = Integer.parseInt(request.getParameter("LanSuaDoi"));
		LanSua ++;
		//--------------------------------------------------------------------------------------------------
		/*
		 * dateParam = request.getParameter("NgaySuaDoi"); formatter = new
		 * SimpleDateFormat("yyyy-MM-dd"); date = null; try { date =
		 * formatter.parse(dateParam); } catch (ParseException e) { e.printStackTrace();
		 * } java.sql.Date NgaySuaDoi = new java.sql.Date(date.getTime());
		 */
		date = new java.util.Date();
		java.sql.Date NgaySuaDoi = new java.sql.Date(date.getTime());
		//--------------------------------------------------------------------------------------------------
		dateParam = request.getParameter("NgayKy");
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		date = null;
		try {
			date = formatter.parse(dateParam);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		java.sql.Date NgayKy = new java.sql.Date(date.getTime());
		
		DAOControll.SuaQD(MaQD, ND, NgayApDung, LanSua, NgaySuaDoi, NgayKy);
		
		response.sendRedirect("QLQuyetDinh");
	}
	
	public void XoaQD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaQD = request.getParameter("MaQD");
		
		DAOControll.XoaQD(MaQD);
		
		response.sendRedirect("QLQuyetDinh");
	}

}
