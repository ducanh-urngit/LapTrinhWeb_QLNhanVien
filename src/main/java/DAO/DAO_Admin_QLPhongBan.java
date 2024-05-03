package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.JDBCUtil;
import JDBCUtil.ShowSQLException;
import Models.PhongBan;

public class DAO_Admin_QLPhongBan {
	public DAO_Admin_QLPhongBan() {
		super();
	}
	
	public List<PhongBan> SelectAllPhongBan() {
		List<PhongBan> list = new ArrayList<>();
		String query = "select * from PhongBan;";

		try (Connection connection = JDBCUtil.GetConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String MaPB = rs.getString("MaPhongBan");
				String MaCN = rs.getString("MaChiNhanh");
				String TenPB = rs.getString("TenPhongBan");
				String MaTruongPhong = rs.getString("MaTruongPhong");
				String MaPhoTruongPhong = rs.getString("MaPhoTruongPhong");
				PhongBan pb = new PhongBan(MaPB, MaCN, TenPB, MaTruongPhong, MaPhoTruongPhong);
				list.add(pb);
			}
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return list;
	}
	
	public PhongBan LayPB(String Mapb) {
		String query = "select * from PhongBan where MaPhongBan = '" + Mapb + "';";
		PhongBan pb = null;
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String MaPB = rs.getString("MaPhongBan");
				String MaCN = rs.getString("MaChiNhanh");
				String TenPB = rs.getString("TenPhongBan");
				String MaTruongPhong = rs.getString("MaTruongPhong");
				String MaPhoTruongPhong = rs.getString("MaPhoTruongPhong");
				pb = new PhongBan(MaPB, MaCN, TenPB, MaTruongPhong, MaPhoTruongPhong);
			}
			if (pb == null)
				pb = new PhongBan();

			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return pb;
	}
	
	public int ThemPB(String MaPB, String MaCN, String TenPB, String MaTruongPhong, String MaPhoTruongPhong) {
		int c = 0;
		String query = "insert into PhongBan values (?, ? ,? ,?,?);";

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, MaPB);
			if (MaCN == "")
				preparedStatement.setNull(2, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(2, MaCN);
			preparedStatement.setString(3, TenPB);
			
			if (MaTruongPhong == "")
				preparedStatement.setNull(4, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(4, MaTruongPhong);
			if (MaPhoTruongPhong == "")
				preparedStatement.setNull(5, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(5, MaPhoTruongPhong);
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public int SuaPB(String MaPB, String MaCN, String TenPB, String MaTruongPhong, String MaPhoTruongPhong) {
		int c = 0;
		String query = "update PhongBan set MaChiNhanh = ?, TenPhongBan = ?, MaTruongPhong = ?, MaPhoTruongPhong = ?"
					+ " where MaPhongBan = ?;" ;

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			
			if (MaCN.isEmpty() || MaCN.equals("null"))
				preparedStatement.setNull(1, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(1, MaCN);
			preparedStatement.setString(2, TenPB);
			
			if (MaTruongPhong.isEmpty() || MaTruongPhong.equals("null"))
				preparedStatement.setNull(3, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(3, MaTruongPhong);
			if (MaPhoTruongPhong.isEmpty() || MaPhoTruongPhong.equals("null"))
				preparedStatement.setNull(4, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(4, MaPhoTruongPhong);
			preparedStatement.setString(5, MaPB);
			
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public int XoaPB(String MaPB) {
		int c = 0;
		String query = "delete from PhongBan where MaPhongBan = '"+MaPB+"';"; 
		
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
