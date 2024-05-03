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

import DAO.DAO_Admin_LayDG_TTLV;
import DAO.DAO_GiamDoc;
import DAO.DAO_NV_Controll;
import DAO.DAO_TruongPhong;
import Models.DanhGia;
import Models.NhanVien;
import Models.PhanQuyen;
import Models.TrangThaiLamViec;

@WebServlet({ "/DSDanhGia", "/DSTrangThaiLV" })
public class Admin_XemLSDanhGia_LSCapNhatTTLV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public PhanQuyen phanQuyen;
	public DAO_GiamDoc DAOGD;
	public DAO_Admin_LayDG_TTLV DAOAd;
	public DAO_NV_Controll DAONV;
	public DAO_TruongPhong DAOTP;
    public Admin_XemLSDanhGia_LSCapNhatTTLV() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		phanQuyen = new PhanQuyen();
		DAOGD = new DAO_GiamDoc();
		DAONV = new DAO_NV_Controll();
		DAOTP = new DAO_TruongPhong();
		DAOAd = new DAO_Admin_LayDG_TTLV();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
			 case "/DSDanhGia": 
				 ShowListDanhGia(request, response); 
				 break; 
			 case "/DSTrangThaiLV": 
				 ShowListTrangThaiLamViec(request, response); 
				 break;
			 
		}
	}

	public void ShowListDanhGia(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
			HttpSession session = request.getSession();
			NhanVien nv = (NhanVien)session.getAttribute("NV");
			String VaiTro = nv.getChucVu();
			List<NhanVien> listNV = null;
			List<DanhGia> listDG = new ArrayList<>();
			switch (VaiTro) {
			case "Giam doc":
				String MaCN = nv.getMaChiNhanh();
				listNV = DAOGD.SelectNV(MaCN);
				for(NhanVien NV : listNV)
				{
					String MaNV = NV.getMaNV();
					List<DanhGia> list = DAONV.LayThongTinDanhGia(MaNV);
					for(DanhGia lt : list)
						listDG.add(lt);
				}
				request.setAttribute("listDG", listDG);
				break;
			case "Truong phong":
				String MaPB = nv.getMaPhongBan();
				listNV = DAOTP.SelectNV(MaPB);
				for(NhanVien NV : listNV)
				{
					String MaNV = NV.getMaNV();
					List<DanhGia> list = DAONV.LayThongTinDanhGia(MaNV);
					for(DanhGia ls : list)
						listDG.add(ls);
				}
				request.setAttribute("listDG", listDG);
				break;


			case "Admin":
				listDG = DAOAd.LayAllDanhGia();
				request.setAttribute("listDG", listDG);
				break;
			}
			String form = phanQuyen.LayPhanQuyen(VaiTro);
			
			request.setAttribute("CurrentTab", "XemDanhGiaNhanVien");
			RequestDispatcher rd = request.getRequestDispatcher(form);  
			rd.forward(request, response);
		}

	public void ShowListTrangThaiLamViec(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
			HttpSession session = request.getSession();
			NhanVien nv = (NhanVien)session.getAttribute("NV");
			String VaiTro = nv.getChucVu();
			List<NhanVien> listNV = null;
			List<TrangThaiLamViec> listTT = new ArrayList<>();
			switch (VaiTro) {
			case "Giam doc":
				String MaCN = nv.getMaChiNhanh();
				listNV = DAOGD.SelectNV(MaCN);
				for(NhanVien NV : listNV)
				{
					String MaNV = NV.getMaNV();
					List<TrangThaiLamViec> list = DAONV.LayThongTinTrangThaiLamViec(MaNV);
					for(TrangThaiLamViec lt : list)
						listTT.add(lt);
				}
				request.setAttribute("listTTLV", listTT);
				break;
			case "Truong phong":
				String MaPB = nv.getMaPhongBan();
				listNV = DAOTP.SelectNV(MaPB);
				for(NhanVien NV : listNV)
				{
					String MaNV = NV.getMaNV();
					List<TrangThaiLamViec> list = DAONV.LayThongTinTrangThaiLamViec(MaNV);
					for(TrangThaiLamViec ls : list)
						listTT.add(ls);
				}
				request.setAttribute("listTTLV", listTT);
				break;

			case "Admin":
				listTT = DAOAd.LayAllTrangThaiLamViec();
				request.setAttribute("listTTLV", listTT);
				break;
			}
			String form = phanQuyen.LayPhanQuyen(VaiTro);
			
			request.setAttribute("CurrentTab", "XemTrangThaiLamViecNV");
			RequestDispatcher rd = request.getRequestDispatcher(form);  
			rd.forward(request, response);
		}

}
