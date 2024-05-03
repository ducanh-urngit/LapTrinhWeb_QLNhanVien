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

import DAO.DAO_GiamDoc;
import DAO.DAO_TruongPhong;
import Models.NhanVien;
import Models.PhanQuyen;

@WebServlet("/DanhSachNV")
public class DanhSachNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_TruongPhong DAOControll_TP;
	public DAO_GiamDoc DAOControll_GD;
	public PhanQuyen phanQuyen;
    public DanhSachNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll_TP = new DAO_TruongPhong();
		DAOControll_GD = new DAO_GiamDoc();
		phanQuyen = new PhanQuyen();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		NhanVien NV = (NhanVien) session.getAttribute("NV");
		String VaiTro = NV.getChucVu();
		
		List<NhanVien> list = null;
		switch (VaiTro) {
		case "Truong phong":
			String MaPB = NV.getMaPhongBan();
			list = DAOControll_TP.SelectNV(MaPB);
			break;
		case "Giam doc":
			String MaCN = NV.getMaChiNhanh();
			list = DAOControll_GD.SelectNV(MaCN);
			break;
		default:
			break;
		}
		
		request.setAttribute("listNV", list);
		request.setAttribute("CurrentTab", "DanhSachNhanVien");
		String form = phanQuyen.LayPhanQuyen(VaiTro);
		RequestDispatcher dispatcher = request.getRequestDispatcher(form);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
