package Controller_GiamDoc;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_Admin_QLNV;
import DAO.DAO_GiamDoc_CapNhatLSLV;
import Models.NhanVien;

@WebServlet({ "/LichSuLV", "/CapNhatLSLV", "/ThucHienCapNhatLSLV" })
public class CapNhatLichSuLamViec extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_GiamDoc_CapNhatLSLV DAOControll;
	public DAO_Admin_QLNV DAOControllAd;
    public CapNhatLichSuLamViec() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_GiamDoc_CapNhatLSLV();
		DAOControllAd = new DAO_Admin_QLNV();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
			 case "/LichSuLV": 
				 ShowListNhanVienDeCapNhat(request, response); 
				 break; 
			 case "/CapNhatLSLV": 
				 ShowFormCapNhat(request, response); 
				 break;
			 case "/ThucHienCapNhatLSLV": 
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
		request.setAttribute("CurrentTab", "CapNhatLichSu");
		RequestDispatcher dispatcher = request.getRequestDispatcher("formGiamDoc.jsp");
		dispatcher.forward(request, response);
	}

	public void ShowFormCapNhat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaNV = request.getParameter("MaNV");
		NhanVien nv = DAOControllAd.LayNV(MaNV);
		String MaCN = nv.getMaChiNhanh();
		request.setAttribute("MaCN", MaCN);
		request.setAttribute("MaNV", MaNV);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormGiamDocCon/CapNhatLichSuLamViec/FormCapNhatLichSuLamViec.jsp");
		dispatcher.forward(request, response);
	}
	
	public void ThucHienCapNhat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaNV = request.getParameter("MaNhanVien");
		NhanVien nv = DAOControllAd.LayNV(MaNV);
		String MaPhongBanMoi = request.getParameter("MaPhongBan");
		
		java.util.Date date = new java.util.Date();
		Date NgayChuyen = new java.sql.Date(date.getTime());
		
		DAOControll.CapNhatLSLV(MaNV, nv, MaPhongBanMoi, NgayChuyen);

		response.sendRedirect("LichSuLV");
	}
}
