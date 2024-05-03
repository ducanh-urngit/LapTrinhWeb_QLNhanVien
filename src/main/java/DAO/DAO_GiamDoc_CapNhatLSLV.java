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
import Models.NhanVien;

public class DAO_GiamDoc_CapNhatLSLV {
	public DAO_GiamDoc_CapNhatLSLV() {
		super();
	}
	
	public List <NhanVien> SelectNhanVienTrongCN(String Macn) {
		List < NhanVien > listNV = new ArrayList < > ();
		String query = "select * from NhanVien where MaChiNhanh = '"+Macn+"';";
        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtil.GetConnection();

            // Step 2:Create a statement using connection object

            PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	String MaNV = rs.getString("MaNV");
				String HoTen = rs.getString("HoTen");
				Date NgaySinh = rs.getDate("NgaySinh");
				String GioiTinh = rs.getString("GioiTinh");
				String DanToc = rs.getString("DanToc");
				String TonGiao = rs.getString("TonGiao");
				String CCCD = rs.getString("CCCD");
				Date NgayCap = rs.getDate("NgayCap");
				String NoiCap = rs.getString("NoiCap");
				String DiaChi = rs.getString("DiaChi");
				String Email = rs.getString("Email");
				String SDT = rs.getString("SDT");
				String ChucVu = rs.getString("ChucVu");
				String TrinhDo = rs.getString("TrinhDo");
				String MaChiNhanh = rs.getString("MaChiNhanh");
				String MaPhongBan = rs.getString("MaPhongBan");
				String MaBoPhan = rs.getString("MaBoPhan");
				int Luong = rs.getInt("Luong");
				NhanVien nv = new NhanVien(MaNV, HoTen, NgaySinh, GioiTinh, DanToc, TonGiao, CCCD, NgayCap, NoiCap,
						DiaChi, Email, SDT, ChucVu, TrinhDo, MaChiNhanh, MaPhongBan, MaBoPhan, Luong);
                listNV.add(nv);
            }
            JDBCUtil.CloseConnection(connection);
        } catch (SQLException e) {
        	ShowSQLException.printSQLException(e);
        }
        return listNV;
	}
	
	public int CapNhatLSLV(String MaNV, NhanVien nv, String MaPBMoi, Date NgayChuyen) {
		int c = 0;
		String MaCN = nv.getMaChiNhanh();
		String query = "update LichSuLamViec "
					 + "set NgayKetThuc = ? "
					 + "where MaNV = ? and NgayKetThuc is null;";
		String query2 = "update NhanVien "
				 + "set MaBoPhan = null, MaPhongBan = ? "
				 + "where MaNV = ? ;";
		String query3 = "insert into LichSuLamViec values (?,?,?,?,null,null)";

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
				PreparedStatement preparedStatement3 = connection.prepareStatement(query3)) {
			preparedStatement.setString(1, MaNV);
			preparedStatement.setDate(2, NgayChuyen);
			c = preparedStatement.executeUpdate();
			
			preparedStatement2.setString(1, MaPBMoi);
			preparedStatement2.setString(2, MaNV);
			c = preparedStatement2.executeUpdate();
			
			preparedStatement3.setString(1, MaNV);
			preparedStatement3.setDate(2, NgayChuyen);
			preparedStatement3.setString(3, MaCN);
			preparedStatement3.setString(4, MaPBMoi);
			c = preparedStatement3.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public int ChoNghiViec(String MaNV, Date NgayChoNghi) {
		int c = 0;
		
		String query = "update LichSuLamViec "
					 + "set NgayKetThuc = ? "
					 + "where MaNV = ? and NgayKetThuc is null;";
		String query2 = "update NhanVien "
				 + "set MaChiNhanh = null, MaPhongBan = null, MaBoPhan = null, Luong = null "
				 + "where MaNV = ? ;";

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				PreparedStatement preparedStatement2 = connection.prepareStatement(query2)) {
			preparedStatement.setDate(1, NgayChoNghi);
			preparedStatement.setString(2, MaNV);
			c = preparedStatement.executeUpdate();
			
			preparedStatement2.setString(1, MaNV);
			c = preparedStatement2.executeUpdate();
			
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
}
