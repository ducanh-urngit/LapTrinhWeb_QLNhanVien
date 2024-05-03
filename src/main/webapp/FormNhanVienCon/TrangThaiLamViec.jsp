<%@page import="java.util.List"%>
<%@page import="Models.TrangThaiLamViec"%>
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
<h2>Trạng thái làm việc</h2>
<table style="width: 150%;">
  
  <tr>
  	<th>Mã Nhân viên</th>
    <th>Mã quyết định</th>
    <th>Ngày bắt đầu</th>
    <th>Ngày kết thúc</th>
    <th style="width: 50%;">Nội dung</th>
    <th>Ngày ký</th>
  </tr>
<%
List<TrangThaiLamViec> TTList = (List<TrangThaiLamViec>)request.getAttribute("listTTLV");
for (TrangThaiLamViec tt : TTList)
{
	%>
	<tr>
	 	<td><%=tt.getMaNV()%></td>
		<td><%=tt.getMaQD()%></td>
		<td><%=tt.getNgayBatDau()%></td>
		<td><%=tt.getNgayKetThuc()%></td>
		<td><%=tt.getNoiDung()%></td>
		<td><%=tt.getNgayKy()%></td>
	</tr>
	<%
}
%>
</table>
</div>
</body>
</html>