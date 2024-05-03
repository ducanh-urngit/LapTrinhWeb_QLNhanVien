package Controller_GiamDoc;

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

import DAO.DAO_Admin_QLPhongBan;
import DAO.DAO_GiamDoc;
import Models.NhanVien;
import Models.PhongBan;

@WebServlet({ "/PhongBan", "/CapNhatTruongPhong", "/CapNhatTPPB", "/CapNhatPhoPhong", "/CapNhatPPPB" })
public class CapNhatTruongPhongChoPB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_GiamDoc DAOControll;
	public DAO_Admin_QLPhongBan DAOControllAD;
    public CapNhatTruongPhongChoPB() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_GiamDoc();
		DAOControllAD = new DAO_Admin_QLPhongBan();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
			 case "/PhongBan": 
				 ShowListPhongBanDeCapNhat(request, response); 
				 break; 
			 case "/CapNhatTruongPhong": 
				 ShowFormCapNhat(request, response); 
				 break;
			 case "/CapNhatTPPB": 
				 ThucHienCapNhat(request, response); 
				 break;
			 case "/CapNhatPhoPhong": 
				 ShowFormCapNhatPhoPhong(request, response); 
				 break;
			 case "/CapNhatPPPB": 
				 ThucHienCapNhatPhoPhong(request, response); 
				 break;
		}

	}

	public void ShowListPhongBanDeCapNhat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NhanVien NV = (NhanVien) session.getAttribute("NV");
		String MaCN = NV.getMaChiNhanh();
		List<PhongBan> list = DAOControll.SelectPhongBanTrongCN(MaCN);
		request.setAttribute("listPB", list);
		request.setAttribute("CurrentTab", "CapNhatTruongPhong");
		RequestDispatcher dispatcher = request.getRequestDispatcher("formTruongPhong.jsp");
		dispatcher.forward(request, response);
	}

	public void ShowFormCapNhat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaPB = request.getParameter("MaPB");
		PhongBan PB = DAOControllAD.LayPB(MaPB);
		request.setAttribute("PB", PB);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormGiamDocCon/CapNhatTruongPhong/FormCapNhatTruongPhong.jsp");
		dispatcher.forward(request, response);
	}
	
	public void ThucHienCapNhat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaPB = request.getParameter("MaPhongBan");
		String MaNV = request.getParameter("MaNhanVien");
		DAOControll.CapNhatTruongPhongChoPB(MaPB, MaNV);
		response.sendRedirect("PhongBan");
	}

	public void ShowFormCapNhatPhoPhong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaPB = request.getParameter("MaPB");
		PhongBan PB = DAOControllAD.LayPB(MaPB);
		request.setAttribute("PB", PB);
		request.setAttribute("message", "CapNhatPhoPhong");
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormGiamDocCon/CapNhatTruongPhong/FormCapNhatTruongPhong.jsp");
		dispatcher.forward(request, response);
	}
	
	public void ThucHienCapNhatPhoPhong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaPB = request.getParameter("MaPhongBan");
		String MaNV = request.getParameter("MaNhanVien");
		DAOControll.CapNhatPhoTruongPhongChoPB(MaPB, MaNV);
		response.sendRedirect("PhongBan");
	}
}
