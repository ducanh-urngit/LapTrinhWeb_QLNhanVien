<%@page import="Models.BoPhan"%>
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
<h2>Quản lý bộ phận</h2>
<table style="width: 100%;">
  
  <tr>
  	<th></th>
    <th>Mã bộ phận</th>
    <th>Mã phòng ban</th>
    <th>Tên bộ phận</th>
  </tr>
<%
List<BoPhan> BPList = (List<BoPhan>)request.getAttribute("listBP");
for (BoPhan bp : BPList)
{
	%>
	<tr>
		<td class="btnSuaXoa">
	    	<a href="CapNhatTV?MaBP=<%=bp.getMaBoPhan()%>">Cập nhật thành viên</a>
	    </td>
		<td><%=bp.getMaBoPhan()%></td>
		<td><%=bp.getMaPhongBan()%></td>
		<td><%=bp.getTenBoPhan()%></td>
	</tr>
	<%
}
%>
</table>
</div>
</body>
</html>