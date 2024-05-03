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

import DAO.DAO_Admin_QLHopDong;
import Models.HopDong;

@WebServlet({ "/QLHopDong", "/ThemHopDong", "/SuaHopDong", "/XoaHD", "/ThemHD", "/SuaHD" })
public class Admin_QLHopDong extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_Admin_QLHopDong DAOControll;
    public Admin_QLHopDong() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_Admin_QLHopDong();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
			 case "/QLHopDong": 
				 ShowListHopDong(request, response); 
				 break; 
			 case "/ThemHopDong": 
				 ShowFormThem(request, response); 
				 break;
			 case "/SuaHopDong": 
				 ShowFormThem(request, response); 
				 break;
			 case "/ThemHD": 
				 ThemHD(request, response); 
				 break;
			 case "/SuaHD": 
				 SuaHD(request, response); 
				 break;
			 case "/XoaHD": 
				 XoaHD(request, response); 
				 break;
		}
	}

	public void ShowListHopDong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<HopDong> list = DAOControll.SelectAllHopDong();
		request.setAttribute("listHD", list);
		request.setAttribute("CurrentTab", "QLHopDong");
		RequestDispatcher dispatcher = request.getRequestDispatcher("formAdmin.jsp");
		dispatcher.forward(request, response);
	}
	
	public void ShowFormThem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaHD = request.getParameter("MaHD");
		HopDong HD = DAOControll.LayHD(MaHD);
		request.setAttribute("HD", HD);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormAdminCon/HopDong/ThemHopDong.jsp");
		dispatcher.forward(request, response);
	}
	
	public void ThemHD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaHD = request.getParameter("MaHopDong");
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
		
		DAOControll.ThemHD(MaHD, ND, NgayApDung, LanSua, NgaySuaDoi, NgayKy);
		
		response.sendRedirect("QLHopDong");
	}
	
	public void SuaHD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaHD = request.getParameter("MaHopDong");
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
		
		DAOControll.SuaHD(MaHD, ND, NgayApDung, LanSua, NgaySuaDoi, NgayKy);
		
		response.sendRedirect("QLHopDong");
	}
	
	public void XoaHD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaHD = request.getParameter("MaHD");
		
		DAOControll.XoaHD(MaHD);
		
		response.sendRedirect("QLHopDong");
	}

}
