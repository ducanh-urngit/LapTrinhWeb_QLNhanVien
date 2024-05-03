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
	if(VaiTro.equals("Admin"))
		{%><jsp:forward page="formAdmin.jsp" /><%}
		
	if(VaiTro.equals("Truong phong"))
		{%><jsp:forward page="formTruongPhong.jsp" /><%}
	
	if(VaiTro.equals("Nhan vien"))
		{%><jsp:forward page="formNhanvien.jsp" /><%}
}
%>
<title>Cập nhật trưởng phòng</title>
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
int c = 1;
String mess = (String) request.getAttribute("message");
if(mess == null)
	{%><form action="CapNhatTPPB" method="post">
		<h2>Cập nhật trưởng phòng cho phòng ban</h2><%}
else
	{%><form action="CapNhatPPPB" method="post">
		<h2>Cập nhật phó trưởng phòng cho phòng ban</h2><%}
%>
	<table>
	
	  <tr>
	   <td class="label">Mã Nhân viên</td>
	   <td class="input"><input class="input" type="text" name = "MaNhanVien"></td>
	  </tr>
	
	  <tr>
	   <td class="label">Mã phòng ban</td>
	   <td class="input"><input class="input" type="text" name = "MaPhongBan" readonly <%if(c==1){ %> value = "<%=pb.getMaPhongBan()%>"<%} %>></td>
	  </tr>
	
	  <tr>
	   <td class="label">Mã chi nhánh</td>
	   <td class="input"><input class="input" type="text" name = "MaChiNhanh" readonly <%if(c==1){ %> value = "<%=pb.getMaChiNhanh()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Tên phòng ban</td>
	   <td class="input"><input class="input" type="text" name = "TenPhongBan" readonly <%if(c==1){ %> value = "<%=pb.getTenPhongBan()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Mã trưởng phòng</td>
	   <td class="input"><input class="input" type="text" name = "MaTruongPhong" readonly <%if(c==1){ %> value = "<%=pb.getMaTruongPhong()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Mã phó trưởng phòng</td>
	   <td class="input"><input class="input" type="text" name = "MaPhoTruongPhong" readonly <%if(c==1){ %> value = "<%=pb.getMaPhoTruongPhong()%>"<%} %>></td>
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