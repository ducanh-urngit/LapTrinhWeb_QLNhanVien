<%@page import="Models.PhongBan"%>
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
	%> 	<jsp:forward page="formLogin.jsp" /> <%
}
else
{
	String VaiTro = nv.getChucVu();
	if(VaiTro.equals("Giam doc"))
		{%><jsp:forward page="formGiamDoc.jsp" /><%}
		
	if(VaiTro.equals("Truong phong"))
		{%><jsp:forward page="formTruongPhong.jsp" /><%}
	
	if(VaiTro.equals("Nhan vien"))
		{%><jsp:forward page="formNhanvien.jsp" /><%}
}
%>
<title>Thêm</title>
<link rel="stylesheet" href="../../css/styleFormThem.css">
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
<%
PhongBan pb = (PhongBan)request.getAttribute("PB");
if(pb == null) pb = new PhongBan();
int c = 0;
if(pb.getMaPhongBan() == null)
{
	%><form action="ThemPB" method="post">
		<h2>Thêm phòng ban</h2><%
}
else
{
	c = 1;
	%><form action="SuaPB" method="post">
		<h2>Sửa phòng ban</h2><%
}
%>
	<table>
	  <tr>
	   <td class="label">Mã phòng ban</td>
	   <td class="input"><input class="input" type="text" name = "MaPhongBan"<%if(c==1){ %> value = "<%=pb.getMaPhongBan()%>"<%} %>></td>
	  </tr>
	
	  <tr>
	   <td class="label">Mã chi nhánh</td>
	   <td class="input"><input class="input" type="text" name = "MaChiNhanh"<%if(c==1){ %> value = "<%=pb.getMaChiNhanh()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Tên phòng ban</td>
	   <td class="input"><input class="input" type="text" name = "TenPhongBan"<%if(c==1){ %> value = "<%=pb.getTenPhongBan()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Mã trưởng phòng</td>
	   <td class="input"><input class="input" type="text" name = "MaTruongPhong"<%if(c==1){ %> value = "<%=pb.getMaTruongPhong()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Mã phó trưởng phòng</td>
	   <td class="input"><input class="input" type="text" name = "MaPhoTruongPhong"<%if(c==1){ %> value = "<%=pb.getMaPhoTruongPhong()%>"<%} %>></td>
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