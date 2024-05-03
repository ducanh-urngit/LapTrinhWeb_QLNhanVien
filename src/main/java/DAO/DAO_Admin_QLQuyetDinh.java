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
import Models.QuyetDinh;

public class DAO_Admin_QLQuyetDinh {
	public DAO_Admin_QLQuyetDinh() {
		super();
	}
	
	public List<QuyetDinh> SelectAllQuyetDinh() {
		List<QuyetDinh> list = new ArrayList<>();
		String query = "select * from QuyetDinh;";

		try (Connection connection = JDBCUtil.GetConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String MaQD = rs.getString("MaQuyetDinh");
				String NoiDung = rs.getString("NoiDung");
				Date NgayApDung = rs.getDate("NgayApDung");
				int LanSuaDoi = rs.getInt("LanSuaDoi");
				Date NgaySuaDoi = rs.getDate("NgaySuaDoi");
				Date NgayKy = rs.getDate("NgayKy");
				QuyetDinh qd = new QuyetDinh(MaQD, NoiDung, NgayApDung, LanSuaDoi, NgaySuaDoi, NgayKy);
				list.add(qd);
			}
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return list;
	}
	
	public QuyetDinh LayQD(String Maqd) {
		String query = "select * from QuyetDinh where MaQuyetDinh = '" + Maqd + "';";
		QuyetDinh qd = null;
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String MaQD = rs.getString("MaQuyetDinh");
				String NoiDung = rs.getString("NoiDung");
				Date NgayApDung = rs.getDate("NgayApDung");
				int LanSuaDoi = rs.getInt("LanSuaDoi");
				Date NgaySuaDoi = rs.getDate("NgaySuaDoi");
				Date NgayKy = rs.getDate("NgayKy");
				qd = new QuyetDinh(MaQD, NoiDung, NgayApDung, LanSuaDoi, NgaySuaDoi, NgayKy);
			}
			if (qd == null)
				qd = new QuyetDinh();

			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return qd;
	}
	
	public int ThemQD(String MaQD, String ND, Date NgayApDung, int LanSuaDoi, Date NgaySuaDoi, Date NgayKy) {
		int c = 0;
		String query = "insert into QuyetDinh values (?, ? ,?, ?, ? ,?);";

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, MaQD);
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
	
	public int SuaQD(String MaQD, String ND, Date NgayApDung, int LanSuaDoi, Date NgaySuaDoi, Date NgayKy) {
		int c = 0;
		String query = "update QuyetDinh set NoiDung = ?, NgayApDung = ?, LanSuaDoi = ?, NgaySuaDoi = ?, NgayKy = ?"
					+ " where MaQuyetDinh = ?;" ;

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			
			preparedStatement.setString(1, ND);
			preparedStatement.setDate(2, NgayApDung);
			preparedStatement.setInt(3, LanSuaDoi);
			preparedStatement.setDate(4, NgaySuaDoi);
			preparedStatement.setDate(5, NgayKy);
			preparedStatement.setString(6, MaQD);
			
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public int XoaQD(String MaQD) {
		int c = 0;
		String query = "delete from QuyetDinh where MaQuyetDinh = '"+MaQD+"';"; 
		
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
