package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import JDBCUtil.JDBCUtil;
import JDBCUtil.ShowSQLException;

public class DAO_GiamDoc_KyHopDong {
	public DAO_GiamDoc_KyHopDong() {
		super();
	}
	
	public int KyHopDong(String MaHD, String MaNV, Date NgayKy) {
		int c = 0;
		String query = "insert into ThoaThuanHopDong values (?, ? , ?);";

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, MaHD);
			preparedStatement.setString(2, MaNV);
			preparedStatement.setDate(3, NgayKy);
			
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public int CapNhatLichSuSauKyHD(String MaNV, Date NgayKy, String MaCN, String MaPB, String Luong) {
		int c = 0;
		String query = "UPDATE NhanVien "
				+ "SET MaChiNhanh = ?, MaPhongBan = ? , Luong = ? "
				+ "WHERE MaNV = ?;";
		String query2 = "insert into LichSuLamViec values('"+MaNV+"', '"+NgayKy+"', '"+MaCN+"', '"+MaPB+"', null, null)";

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				PreparedStatement preparedStatement2 = connection.prepareStatement(query2)) {
			preparedStatement.setString(1, MaCN);
			preparedStatement.setString(2, MaPB);
			preparedStatement.setInt(3, Integer.parseInt(Luong));
			preparedStatement.setString(4, MaNV);
			
			c = preparedStatement.executeUpdate();
			c = preparedStatement2.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}

}
