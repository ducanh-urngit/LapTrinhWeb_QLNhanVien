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
	if(VaiTro.equals("Truong phong"))
		{%><jsp:forward page="formTruongPhong.jsp" /><%}
}
%>
<title>Cập nhật Lịch Sử</title>
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
<%String MaNV = (String)request.getAttribute("MaNV");
String MaCN = (String)request.getAttribute("MaCN");%>
<form action="ThucHienCapNhatLSLV" method="post">
	<h2>Cập nhật lịch sử làm việc</h2>
	<table>
	  <tr>
	   <td class="label">Mã Nhân viên</td>
	   <td class="input"><input class="input" type="text" name = "MaNhanVien" readonly value = "<%=MaNV%>"></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Mã chi nhánh</td>
	   <td class="input"><input class="input" type="text" name = "MaChiNhanh" readonly value = "<%=MaCN%>"></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Mã phòng ban</td>
	   <td class="input"><input class="input" type="text" name = "MaPhongBan" ></td>
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