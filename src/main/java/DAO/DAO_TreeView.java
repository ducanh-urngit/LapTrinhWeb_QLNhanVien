package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.JDBCUtil;
import JDBCUtil.ShowSQLException;
import Models.BoPhan;
import Models.ChiNhanh;
import Models.PhongBan;

public class DAO_TreeView {
	public DAO_TreeView() {
		super();
	}
	
	public List<ChiNhanh> LayDSChiNhanh() {
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
	
	public List<PhongBan> LayDSPhongBan(String Macn) {
		List<PhongBan> list = new ArrayList<>();
		String query = "select * from PhongBan where MaChiNhanh = '"+Macn+"';";

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
	
	public List<BoPhan> LayDSBoPhan( String Mapb) {
		List<BoPhan> list = new ArrayList<>();
		String query = "select * from BoPhanPhongBan where MaPhongBan = '"+Mapb+"';";

		try (Connection connection = JDBCUtil.GetConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String MaBP = rs.getString("MaBoPhan");
				String MaPB = rs.getString("MaPhongBan");
				String TenBP = rs.getString("TenBoPhan");
				BoPhan bp = new BoPhan(MaBP, MaPB, TenBP);
				list.add(bp);
			}
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return list;
	}
}
