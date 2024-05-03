package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.JDBCUtil;
import JDBCUtil.ShowSQLException;
import Models.ChiNhanh;

public class DAO_Admin_QLChiNhanh {
	public DAO_Admin_QLChiNhanh() {
		super();
	}

	public List<ChiNhanh> SelectAllChiNhanh() {
		List<ChiNhanh> list = new ArrayList<>();
		String query = "select * from ChiNhanh;";

		try (Connection connection = JDBCUtil.GetConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String MaCN = rs.getString("MaChiNhanh");
				String TenCN = rs.getString("TenChiNhanh");
				String DiaChi = rs.getString("DiaChi");
				String MaGiamDoc = rs.getString("MaGiamDoc");
				String MaPhoGiamDoc = rs.getString("MaPhoGiamDoc");
				ChiNhanh cn = new ChiNhanh(MaCN, TenCN, DiaChi, MaGiamDoc, MaPhoGiamDoc);
				list.add(cn);
			}
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return list;
	}

	public ChiNhanh LayCN(String Macn) {
		String query = "select * from ChiNhanh where MaChiNhanh = '" + Macn + "';";
		ChiNhanh cn = null;
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String MaCN = rs.getString("MaChiNhanh");
				String TenCN = rs.getString("TenChiNhanh");
				String DiaChi = rs.getString("DiaChi");
				String MaGiamDoc = rs.getString("MaGiamDoc");
				String MaPhoGiamDoc = rs.getString("MaPhoGiamDoc");
				cn = new ChiNhanh(MaCN, TenCN, DiaChi, MaGiamDoc, MaPhoGiamDoc);
			}
			if (cn == null)
				cn = new ChiNhanh();

			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return cn;
	}

	public int ThemCN(String MaCN, String TenCN, String DiaChi, String MaGiamDoc, String MaPhoGiamDoc) {
		int c = 0;
		String query = "insert into ChiNhanh values (?, ? ,? ,?,?);";

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, MaCN);
			preparedStatement.setString(2, TenCN);
			preparedStatement.setString(3, DiaChi);
			
			if (MaGiamDoc == "")
				preparedStatement.setNull(4, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(4, MaGiamDoc);
			if (MaPhoGiamDoc == "")
				preparedStatement.setNull(5, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(5, MaPhoGiamDoc);
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public int SuaCN(String MaCN, String TenCN, String DiaChi, String MaGiamDoc, String MaPhoGiamDoc) {
		int c = 0;
		String query = "update ChiNhanh set TenChiNhanh = ?, DiaChi = ?, MaGiamDoc = ?, MaPhoGiamDoc = ? where MaChiNhanh = ?;" ;

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			
			preparedStatement.setString(1, TenCN);
			preparedStatement.setString(2, DiaChi);
			if(MaGiamDoc.isEmpty() || MaGiamDoc.equals("null"))
				preparedStatement.setNull(3, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(3, MaGiamDoc);
			if(MaPhoGiamDoc.isEmpty() || MaPhoGiamDoc.equals("null"))
				preparedStatement.setNull(4, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(4, MaPhoGiamDoc);
			preparedStatement.setString(5, MaCN);
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public int XoaCN(String MaCN) {
		int c = 0;
		String query = "delete from ChiNhanh where MaChiNhanh = '"+MaCN+"';"; 
		
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
