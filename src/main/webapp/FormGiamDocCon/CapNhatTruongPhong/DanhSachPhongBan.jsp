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
<h2>Cập nhật trưởng phòng cho phòng ban</h2>
<table style="width:100%;">
  
  <tr>
  	<th></th>
    <th>Mã phòng ban</th>
    <th>Mã chi nhánh</th>
    <th>Tên Phòng ban</th>
    <th>Mã trưởng phòng</th>
    <th>Mã phó trưởng phòng</th>
    
  </tr>
<%
List<PhongBan> PBList = (List<PhongBan>)request.getAttribute("listPB");
for (PhongBan pb : PBList)
{
	%>
	<tr>
		<td style="width: 200px;" class="btnSuaXoa">
	    	<a style="display: block; margin-bottom: 10px;" href="CapNhatTruongPhong?MaPB=<%=pb.getMaPhongBan()%>">Cập nhật trưởng phòng</a>
	    	&nbsp;&nbsp;&nbsp;&nbsp;
	    	<a href="CapNhatPhoPhong?MaPB=<%=pb.getMaPhongBan()%>">Cập nhật phó phòng</a>
	    </td>
		<td><%=pb.getMaPhongBan()%></td>
		<td><%=pb.getMaChiNhanh()%></td>
		<td><%=pb.getTenPhongBan()%></td>
		<td><%=pb.getMaTruongPhong()%></td>
		<td><%=pb.getMaPhoTruongPhong()%></td>
		
	</tr>
	<%
}
%>
</table>
</div>
</body>
</html>