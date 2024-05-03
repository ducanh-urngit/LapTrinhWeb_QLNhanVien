<%@page import="Models.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
NhanVien nv = (NhanVien)session.getAttribute("NV");
if(nv == null)
{
	%> <jsp:forward page="formLogin.jsp" /> <%
}
else
{
	String VaiTro = nv.getChucVu();
	if(VaiTro.equals("Nhan vien"))
		{%><jsp:forward page="formNhanvien.jsp" /><%}
}
%>
<title>Đánh giá nhân viên</title>
<style>
body{
	display: flex;
	justify-content: center;
	align-items: center;
}
table{
	width: 530px;
}

th, td {
  padding-top: 10px;
  padding-bottom: 20px;
}

table, th, td {
  /* border:1px solid black;  */
  border:none; 
}

.label{
	width: 130px;
} 

.input{
	display: flex;
	width: 400px;
}
</style>
</head>
<body>
<%String MaNV = (String)request.getAttribute("MaNV"); %>
<form action="ThucHienDanhGia" method="post">
	<h2>Đánh giá nhân viên</h2>
	<table>
	  <tr>
	   <td class="label">Mã quyết định</td>
	   <td class="input"><input class="input" type="text" name = "MaQuyetDinh"></td>
	  </tr>
	
	  <tr>
	   <td class="label">Mã Nhân viên</td>
	   <td class="input"><input class="input" type="text" name = "MaNhanVien" readonly value = "<%=MaNV%>"></td>
	  </tr>
	  
	  <tr>
		<td class="label">Hình thức</td>
		<td><select name = "HinhThuc">
			<option value = "Khen thuong">Khen thưởng</option>
			<option value = "Ky luat">Kỷ luật</option>
			</select>
		</td>
	  </tr>
	  
	  <tr>
	   <td class="label">Nội dung</td>
	   <td class="input"><textarea class="input" rows ="5" name = "NoiDung"></textarea></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Ngày Ký</td>
	   <td class="input"><input class="input" type="date" name = "NgayKy" ></td>
	  </tr>
	  
	  <tr>
	  	<td >
	  		<button style="width: 90px; margin-left: 100px;" type = "submit">Lưu</button>
	  	</td>
	  </tr>
	</table>
</form>
</body>
</html>