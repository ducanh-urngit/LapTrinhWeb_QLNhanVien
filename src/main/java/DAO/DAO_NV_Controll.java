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
import Models.LichSuLamViec;
import Models.LichTrinhCongTac;
import Models.TrangThaiLamViec;

public class DAO_NV_Controll {
	public DAO_NV_Controll() {
		super();
	}

	public List<DanhGia> LayThongTinDanhGia(String Manv) {

		String query = "select * from DanhGia where MaNV = '" + Manv + "';";
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

	public List<LichSuLamViec> LayThongTinLichSuLamViec(String Manv) {

		String query = "select * from LichSuLamViec where MaNV = '" + Manv + "';";
		List<LichSuLamViec> listLS = new ArrayList<>();
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.

			while (rs.next()) {
				
				String MaNV = rs.getString("MaNV");
				Date NgayBatDau = rs.getDate("NgayBatDau");
				String MaCN = rs.getString("MaChiNhanh");
				String MaPB = rs.getString("MaPhongBan");
				String MaBP = rs.getString("MaBoPhan");
				Date NgayKetThuc = rs.getDate("NgayKetThuc");
				LichSuLamViec ls = new LichSuLamViec(MaNV, NgayBatDau, MaCN, MaPB, MaBP, NgayKetThuc);
				listLS.add(ls);
			}

			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return listLS;
	}
	
	public List<LichTrinhCongTac> LayThongTinLichTrinhCongTac(String Manv) {

		String query = "select * from LichTrinhCongTac where MaNV = '" + Manv + "';";
		List<LichTrinhCongTac> listLT = new ArrayList<>();
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.

			while (rs.next()) {
				
				String MaNV = rs.getString("MaNV");
				String MaQD = rs.getString("MaQuyetDinh");
				Date NgayBatDau = rs.getDate("NgayBatDau");
				Date NgayKetThuc = rs.getDate("NgayKetThuc");
				String DiaDiem = rs.getString("DiaDiem");
				String NoiDung = rs.getString("NoiDung");
				Date NgayKy = rs.getDate("NgayKy");
				
				LichTrinhCongTac ls = new LichTrinhCongTac(MaNV, MaQD, NgayBatDau, NgayKetThuc, DiaDiem, NoiDung, NgayKy);
				listLT.add(ls);
			}

			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return listLT;
	}
	
	public List<TrangThaiLamViec> LayThongTinTrangThaiLamViec(String Manv) {

		String query = "select * from TrangThaiLamViec where MaNV = '" + Manv + "';";
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
