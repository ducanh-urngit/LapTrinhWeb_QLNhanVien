<%@page import="Models.QuyetDinh"%>
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
QuyetDinh qd = (QuyetDinh)request.getAttribute("QD");
if(qd == null) qd = new QuyetDinh();
int c = 0;
if(qd.getMaQuyetDinh()== null)
{
	%><form action="ThemQD" method="post">
		<h2>Thêm quyết định</h2><%
}
else
{
	c = 1;
	%><form action="SuaQD" method="post">
		<h2>Sửa quyết định</h2><%
}
%>
	<table>
	  <tr>
	   <td class="label">Mã quyết định</td>
	   <td class="input"><input class="input" type="text" name = "MaQuyetDinh" <%if(c==1){ %> value = "<%=qd.getMaQuyetDinh()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Nội dung</td>
	   <td class="input"><textarea class="input" rows="5" name = "NoiDung" ><%if(c==1){ %><%=qd.getNoiDung()%><%}%></textarea></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Ngày áp dụng</td>
	   <td class="input"><input class="input" type="date" name = "NgayApDung" <%if(c==1){ %> value = "<%=qd.getNgayApDung()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Lần sửa đổi</td>
	   <td class="input"><input class="input" type="text" name = "LanSuaDoi" readonly
	   						<%if(c==1){ %> value = "<%=qd.getLanSuaDoi()%>"<%} else {%>value = "0"<%}%>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Ngày sửa đổi</td>
	   <td class="input"><input class="input" type="date" name = "NgaySuaDoi" readonly
	   							<%if(c==1){ %> value = "<%=qd.getNgaySuaDoi()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Ngày ký</td>
	   <td class="input"><input class="input" type="date" name = "NgayKy" <%if(c==1){ %> value = "<%=qd.getNgayKy()%>"<%} %>></td>
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