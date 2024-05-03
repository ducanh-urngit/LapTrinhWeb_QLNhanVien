package Controller_GiamDoc;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_GiamDoc_KyHopDong;
import Models.NhanVien;

@WebServlet({ "/KyHopDong", "/XacNhanKyHopDong" })
public class KyHopDongNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_GiamDoc_KyHopDong DAOControll;
    public KyHopDongNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_GiamDoc_KyHopDong();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
			 case "/KyHopDong": 
				 ShowFormKy(request, response); 
				 break; 
			 case "/XacNhanKyHopDong": 
				 ThucHienKy(request, response); 
				 break;
		}
	}

	public void ShowFormKy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NhanVien GD = (NhanVien)session.getAttribute("NV");
		String MaCN = GD.getMaChiNhanh();
		request.setAttribute("MaCN", MaCN);
		request.setAttribute("CurrentTab", "KyHopDong");
		RequestDispatcher dispatcher = request.getRequestDispatcher("formGiamDoc.jsp");
		dispatcher.forward(request, response);
	}

	public void ThucHienKy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaHD = request.getParameter("MaHopDong");
		String MaNV = request.getParameter("MaNhanVien");
		String MaCN = request.getParameter("MaChiNhanh");
		String MaPB = request.getParameter("MaPhongBan");
		String Luong = request.getParameter("Luong");
		
		String dateParam = request.getParameter("NgayKy");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = formatter.parse(dateParam);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		java.sql.Date NgayKy = new java.sql.Date(date.getTime());
		
		DAOControll.KyHopDong(MaHD, MaNV, NgayKy);
		DAOControll.CapNhatLichSuSauKyHD(MaNV, NgayKy, MaCN, MaPB, Luong);
		response.sendRedirect("KyHopDong");
	}
}
