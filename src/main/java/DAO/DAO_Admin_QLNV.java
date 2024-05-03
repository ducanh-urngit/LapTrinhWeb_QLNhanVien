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

public class DAO_Admin_QLNV {
	public DAO_Admin_QLNV() {
		super();
	}
	
	public NhanVien LayNV(String Manv) {
		String query = "select * from NhanVien where MaNV = '"+Manv+"';";
		NhanVien nv = null;
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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
				nv = new NhanVien(MaNV, HoTen, NgaySinh, GioiTinh, DanToc, TonGiao, CCCD, NgayCap, NoiCap,
						DiaChi, Email, SDT, ChucVu, TrinhDo, MaChiNhanh, MaPhongBan, MaBoPhan, Luong);
			}
			if(nv == null)
				nv = new NhanVien();

			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return nv;
	}
	
	public List <NhanVien> SelectAllNV() {
		List < NhanVien > listNV = new ArrayList < > ();
		String query = "select * from NhanVien;";
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
	
	public int XoaNV(String MaNV) {
		int c = 0;
		String query = "delete from NhanVien where MaNV = '"+MaNV+"';"; 
		
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public int ThemNV(String MaNV, String HoTen, Date NgaySinh, String GioiTinh, String DanToc, String TonGiao, String CCCD, 
						Date NgayCap, String NoiCap, String DiaChi, String Email, String SDT, String ChucVu, String TrinhDo,
						String MaChiNhanh, String MaPhongBan, String MaBoPhan, int Luong) {
		int c = 0;
		String query = "insert into NhanVien values (?, ? ,? ,?,?, ? ,? ,?,?, ? ,? ,?,?, ? ,? ,?,?, ? );" ;
		
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, MaNV);
			preparedStatement.setString(2, HoTen);
			preparedStatement.setDate(3, NgaySinh);
			preparedStatement.setString(4, GioiTinh);
			preparedStatement.setString(5, DanToc);
			preparedStatement.setString(6, TonGiao);
			preparedStatement.setString(7, CCCD);
			preparedStatement.setDate(8, NgayCap);
			preparedStatement.setString(9, NoiCap);
			preparedStatement.setString(10, DiaChi);
			preparedStatement.setString(11, Email);
			preparedStatement.setString(12, SDT);
			preparedStatement.setString(13, ChucVu);
			preparedStatement.setString(14, TrinhDo);
			if(MaChiNhanh == "")
				preparedStatement.setNull(15, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(15, MaChiNhanh);
			if(MaPhongBan == "")
				preparedStatement.setNull(16, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(16, MaPhongBan);
			if(MaBoPhan == "")
				preparedStatement.setNull(17, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(17, MaBoPhan);
			preparedStatement.setInt(18, Luong);
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
	
	public int SuaNV(String MaNV, String HoTen, Date NgaySinh, String GioiTinh, String DanToc, String TonGiao, String CCCD, 
			Date NgayCap, String NoiCap, String DiaChi, String Email, String SDT, String ChucVu, String TrinhDo,
			String MaChiNhanh, String MaPhongBan, String MaBoPhan, int Luong) {
		
		int c = 0;
		String query = "update NhanVien set HoTen = ?, NgaySinh = ?, GioiTinh = ?, DanToc = ?, TonGiao = ?, CCCD = ?, "
				+ "NgayCap = ?, NoiCap = ?, DiaChi = ?, Email = ?, SDT = ?, ChucVu = ?, TrinhDo = ?, MaChiNhanh = ?, "
				+ "MaPhongBan = ?, MaBoPhan =  ?, Luong = ? where MaNV = ?;" ;
		
		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, HoTen);
			preparedStatement.setDate(2, NgaySinh);
			preparedStatement.setString(3, GioiTinh);
			preparedStatement.setString(4, DanToc);
			preparedStatement.setString(5, TonGiao);
			preparedStatement.setString(6, CCCD);
			preparedStatement.setDate(7, NgayCap);
			preparedStatement.setString(8, NoiCap);
			preparedStatement.setString(9, DiaChi);
			preparedStatement.setString(10, Email);
			preparedStatement.setString(11, SDT);
			preparedStatement.setString(12, ChucVu);
			preparedStatement.setString(13, TrinhDo);
			if(MaChiNhanh.isEmpty() || MaChiNhanh.equals("null"))
				preparedStatement.setNull(14, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(14, MaChiNhanh);
			if(MaPhongBan.isEmpty() || MaPhongBan.equals("null"))
				preparedStatement.setNull(15, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(15, MaPhongBan);
			if(MaBoPhan.isEmpty() || MaBoPhan.equals("null"))
				preparedStatement.setNull(16, java.sql.Types.VARCHAR);
			else
				preparedStatement.setString(16, MaBoPhan);
			preparedStatement.setInt(17, Luong);
			preparedStatement.setString(18, MaNV);
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}
}
