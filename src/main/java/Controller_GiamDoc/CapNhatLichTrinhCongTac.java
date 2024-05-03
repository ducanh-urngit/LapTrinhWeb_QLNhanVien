package Controller_GiamDoc;

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

import DAO.DAO_GiamDoc_CapNhatLTCT;
import Models.NhanVien;

@WebServlet({ "/LichTrinhCT", "/CapNhatLTCT", "/ThucHienCapNhatLTCT" })
public class CapNhatLichTrinhCongTac extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_GiamDoc_CapNhatLTCT DAOControll;
    public CapNhatLichTrinhCongTac() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_GiamDoc_CapNhatLTCT();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
			 case "/LichTrinhCT": 
				 ShowListNhanVienDeCapNhat(request, response); 
				 break; 
			 case "/CapNhatLTCT": 
				 ShowFormCapNhat(request, response); 
				 break;
			 case "/ThucHienCapNhatLTCT": 
				 ThucHienCapNhat(request, response); 
				 break;
		}
	}

	public void ShowListNhanVienDeCapNhat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NhanVien NV = (NhanVien) session.getAttribute("NV");
		String MaCN = NV.getMaChiNhanh();
		List<NhanVien> list = DAOControll.SelectNhanVienTrongCN(MaCN);
		request.setAttribute("listNV", list);
		request.setAttribute("CurrentTab", "CapNhatLichTrinh");
		RequestDispatcher dispatcher = request.getRequestDispatcher("formGiamDoc.jsp");
		dispatcher.forward(request, response);
	}

	public void ShowFormCapNhat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaNV = request.getParameter("MaNV");
		request.setAttribute("MaNV", MaNV);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormGiamDocCon/CapNhatLichTrinhCongTac/FormCapNhatLichTrinh.jsp");
		dispatcher.forward(request, response);
	}
	
	public void ThucHienCapNhat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaNV = request.getParameter("MaNhanVien");
		String MaQD = request.getParameter("MaQuyetDinh").trim();

		String dateParam = request.getParameter("NgayBatDau");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = formatter.parse(dateParam);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		java.sql.Date NgayBatDau = new java.sql.Date(date.getTime());
		
		dateParam = request.getParameter("NgayKetThuc");
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date Date = null;
		try {
			Date = formatter.parse(dateParam);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		java.sql.Date NgayKetThuc = new java.sql.Date(Date.getTime());
		
		String DiaDiem = request.getParameter("DiaDiem");
		String NoiDung = request.getParameter("NoiDung");
		
		dateParam = request.getParameter("NgayKy");
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date DAte = null;
		try {
			DAte = formatter.parse(dateParam);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		java.sql.Date NgayKy = new java.sql.Date(DAte.getTime());
		
		DAOControll.CapNhatLTCT(MaNV, MaQD, NgayBatDau, NgayKetThuc, DiaDiem, NoiDung, NgayKy);

		response.sendRedirect("LichTrinhCT");
	}
}
