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
import Models.LichSuLamViec;
import Models.LichTrinhCongTac;

public class DAO_Admin_LayLT_LS {
	public DAO_Admin_LayLT_LS() {
		super();
	}
	
	public List<LichTrinhCongTac> LayAllLichTrinhCT()
	{
		String query = "select * from LichTrinhCongTac;";
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

	public List<LichSuLamViec> LayAllLichSuLV() {

		String query = "select * from LichSuLamViec;";
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


}
