package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.JDBCUtil;
import JDBCUtil.ShowSQLException;
import Models.BoPhan;
import Models.NhanVien;

public class DAO_TruongPhong {
	public DAO_TruongPhong() {
		super();
	}

	public List<NhanVien> SelectNV(String MaPB) {
		List<NhanVien> listNV = new ArrayList<>();
		String query = "select * from NhanVien where MaPhongBan = '" + MaPB + "';";
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtil.GetConnection();

				// Step 2:Create a statement using connection object

				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String MaNV = rs.getString("MaNV");
				String HoTen = rs.getString("HoTen");
				Date NgaySinh = rs.getDate("NgaySinh");
				String GioiTinh = rs.getString("GioiTinh");
				String DanToc = rs.getString("DanToc");
				String TonGiao = rs.getString("TonGiao");
				String CCCD = rs.getString("CCCD");
				Date NgayCap = rs.getDate("NgayCap");
				String NoiCap = rs.getString("NoiCap");
				String DiaChi = rs.getString("DiaChi");
				String Email = rs.getString("Email");
				String SDT = rs.getString("SDT");
				String ChucVu = rs.getString("ChucVu");
				String TrinhDo = rs.getString("TrinhDo");
				String MaChiNhanh = rs.getString("MaChiNhanh");
				String MaPhongBan = rs.getString("MaPhongBan");
				String MaBoPhan = rs.getString("MaBoPhan");
				int Luong = rs.getInt("Luong");
				NhanVien nv = new NhanVien(MaNV, HoTen, NgaySinh, GioiTinh, DanToc, TonGiao, CCCD, NgayCap, NoiCap,
						DiaChi, Email, SDT, ChucVu, TrinhDo, MaChiNhanh, MaPhongBan, MaBoPhan, Luong);
				listNV.add(nv);
			}
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return listNV;
	}

	public int CapNhatTrangThaiLamViec(String MaNV, String MaQD, Date NgayBatDau, Date NgayKetThuc, String NoiDung, Date NgayKy) {
		int c = 0;
		String query = "insert into TrangThaiLamViec values (?, ? ,? ,?,?, ?);";

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, MaNV);
			preparedStatement.setString(2, MaQD);
			preparedStatement.setDate(3, NgayBatDau);
			preparedStatement.setDate(4, NgayKetThuc);
			preparedStatement.setString(5, NoiDung);
			preparedStatement.setDate(6, NgayKy);
			
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public int DanhGiaNhanVien(String MaQD, String MaNV, String HinhThuc, String NoiDung, Date NgayKy) {
		int c = 0;
		String query = "insert into DanhGia values (?, ? ,? ,?,?);";

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, MaQD);
			preparedStatement.setString(2, MaNV);
			preparedStatement.setString(3, HinhThuc);
			preparedStatement.setString(4, NoiDung);
			preparedStatement.setDate(5, NgayKy);
			
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public List<BoPhan> SelectBoPhanTrongPB(String Mapb) {
		List<BoPhan> listBP = new ArrayList<>();
		String query = "select * from BoPhanPhongBan where MaPhongBan = '" + Mapb + "';";
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtil.GetConnection();

				// Step 2:Create a statement using connection object

				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String MaBP = rs.getString("MaBoPhan");
				String MaPB = rs.getString("MaPhongBan");
				String TenBP = rs.getString("TenBoPhan");
				BoPhan bp = new BoPhan(MaBP, MaPB, TenBP);
				listBP.add(bp);
			}
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return listBP;
	}
	
	public int CapNhatThanhVienBoPhan(String MaBPMoi, NhanVien nv) {
		int c = 0;
		String MaBPOld = nv.getMaBoPhan();
		String MaCN = nv.getMaChiNhanh();
		String MaPB = nv.getMaPhongBan();
		String MaNV = nv.getMaNV();
		if(MaBPOld==null || MaBPOld.isEmpty())
		{
			String query = "UPDATE NhanVien "
					+ "SET MaBoPhan = ? "
					+ "WHERE MaNV = ?;";
			String query2 = "UPDATE LichSuLamViec "
					+ "SET MaBoPhan = ? "
					+ "WHERE MaNV = ? and MaChiNhanh = ? and MaBoPhan is null;";

			try (Connection connection = JDBCUtil.GetConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					PreparedStatement preparedStatement2 = connection.prepareStatement(query2)) {
				preparedStatement.setString(1, MaBPMoi);
				preparedStatement.setString(2, MaNV);
				
				c = preparedStatement.executeUpdate();
				
				preparedStatement2.setString(1, MaBPMoi);
				preparedStatement2.setString(2, MaNV);
				preparedStatement2.setString(3, MaCN);
				
				c = preparedStatement2.executeUpdate();
				JDBCUtil.CloseConnection(connection);
			} catch (SQLException e) {
				ShowSQLException.printSQLException(e);
			}
		}
		else {
			java.util.Date date = new java.util.Date();
			Date NgayChuyen = new java.sql.Date(date.getTime());
			String query = "UPDATE LichSuLamViec "
					+ "SET NgayKetThuc = ? "
					+ "WHERE MaNV = ? and MaBoPhan = ?;";
			String query2 = "insert into LichSuLamViec values (?,?,?,?,?,null)";
			String query3 = "UPDATE NhanVien "
					+ "SET MaBoPhan = ? "
					+ "WHERE MaNV = ?;";
			try (Connection connection = JDBCUtil.GetConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
					PreparedStatement preparedStatement3 = connection.prepareStatement(query3)) {
				preparedStatement.setDate(1, NgayChuyen);
				preparedStatement.setString(2, MaNV);
				preparedStatement.setString(3, MaBPOld);
				c = preparedStatement.executeUpdate();
				
				preparedStatement2.setString(1, MaNV);
				preparedStatement2.setDate(2, NgayChuyen);
				preparedStatement2.setString(3, MaCN);
				preparedStatement2.setString(4, MaPB);
				preparedStatement2.setString(5, MaBPMoi);
				c = preparedStatement2.executeUpdate();
				
				preparedStatement3.setString(1, MaBPMoi);
				preparedStatement3.setString(2, MaNV);
				c = preparedStatement3.executeUpdate();
				JDBCUtil.CloseConnection(connection);
			} catch (SQLException e) {
				ShowSQLException.printSQLException(e);
			}
		}
		return c;
	}
}
