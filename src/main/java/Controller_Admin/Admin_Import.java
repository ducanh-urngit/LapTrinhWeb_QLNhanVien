package Controller_Admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DAO.DAO_Admin_QLNV;
import DAO.DAO_Admin_QLTaiKhoan;

@WebServlet({ "/ImportDSNV", "/ImportTK" })
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class Admin_Import extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAO_Admin_QLNV DAOControll;
	public DAO_Admin_QLTaiKhoan DAOControllTK;
	public Admin_Import() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DAOControll = new DAO_Admin_QLNV();
		DAOControllTK = new DAO_Admin_QLTaiKhoan();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
		case "/ImportDSNV":
			ImportDanhSachNV(request, response);
			break;
		case "/ImportTK":
			ImportDanhSachTK(request, response);
			break;
		}
	}

	public void ImportDanhSachNV(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Part filePart = request.getPart("excelFile");
	    String fileName = filePart.getSubmittedFileName();
	    for (Part part : request.getParts()) {
	      part.write("E:\\" + fileName);
	    }
	  
		try {
			FileInputStream fis = new FileInputStream(new File("E:\\" + fileName));

			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();

			rowIterator.next(); // skip the header row

			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				java.util.Date utilDate = null;
				String MaNV = "";
				String HoTen = "";
				Date NgaySinh = null;
				String GioiTinh = "";
				String DanToc = "";
				String TonGiao = "";
				String CCCD = "";
				Date NgayCap = null;
				String NoiCap = "";
				String DiaChi = "";
				String Email = "";
				String SDT = "";
				String ChucVu = "";
				String TrinhDo = "";
				String MaCN = "";
				String MaPB = "";
				String MaBP = "";
				int Luong = 0;

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();

					int columnIndex = nextCell.getColumnIndex();

					switch (columnIndex) {
					case 0:
						MaNV = nextCell.getStringCellValue();
						break;
					case 1:
						HoTen = nextCell.getStringCellValue();
						break;
					case 2:
						utilDate = nextCell.getDateCellValue();
						NgaySinh = new java.sql.Date(utilDate.getTime());
						break;
					case 3:
						GioiTinh = nextCell.getStringCellValue();
						break;
					case 4:
						DanToc = nextCell.getStringCellValue();
						break;
					case 5:
						TonGiao = nextCell.getStringCellValue();
						break;
					case 6:
						CCCD = nextCell.getStringCellValue();
						break;
					case 7:
						utilDate = nextCell.getDateCellValue();
						NgayCap = new java.sql.Date(utilDate.getTime());
						break;
					case 8:
						NoiCap = nextCell.getStringCellValue();
						break;
					case 9:
						DiaChi = nextCell.getStringCellValue();
						break;
					case 10:
						Email = nextCell.getStringCellValue();
						break;
					case 11:
						SDT = nextCell.getStringCellValue();
						break;
					case 12:
						ChucVu = nextCell.getStringCellValue();
						break;
					case 13:
						TrinhDo = nextCell.getStringCellValue();
						break;
					case 14:
						MaCN = nextCell.getStringCellValue();
						break;
					case 15:
						MaPB = nextCell.getStringCellValue();
						break;
					case 16:
						MaBP = nextCell.getStringCellValue();
						break;
					case 17:
						double luong = nextCell.getNumericCellValue(); 
					    Luong = (int)luong;
					    break;
					}

				}
				DAOControll.ThemNV(MaNV, HoTen, NgaySinh, GioiTinh, DanToc, TonGiao, CCCD, NgayCap, NoiCap, DiaChi,
						Email, SDT, ChucVu, TrinhDo, MaCN, MaPB, MaBP, Luong);

			}

			workbook.close();

		} catch (IOException ex1) {
			ex1.printStackTrace();
		}
		 
		response.sendRedirect("QLNhanVien");

	}

	public void ImportDanhSachTK(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part filePart = request.getPart("excelFile");
	    String fileName = filePart.getSubmittedFileName();
	    for (Part part : request.getParts()) {
	      part.write("E:\\" + fileName);
	    }
	  
		try {
			FileInputStream fis = new FileInputStream(new File("E:\\" + fileName));

			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();

			rowIterator.next(); // skip the header row

			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				String MaNV = "";
				String TaiKhoan = "";
				String MatKhau = "";

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();

					int columnIndex = nextCell.getColumnIndex();

					switch (columnIndex) {
					case 0:
						MaNV = nextCell.getStringCellValue();
						break;
					case 1:
						TaiKhoan = nextCell.getStringCellValue();
						break;
					case 2:
						MatKhau = nextCell.getStringCellValue();
						break;
					
					}

				}
				DAOControllTK.ThemTK(MaNV, TaiKhoan, MatKhau);

			}

			workbook.close();

		} catch (IOException ex1) {
			ex1.printStackTrace();
		}
		 
		response.sendRedirect("QLTaiKhoan");
	}

}
