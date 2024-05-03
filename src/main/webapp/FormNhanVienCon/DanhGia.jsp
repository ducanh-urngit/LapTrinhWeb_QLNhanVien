<%@page import="Models.DanhGia"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styleFormCon.css">
</head>
<body>
<div class = "TongThe">
<h2>Khen thưởng - Kỷ luật</h2>
<table style="width: 150%;">
  
  <tr>
    <th>Mã quyết định</th>
    <th>Mã nhân viên</th>
    <th>Hình thức</th>
    <th style="width: 50%;">Nội dung</th>
    <th>Ngày ký</th>
  </tr>
<%
List<DanhGia> list = (List<DanhGia>)request.getAttribute("listDG");
for (DanhGia dg : list)
{
	%>
	<tr>
		<td><%=dg.getMaQuyetDinh()%></td>
		<td><%=dg.getMaNhanVien()%></td>
		<td><%=dg.getHinhThuc()%></td>
		<td><%=dg.getNoiDung()%></td>
		<td><%=dg.getNgayKy()%></td>
	</tr>
	<%
}
%>
</table>
</div>
</body>
</html>