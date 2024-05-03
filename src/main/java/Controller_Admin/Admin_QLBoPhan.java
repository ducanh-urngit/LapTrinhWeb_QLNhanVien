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

import DAO.DAO_Admin_QLBoPhan;
import Models.BoPhan;

@WebServlet({ "/QLBoPhan", "/ThemBoPhan", "/SuaBoPhan", "/XoaBP", "/ThemBP", "/SuaBP" })
public class Admin_QLBoPhan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_Admin_QLBoPhan DAOControll;
    public Admin_QLBoPhan() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_Admin_QLBoPhan();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
			 case "/QLBoPhan": 
				 ShowListBoPhan(request, response); 
				 break; 
			 case "/ThemBoPhan": 
				 ShowFormThem(request, response); 
				 break;
			 case "/SuaBoPhan": 
				 ShowFormThem(request, response); 
				 break;
			 case "/ThemBP": 
				 ThemBP(request, response); 
				 break;
			 case "/SuaBP": 
				 SuaBP(request, response); 
				 break;
			 case "/XoaBP": 
				 XoaBP(request, response); 
				 break;
		}
	}

	public void ShowListBoPhan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoPhan> list = DAOControll.SelectAllBoPhan();
		request.setAttribute("listBP", list);
		request.setAttribute("CurrentTab", "QLBoPhan");
		RequestDispatcher dispatcher = request.getRequestDispatcher("formAdmin.jsp");
		dispatcher.forward(request, response);
	}
	
	public void ShowFormThem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaBP = request.getParameter("MaBP");
		BoPhan BP = DAOControll.LayBP(MaBP);
		request.setAttribute("BP", BP);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormAdminCon/BoPhan/ThemBoPhan.jsp");
		dispatcher.forward(request, response);
	}
	
	public void ThemBP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaBP = request.getParameter("MaBoPhan");
		String MaPB = request.getParameter("MaPhongBan");
		String TenBP = request.getParameter("TenBoPhan");
		
		DAOControll.ThemBP(MaBP, MaPB, TenBP);
		
		response.sendRedirect("QLBoPhan");
	}
	
	public void SuaBP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaBP = request.getParameter("MaBoPhan");
		String MaPB = request.getParameter("MaPhongBan");
		String TenBP = request.getParameter("TenBoPhan");
		
		DAOControll.SuaBP(MaBP, MaPB, TenBP);
		
		response.sendRedirect("QLBoPhan");
	}

	public void XoaBP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaBP = request.getParameter("MaBP");
		
		DAOControll.XoaBP(MaBP);
		
		response.sendRedirect("QLBoPhan");
	}

}
