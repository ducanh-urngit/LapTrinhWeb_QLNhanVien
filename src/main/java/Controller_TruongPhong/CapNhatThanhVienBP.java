package Controller_TruongPhong;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_Admin_QLBoPhan;
import DAO.DAO_Admin_QLNV;
import DAO.DAO_TruongPhong;
import Models.BoPhan;
import Models.NhanVien;

@WebServlet({ "/BoPhan", "/CapNhatTV", "/CapNhatTVBP" })
public class CapNhatThanhVienBP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_TruongPhong DAOControll;
	public DAO_Admin_QLBoPhan DAOControllAD;
	public DAO_Admin_QLNV DAOControllQLNV;
    public CapNhatThanhVienBP() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_TruongPhong();
		DAOControllAD = new DAO_Admin_QLBoPhan();
		DAOControllQLNV = new DAO_Admin_QLNV();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
			 case "/BoPhan": 
				 ShowListBoPhanDeCapNhat(request, response); 
				 break; 
			 case "/CapNhatTV": 
				 ShowFormCapNhat(request, response); 
				 break;
			 case "/CapNhatTVBP": 
				 ThucHienCapNhat(request, response); 
				 break;
		}
	}

	public void ShowListBoPhanDeCapNhat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NhanVien NV = (NhanVien) session.getAttribute("NV");
		String MaPB = NV.getMaPhongBan();
		List<BoPhan> list = DAOControll.SelectBoPhanTrongPB(MaPB);
		request.setAttribute("listBP", list);
		request.setAttribute("CurrentTab", "CapNhatThanhVienBoPhan");
		RequestDispatcher dispatcher = request.getRequestDispatcher("formTruongPhong.jsp");
		dispatcher.forward(request, response);
	}

	public void ShowFormCapNhat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaBP = request.getParameter("MaBP");
		BoPhan BP = DAOControllAD.LayBP(MaBP);
		request.setAttribute("BP", BP);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormTruongPhongCon/CapNhatThanhVienBP/FormCapNhatThanhVienBP.jsp");
		dispatcher.forward(request, response);
	}
	
	public void ThucHienCapNhat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaBPMoi = request.getParameter("MaBoPhan");
		String MaNV = request.getParameter("MaNhanVien");
		NhanVien nv = DAOControllQLNV.LayNV(MaNV);
		
		DAOControll.CapNhatThanhVienBoPhan(MaBPMoi, nv);
		response.sendRedirect("BoPhan");
	}

}
