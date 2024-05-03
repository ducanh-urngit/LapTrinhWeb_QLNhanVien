<%@page import="Models.LichTrinhCongTac"%>
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
<h2>Lịch trình công tác</h2>
<table style="width: 150%;">
  
  <tr>
  	<th>Mã Nhân viên</th>
    <th>Mã quyết định</th>
    <th>Ngày bắt đầu</th>
    <th>Ngày kết thúc</th>
    <th>Địa điểm</th>
    <th style="width: 50%;">Nội dung</th>
    <th>Ngày ký</th>
  </tr>
<%
List<LichTrinhCongTac> LTList = (List<LichTrinhCongTac>)request.getAttribute("listLTCT");
for (LichTrinhCongTac lt : LTList)
{
	%>
	<tr>
	 	<td><%=lt.getMaNV()%></td>
		<td><%=lt.getMaQD()%></td>
		<td><%=lt.getNgayBatDau()%></td>
		<td><%=lt.getNgayKetThuc()%></td>
		<td><%=lt.getDiaDiem()%></td>
		<td><%=lt.getNoiDung()%></td>
		<td><%=lt.getNgayKy()%></td>
	</tr>
	<%
}
%>
</table>
</div>
</body>
</html>