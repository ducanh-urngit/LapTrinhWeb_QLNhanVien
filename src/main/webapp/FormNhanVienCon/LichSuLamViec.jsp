<%@page import="java.util.List"%>
<%@page import="Models.LichSuLamViec"%>
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
<h2>Lịch sử làm việc</h2>
<table style = "width: 100%;">
  
  <tr>
    <th>Mã nhân viên</th>
    <th>Ngày bắt đầu</th>
    <th>Mã chi nhánh</th>
    <th>Mã phòng ban</th>
    <th>Mã bộ phận</th>
    <th>Ngày kết thúc</th>
  </tr>
  
<%
List<LichSuLamViec> ListLS = (List<LichSuLamViec>)request.getAttribute("listLSLV");
for (LichSuLamViec ls : ListLS)
{
	%>
	<tr>
		<td><%=ls.getMaNV()%></td>
		<td><%=ls.getNgayBatDau()%></td>
		<td><%=ls.getMaChiNhanh()%></td>
		<td><%=ls.getMaPhongBan()%></td>
		<td><%=ls.getMaBoPhan()%></td>
		<td><%=ls.getNgayKetThuc()%></td>
	</tr>
	<%
}
%>
</table>
</div>
</body>
</html>