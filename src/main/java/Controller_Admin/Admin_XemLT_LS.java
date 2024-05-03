package Controller_Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_Admin_LayLT_LS;
import DAO.DAO_GiamDoc;
import DAO.DAO_NV_Controll;
import DAO.DAO_TruongPhong;
import Models.LichSuLamViec;
import Models.LichTrinhCongTac;
import Models.NhanVien;
import Models.PhanQuyen;

@WebServlet({ "/DSLichTrinhCT", "/DSLichSuLV" })
public class Admin_XemLT_LS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public PhanQuyen phanQuyen;
	public DAO_GiamDoc DAOGD;
	public DAO_NV_Controll DAONV;
	public DAO_Admin_LayLT_LS DAOAd;
	public DAO_TruongPhong DAOTP;
    public Admin_XemLT_LS() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		phanQuyen = new PhanQuyen();
		DAOGD = new DAO_GiamDoc();
		DAONV = new DAO_NV_Controll();
		DAOAd = new DAO_Admin_LayLT_LS();
		DAOTP = new DAO_TruongPhong();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
			 case "/DSLichTrinhCT": 
				 ShowListLichTrinhCongTac(request, response); 
				 break; 
			 case "/DSLichSuLV": 
				 ShowListLichSuLamViec(request, response); 
				 break;
			 
		}
	}

	public void ShowListLichTrinhCongTac(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		HttpSession session = request.getSession();
		NhanVien nv = (NhanVien)session.getAttribute("NV");
		String VaiTro = nv.getChucVu();
		List<NhanVien> listNV = null;
		List<LichTrinhCongTac> listLT = new ArrayList<>();
		switch (VaiTro) {
		case "Giam doc":
			String MaCN = nv.getMaChiNhanh();
			listNV = DAOGD.SelectNV(MaCN);
			for(NhanVien NV : listNV)
			{
				String MaNV = NV.getMaNV();
				List<LichTrinhCongTac> list = DAONV.LayThongTinLichTrinhCongTac(MaNV);
				for(LichTrinhCongTac lt : list)
					listLT.add(lt);
			}
			request.setAttribute("listLTCT", listLT);
			break;
		case "Admin":
			listLT = DAOAd.LayAllLichTrinhCT();
			request.setAttribute("listLTCT", listLT);
			break;
		}
		String form = phanQuyen.LayPhanQuyen(VaiTro);
		
		request.setAttribute("CurrentTab", "XemLichTrinhCongTacNhanVien");
		RequestDispatcher rd = request.getRequestDispatcher(form);  
		rd.forward(request, response);
	}

	public void ShowListLichSuLamViec(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		HttpSession session = request.getSession();
		NhanVien nv = (NhanVien)session.getAttribute("NV");
		String VaiTro = nv.getChucVu();
		List<NhanVien> listNV = null;
		List<LichSuLamViec> listLS = new ArrayList<>();
		switch (VaiTro) {
		case "Giam doc":
			String MaCN = nv.getMaChiNhanh();
			listNV = DAOGD.SelectNV(MaCN);
			for(NhanVien NV : listNV)
			{
				String MaNV = NV.getMaNV();
				List<LichSuLamViec> list = DAONV.LayThongTinLichSuLamViec(MaNV);
				for(LichSuLamViec ls : list)
					listLS.add(ls);
			}
			request.setAttribute("listLSLV", listLS);
			break;
		case "Truong phong":
			String MaPB = nv.getMaPhongBan();
			listNV = DAOTP.SelectNV(MaPB);
			for(NhanVien NV : listNV)
			{
				String MaNV = NV.getMaNV();
				List<LichSuLamViec> list = DAONV.LayThongTinLichSuLamViec(MaNV);
				for(LichSuLamViec ls : list)
					listLS.add(ls);
			}
			request.setAttribute("listLSLV", listLS);
			break;
		case "Admin":
			listLS = DAOAd.LayAllLichSuLV();
			request.setAttribute("listLSLV", listLS);
			break;
		}
		String form = phanQuyen.LayPhanQuyen(VaiTro);
		
		request.setAttribute("CurrentTab", "XemLichSuLamViecNhanVien");
		RequestDispatcher rd = request.getRequestDispatcher(form);  
		rd.forward(request, response);
		}
}
