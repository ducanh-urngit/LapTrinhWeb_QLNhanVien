<%@page import="Models.NhanVien"%>
<%@page import="Models.HopDong"%>
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
HopDong hd = (HopDong)request.getAttribute("HD");
if(hd == null) hd = new HopDong();
int c = 0;
if(hd.getMaHopDong()== null)
{
	%><form action="ThemHD" method="post">
		<h2>Thêm hợp đồng</h2><%
}
else
{
	c = 1;
	%><form action="SuaHD" method="post">
		<h2>Sửa hợp đồng</h2><%
}
%>
	<table>
	  <tr>
	   <td class="label">Mã hợp đồng</td>
	   <td class="input"><input class="input" type="text" name = "MaHopDong" <%if(c==1){ %> value = "<%=hd.getMaHopDong()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Nội dung</td>
	   <td class="input"><textarea class="input" rows="5" name = "NoiDung" ><%if(c==1){ %><%=hd.getNoiDung()%><%}%></textarea></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Ngày áp dụng</td>
	   <td class="input"><input class="input" type="date" name = "NgayApDung" <%if(c==1){ %> value = "<%=hd.getNgayApDung()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Lần sửa đổi</td>
	   <td class="input"><input class="input" type="text" name = "LanSuaDoi" readonly
	   						<%if(c==1){ %> value = "<%=hd.getLanSuaDoi()%>"<%} else {%>value = "0"<%}%>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Ngày sửa đổi</td>
	   <td class="input"><input class="input" type="date" name = "NgaySuaDoi" readonly
	   							<%if(c==1){ %> value = "<%=hd.getNgaySuaDoi()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Ngày ký</td>
	   <td class="input"><input class="input" type="date" name = "NgayKy" <%if(c==1){ %> value = "<%=hd.getNgayKy()%>"<%} %>></td>
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