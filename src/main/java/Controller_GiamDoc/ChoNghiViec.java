package Controller_GiamDoc;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO_GiamDoc_CapNhatLSLV;

@WebServlet("/NghiViec")
public class ChoNghiViec extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_GiamDoc_CapNhatLSLV DAOControll;
    public ChoNghiViec() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_GiamDoc_CapNhatLSLV();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String MaNV = request.getParameter("MaNV");
		
		java.util.Date date = new java.util.Date();
		Date NgayChoNghi = new java.sql.Date(date.getTime());
		
		DAOControll.ChoNghiViec(MaNV, NgayChoNghi);

		response.sendRedirect("LichSuLV");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
