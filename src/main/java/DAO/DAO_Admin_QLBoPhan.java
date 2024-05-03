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

public class DAO_Admin_QLBoPhan {
	public DAO_Admin_QLBoPhan() {
		super();
	}
	
	public List<BoPhan> SelectAllBoPhan() {
		List<BoPhan> list = new ArrayList<>();
		String query = "select * from BoPhanPhongBan;";

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
	
	public BoPhan LayBP(String Mabp) {
		String query = "select * from BoPhanPhongBan where MaBoPhan = '" + Mabp + "';";
		BoPhan bp = null;
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String MaBP = rs.getString("MaBoPhan");
				String MaPB = rs.getString("MaPhongBan");
				String TenBP = rs.getString("TenBoPhan");
				bp = new BoPhan(MaBP, MaPB, TenBP);
			}
			if (bp == null)
				bp = new BoPhan();

			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return bp;
	}
	
	public int ThemBP(String MaBP, String MaPB, String TenBP) {
		int c = 0;
		String query = "insert into BoPhanPhongBan values (?, ? ,?);";

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, MaBP);
			if (MaPB == "")
				preparedStatement.setNull(2, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(2, MaPB);
			preparedStatement.setString(3, TenBP);
			
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public int SuaBP(String MaBP, String MaPB, String TenBP) {
		int c = 0;
		String query = "update BoPhanPhongBan set MaPhongBan = ?, TenBoPhan = ?"
					+ " where MaBoPhan = ?;" ;

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			
			if (MaPB.isEmpty() || MaPB.equals("null"))
				preparedStatement.setNull(1, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(1, MaPB);
			preparedStatement.setString(2, TenBP);
			preparedStatement.setString(3, MaBP);
			
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public int XoaBP(String MaBP) {
		int c = 0;
		String query = "delete from BoPhanPhongBan where MaBoPhan = '"+MaBP+"';"; 
		
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
