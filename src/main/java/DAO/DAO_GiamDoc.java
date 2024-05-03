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
import Models.NhanVien;
import Models.PhongBan;

public class DAO_GiamDoc {
	public DAO_GiamDoc() {
		super();
	}

	public List<NhanVien> SelectNV(String MaCN) {
		List<NhanVien> listNV = new ArrayList<>();
		String query = "select * from NhanVien where MaChiNhanh = '" + MaCN + "';";
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
	
	public List<PhongBan> SelectPhongBanTrongCN(String Macn) {
		List<PhongBan> listPB = new ArrayList<>();
		String query = "select * from PhongBan where MaChiNhanh = '" + Macn + "';";
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtil.GetConnection();

				// Step 2:Create a statement using connection object

				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String MaPB = rs.getString("MaPhongBan");
				String MaCN = rs.getString("MaChiNhanh");
				String TenPB = rs.getString("TenPhongBan");
				String MaTruongPhong = rs.getString("MaTruongPhong");
				String MaPhoTruongPhong = rs.getString("MaPhoTruongPhong");
				PhongBan pb = new PhongBan(MaPB, MaCN, TenPB, MaTruongPhong, MaPhoTruongPhong);
				listPB.add(pb);
			}
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return listPB;
	}
	
	public int CapNhatTruongPhongChoPB(String MaPB, String MaNV) {
		int c = 0;
		String query = "UPDATE NhanVien "
				+ "SET ChucVu = 'Truong phong', MaPhongBan = ? , MaBoPhan = null "
				+ "WHERE MaNV = ?;";
		
		String query2 = "UPDATE PhongBan "
				+ "SET MaTruongPhong = ? "
				+ "WHERE MaPhongBan = ?;";

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				PreparedStatement preparedStatement2 = connection.prepareStatement(query2)) {
			preparedStatement.setString(1, MaPB);
			preparedStatement.setString(2, MaNV);
			c = preparedStatement.executeUpdate();
			
			preparedStatement2.setString(1, MaNV);
			preparedStatement2.setString(2, MaPB);
			c = preparedStatement2.executeUpdate();
			
			
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}

	public int CapNhatPhoTruongPhongChoPB(String MaPB, String MaNV) {
		int c = 0;
		String query = "UPDATE NhanVien "
				+ "SET ChucVu = 'Truong phong', MaPhongBan = ? , MaBoPhan = null "
				+ "WHERE MaNV = ?;";
		
		String query2 = "UPDATE PhongBan "
				+ "SET MaPhoTruongPhong = ? "
				+ "WHERE MaPhongBan = ?;";

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, MaPB);
			preparedStatement.setString(2, MaNV);
			
			c = preparedStatement.executeUpdate();
			
			
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query2)) {
			preparedStatement.setString(1, MaNV);
			preparedStatement.setString(2, MaPB);
			
			c = preparedStatement.executeUpdate();
			
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
}
