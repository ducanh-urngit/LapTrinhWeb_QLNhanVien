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
import Models.DanhGia;
import Models.TrangThaiLamViec;

public class DAO_Admin_LayDG_TTLV {
	public DAO_Admin_LayDG_TTLV() {
		super();
	}

	public List<DanhGia> LayAllDanhGia() {

		String query = "select * from DanhGia;";
		List<DanhGia> listDG = new ArrayList<>();
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.

			while (rs.next()) {
				String MaQD = rs.getString("MaQuyetDinh");
				String MaNV = rs.getString("MaNV");
				String HinhThuc = rs.getString("HinhThuc");
				String NoiDung = rs.getString("NoiDung");
				Date NgayKy = rs.getDate("NgayKy");
				DanhGia dg = new DanhGia(MaQD, MaNV, HinhThuc, NoiDung, NgayKy);
				listDG.add(dg);
			}

			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return listDG;
	}

	public List<TrangThaiLamViec> LayAllTrangThaiLamViec() {

		String query = "select * from TrangThaiLamViec; ";
		List<TrangThaiLamViec> listTT = new ArrayList<>();
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.

			while (rs.next()) {
				
				String MaNV = rs.getString("MaNV");
				String MaQD = rs.getString("MaQuyetDinh");
				Date NgayBatDau = rs.getDate("NgayBatDau");
				Date NgayKetThuc = rs.getDate("NgayKetThuc");
				String NoiDung = rs.getString("NoiDung");
				Date NgayKy = rs.getDate("NgayKy");
				
				TrangThaiLamViec tt = new TrangThaiLamViec(MaNV, MaQD, NgayBatDau, NgayKetThuc, NoiDung, NgayKy);
				listTT.add(tt);
			}

			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return listTT;
	}


}
