<%@page import="Models.PhongBan"%>
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
<h2>Quản lý Phòng ban</h2>
<a href = "<%=request.getContextPath()%>/ThemPhongBan"><input class = "btnThem" type="button" value="Thêm Phòng ban"></a>
<table style="width:100%;">
  
  <tr>
    <th>Mã phòng ban</th>
    <th>Mã chi nhánh</th>
    <th>Tên Phòng ban</th>
    <th>Mã trưởng phòng</th>
    <th>Mã phó trưởng phòng</th>
    <th></th>
  </tr>
<%
List<PhongBan> PBList = (List<PhongBan>)request.getAttribute("listPB");
for (PhongBan pb : PBList)
{
	%>
	<tr>
		<td><%=pb.getMaPhongBan()%></td>
		<td><%=pb.getMaChiNhanh()%></td>
		<td><%=pb.getTenPhongBan()%></td>
		<td><%=pb.getMaTruongPhong()%></td>
		<td><%=pb.getMaPhoTruongPhong()%></td>
		<td class="btnSuaXoa">
	    	<a href="SuaPhongBan?MaPB=<%=pb.getMaPhongBan()%>">Sửa</a>
	    	&nbsp;&nbsp;&nbsp;&nbsp;
	    	<a class="btnXoa" href="XoaPB?MaPB=<%=pb.getMaPhongBan()%>">Xoá</a>
	    </td>
	</tr>
	<%
}
%>
</table>
</div>
</body>
</html>