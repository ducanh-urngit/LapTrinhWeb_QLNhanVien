<%@page import="Models.HopDong"%>
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
<h2>Quản lý hợp đồng</h2>
<a href = "<%=request.getContextPath()%>/ThemHopDong"><input class = "btnThem" type="button" value="Thêm hợp đồng"></a>
<table style="width:150%;">
  
  <tr>
  	<th></th>
    <th>Mã hợp đồng</th>
    <th style="width: 50%;">Nội dung</th>
    <th>Ngày áp dụng</th>
    <th>Lần sửa đổi</th>
    <th>Ngày sửa đổi</th>
    <th>Ngày ký</th>
  </tr>
<%
List<HopDong> HDList = (List<HopDong>)request.getAttribute("listHD");
for (HopDong hd : HDList)
{
	%>
	<tr>
		<td class="btnSuaXoa">
	    	<a href="SuaHopDong?MaHD=<%=hd.getMaHopDong()%>">Sửa</a>
	    	&nbsp;&nbsp;&nbsp;&nbsp;
	    	<a class="btnXoa" href="XoaHD?MaHD=<%=hd.getMaHopDong()%>">Xoá</a>
	    </td>
		<td><%=hd.getMaHopDong()%></td>
		<td><%=hd.getNoiDung()%></td>
		<td><%=hd.getNgayApDung()%></td>
		<td><%=hd.getLanSuaDoi()%></td>
		<td><%=hd.getNgaySuaDoi()%></td>
		<td><%=hd.getNgayKy()%></td>
	</tr>
	<%
}
%>
</table>
</div>
</body>
</html>