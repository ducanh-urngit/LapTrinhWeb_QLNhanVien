package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBCUtil.JDBCUtil;
import JDBCUtil.ShowSQLException;
import Models.ThongTinDangNhap;

public class DAO_Login {
	
	public DAO_Login() {
		super();
	}
	
	public ThongTinDangNhap KiemTraDangNhap(String TaiKhoan, String MatKhau) {
		ThongTinDangNhap nv = new ThongTinDangNhap();
		String query = "select MaNV from ThongTinDangNhap where TaiKhoan = '"+TaiKhoan+"' and MatKhau = '"+MatKhau+"';"; 
		
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			
			while (rs.next()) {
				String MaNV = rs.getString("MaNV");
				nv = new ThongTinDangNhap(MaNV);
			}

			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return nv;
	}
	
	public ThongTinDangNhap LayMatKhau(String Manv, String matkhau) {
		ThongTinDangNhap tt = null;
		String query = "select matkhau from thongtindangnhap where manv = '" + Manv + "';";
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String pass = rs.getString("MatKhau");
				tt = new ThongTinDangNhap(Manv, pass);
			}
			if (tt == null)
				tt = new ThongTinDangNhap();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return tt;
	}

	public int SuaMatKhau(String Manv, String Matkhau) {
		String query = "update thongtindangnhap set matkhau = ? where manv = '" + Manv+ "';";
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, Matkhau);
			preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return 0;
	}
}
