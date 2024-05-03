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
<a href = "<%=request.getContextPath()%>/ThemBoPhan"><input class = "btnThem" type="button" value="Thêm bộ phận"></a>
<table style="width: 100%;">
  
  <tr>
    <th>Mã bộ phận</th>
    <th>Mã phòng ban</th>
    <th>Tên bộ phận</th>
    <th></th>
  </tr>
<%
List<BoPhan> BPList = (List<BoPhan>)request.getAttribute("listBP");
for (BoPhan bp : BPList)
{
	%>
	<tr>
		<td><%=bp.getMaBoPhan()%></td>
		<td><%=bp.getMaPhongBan()%></td>
		<td><%=bp.getTenBoPhan()%></td>
		<td class="btnSuaXoa">
	    	<a href="SuaBoPhan?MaBP=<%=bp.getMaBoPhan()%>">Sửa</a>
	    	&nbsp;&nbsp;&nbsp;&nbsp;
	    	<a class="btnXoa" href="XoaBP?MaBP=<%=bp.getMaBoPhan()%>">Xoá</a>
	    </td>
	</tr>
	<%
}
%>
</table>
</div>
</body>
</html>