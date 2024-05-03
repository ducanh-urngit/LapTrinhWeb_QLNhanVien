package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.JDBCUtil;
import JDBCUtil.ShowSQLException;
import Models.ThongTinDangNhap;

public class DAO_Admin_QLTaiKhoan {
	public DAO_Admin_QLTaiKhoan() {
		super();
	}
	
	public List<ThongTinDangNhap> SelectAllTaiKhoan() {
		List<ThongTinDangNhap> list = new ArrayList<>();
		String query = "select * from ThongTinDangNhap;";

		try (Connection connection = JDBCUtil.GetConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String MaNV = rs.getString("MaNV");
				String TK = rs.getString("TaiKhoan");
				String MK = rs.getString("MatKhau");
				ThongTinDangNhap tk = new ThongTinDangNhap(MaNV, TK, MK);
				list.add(tk);
			}
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return list;
	}
	
	public ThongTinDangNhap LayTK(String Matk) {
		String query = "select * from ThongTinDangNhap where MaNV = '" + Matk + "';";
		ThongTinDangNhap tk = null;
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String MaNV = rs.getString("MaNV");
				String TK = rs.getString("TaiKhoan");
				String MK = rs.getString("MatKhau");
				tk = new ThongTinDangNhap(MaNV, TK, MK);
			}
			if (tk == null)
				tk = new ThongTinDangNhap();

			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return tk;
	}
	
	public int ThemTK(String MaNV, String TK, String MK) {
		int c = 0;
		String query = "insert into ThongTinDangNhap values (?, ? ,?);";

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			
			preparedStatement.setString(1, MaNV);
			preparedStatement.setString(2, TK);
			preparedStatement.setString(3, MK);
			
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public int SuaTK(String MaNV, String TK, String MK) {
		int c = 0;
		String query = "update ThongTinDangNhap set TaiKhoan = ?, MatKhau = ?"
					+ " where MaNV = ?;" ;

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			
			preparedStatement.setString(1, TK);
			preparedStatement.setString(2, MK);
			preparedStatement.setString(3, MaNV);
			
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public int XoaTK(String MaNV) {
		int c = 0;
		String query = "delete from ThongTinDangNhap where MaNV = '"+MaNV+"';"; 
		
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
