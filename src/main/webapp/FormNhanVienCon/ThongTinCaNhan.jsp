<%@page import="Models.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
form{
	position: absolute;
	height: 100%;
	width: 100%;
}
table{
	width: 100%;
	
}

th, td {
  padding-top: 10px;
  padding-bottom: 20px;
}

table, th, td {
  border:none; 
}

</style>
</head>
<body>
<%
	NhanVien nv = (NhanVien)request.getAttribute("NV");
	if (nv == null)
		nv = new NhanVien();
%>
<form action="SuaThongTinCaNhan" method="post">
	<table>
	  <tr>
	   <td><table>
	   			<tr>
	   				<td>Mã Nhân viên</td>
	   				<td><input type="text" name = "MaNV" readonly value="<%=nv.getMaNV()%>"></td>
	   			</tr>
	   			<tr>
	   				<td>Họ tên</td>
	   				<td><input type="text" name = "HoTen" value="<%=nv.getHoTen()%>"></td>
	   			</tr>
	   			<tr>
	   				<td>Ngày sinh</td>
	   				<td><input type="date" name = "NgaySinh" value="<%=nv.getNgaySinh()%>"></td>
	   			</tr>
	   			<tr>
	   				<td>Giới tính</td>
	   				<td><input type="text" name = "GioiTinh" value="<%=nv.getGioiTinh()%>"></td>
	   			</tr>
	   			<tr>
	   				<td>Dân tộc</td>
	   				<td><input type="text" name = "DanToc" value="<%=nv.getDanToc()%>"></td>
	   			</tr>
	   			<tr>
	   				<td>Tôn giáo</td>
	   				<td><input type="text" name = "TonGiao" value="<%=nv.getTonGiao()%>"></td>
	   			</tr>
	   			
	   		</table>
	   	</td>
	    <td>
	    	<table>
	   			<tr>
	   				<td>CCCD</td>
	   				<td><input type="text" name = "CCCD" value="<%=nv.getCCCD()%>"></td>
	   			</tr>
	   			<tr>
	   				<td>Ngày cấp</td>
	   				<td><input type="date" name = "NgayCap" value="<%=nv.getNgayCap()%>"></td>
	   			</tr>
	   			<tr>
	   				<td>Nơi cấp</td>
	   				<td><input type="text" name = "NoiCap" value="<%=nv.getNoiCap()%>"></td>
	   			</tr>
	   			<tr>
	   				<td>Địa chỉ</td>
	   				<td><textarea style="resize: none" rows="3" name = "DiaChi"><%=nv.getDiaChi()%></textarea></td>
	   			</tr>
	   			<tr>
	   				<td>Email</td>
	   				<td><input type="text" name = "Email" value="<%=nv.getEmail()%>"></td>
	   			</tr>
	   			<tr>
	   				<td>SĐT</td>
	   				<td><input type="text" name = "SDT" value="<%=nv.getSDT()%>"></td>
	   			</tr>
	   			
	   		</table>
		</td>
		<td>
	    	<table>
	   			<tr>
	   				<td>Chức vụ</td>
	   				<td><input type="text" name = "ChucVu" readonly value="<%=nv.getChucVu()%>"></td>
	   			</tr>
	   			<tr>
	   				<td>Trình độ</td>
	   				<td><input type="text" name = "TrinhDo" readonly value="<%=nv.getTringDo()%>"></td>
	   			</tr>
	   			<tr>
	   				<td>Mã chi nhánh</td>
	   				<td><input type="text" name = "MaChiNhanh" readonly value="<%=nv.getMaChiNhanh()%>"></td>
	   			</tr>
	   			<tr>
	   				<td>Mã phòng ban</td>
	   				<td><input type="text" name = "MaPhongBan" readonly value="<%=nv.getMaPhongBan()%>"></td>
	   			</tr>
	   			<tr>
	   				<td>Mã bộ phận</td>
	   				<td><input type="text" name = "MaBoPhan" readonly value="<%=nv.getMaBoPhan()%>"></td>
	   			</tr>
	   			<tr>
	   				<td>Lương</td>
	   				<td><input type="text" name = "Luong" readonly value="<%=nv.getLuong()%>"></td>
	   			</tr>
	   			
	   		</table>
		</td>
	  </tr>
	  
	  <tr>
	  	<td>
	  		<button style="width: 90px; margin-left: 100px;" type = "submit" >Lưu</button>
	  	</td>
	  	<td>
	  		<a href="newPassword.jsp">Thay đổi mật khẩu</a>
	  	</td>
	  </tr>
	</table>
</form>
</body>
</html>