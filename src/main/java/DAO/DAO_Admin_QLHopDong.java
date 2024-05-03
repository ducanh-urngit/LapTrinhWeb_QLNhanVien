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
import Models.HopDong;

public class DAO_Admin_QLHopDong {
	public DAO_Admin_QLHopDong() {
		super();
	}
	
	public List<HopDong> SelectAllHopDong() {
		List<HopDong> list = new ArrayList<>();
		String query = "select * from HopDongNhanVien;";

		try (Connection connection = JDBCUtil.GetConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String MaHD = rs.getString("MaHopDong");
				String NoiDung = rs.getString("NoiDung");
				Date NgayApDung = rs.getDate("NgayApDung");
				int LanSuaDoi = rs.getInt("LanSuaDoi");
				Date NgaySuaDoi = rs.getDate("NgaySuaDoi");
				Date NgayKy = rs.getDate("NgayKy");
				HopDong hd = new HopDong(MaHD, NoiDung, NgayApDung, LanSuaDoi, NgaySuaDoi, NgayKy);
				list.add(hd);
			}
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return list;
	}
	
	public HopDong LayHD(String Mahd) {
		String query = "select * from HopDongNhanVien where MaHopDong = '" + Mahd + "';";
		HopDong hd = null;
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String MaHD = rs.getString("MaHopDong");
				String NoiDung = rs.getString("NoiDung");
				Date NgayApDung = rs.getDate("NgayApDung");
				int LanSuaDoi = rs.getInt("LanSuaDoi");
				Date NgaySuaDoi = rs.getDate("NgaySuaDoi");
				Date NgayKy = rs.getDate("NgayKy");
				hd = new HopDong(MaHD, NoiDung, NgayApDung, LanSuaDoi, NgaySuaDoi, NgayKy);
			}
			if (hd == null)
				hd = new HopDong();

			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return hd;
	}
	
	public int ThemHD(String MaHD, String ND, Date NgayApDung, int LanSuaDoi, Date NgaySuaDoi, Date NgayKy) {
		int c = 0;
		String query = "insert into HopDongNhanVien values (?, ? ,?, ?, ? ,?);";

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, MaHD);
			preparedStatement.setString(2, ND);
			preparedStatement.setDate(3, NgayApDung);
			preparedStatement.setInt(4, LanSuaDoi);
			preparedStatement.setDate(5, NgaySuaDoi);
			preparedStatement.setDate(6, NgayKy);
			
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public int SuaHD(String MaHD, String ND, Date NgayApDung, int LanSuaDoi, Date NgaySuaDoi, Date NgayKy) {
		int c = 0;
		String query = "update HopDongNhanVien set NoiDung = ?, NgayApDung = ?, LanSuaDoi = ?, NgaySuaDoi = ?, NgayKy = ?"
					+ " where MaHopDong = ?;" ;

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			
			preparedStatement.setString(1, ND);
			preparedStatement.setDate(2, NgayApDung);
			preparedStatement.setInt(3, LanSuaDoi);
			preparedStatement.setDate(4, NgaySuaDoi);
			preparedStatement.setDate(5, NgayKy);
			preparedStatement.setString(6, MaHD);
			
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public int XoaHD(String MaHD) {
		int c = 0;
		String query = "delete from HopDongNhanVien where MaHopDong = '"+MaHD+"';"; 
		
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
}
