<%@page import="Models.ChiNhanh"%>
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
ChiNhanh cn = (ChiNhanh)request.getAttribute("CN");
if(cn == null) cn = new ChiNhanh();
int c = 0;
if(cn.getMaChiNhanh() == null)
{
	%><form action="ThemCN" method="post">
		<h2>Thêm chi nhánh</h2><%
}
else
{
	c = 1;
	%><form action="SuaCN" method="post">
		<h2>Sửa chi nhánh</h2><%
}
%>
	<table>
	  <tr>
	   <td class="label">Mã chi nhánh</td>
	   <td class="input"><input class="input" type="text" name = "MaChiNhanh"<%if(c==1){ %> value = "<%=cn.getMaChiNhanh()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Tên chi nhánh</td>
	   <td class="input"><input class="input" type="text" name = "TenChiNhanh"<%if(c==1){ %> value = "<%=cn.getTenChiNhanh()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Địa chỉ</td>
	   <td class="input"><textarea class="input" rows="5" name = "DiaChi"><%if(c==1){ %><%=cn.getDiaChi()%><%} %></textarea></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Mã giám đốc</td>
	   <td class="input"><input class="input" type="text" name = "MaGiamDoc"<%if(c==1){ %> value = "<%=cn.getMaGiamDoc()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Mã phó giám đốc</td>
	   <td class="input"><input class="input" type="text" name = "MaPhoGiamDoc"<%if(c==1){ %> value = "<%=cn.getMaPhoGiamDoc()%>"<%} %>></td>
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