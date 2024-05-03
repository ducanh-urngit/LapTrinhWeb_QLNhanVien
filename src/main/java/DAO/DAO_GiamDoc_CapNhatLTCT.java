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

public class DAO_GiamDoc_CapNhatLTCT {
	public DAO_GiamDoc_CapNhatLTCT() {
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
	
	public int CapNhatLTCT(String MaNV, String MaQD, Date NgayBatDau, Date NgayKetThuc, String DiaDiem, String NoiDung, Date NgayKy) {
		int c = 0;
		String query = "insert into LichTrinhCongTac values (?, ? , ?, ? ,?,?, ?);";

		try (Connection connection = JDBCUtil.GetConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, MaNV);
			preparedStatement.setString(2, MaQD);
			preparedStatement.setDate(3, NgayBatDau);
			preparedStatement.setDate(4, NgayKetThuc);
			preparedStatement.setString(5, DiaDiem);
			preparedStatement.setString(6, NoiDung);
			preparedStatement.setDate(7, NgayKy);
			
			c = preparedStatement.executeUpdate();
			JDBCUtil.CloseConnection(connection);
		} catch (SQLException e) {
			ShowSQLException.printSQLException(e);
		}
		return c;
	}


}
