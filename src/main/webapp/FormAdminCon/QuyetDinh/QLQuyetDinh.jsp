<%@page import="Models.QuyetDinh"%>
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
<h2>Quản lý quyết định</h2>
<a href = "<%=request.getContextPath()%>/ThemQuyetDinh"><input class = "btnThem" type="button" value="Thêm quyết định" ></a>
<table style="width:150%">
  
  <tr>
  	<th></th>
    <th>Mã quyết định</th>
    <th style="width: 50%;">Nội dung</th>
    <th>Ngày áp dụng</th>
    <th>Lần sửa đổi</th>
    <th>Ngày sửa đổi</th>
    <th>Ngày ký</th>
  </tr>
<%
List<QuyetDinh> QDList = (List<QuyetDinh>)request.getAttribute("listQD");
for (QuyetDinh qd : QDList)
{
	%>
	<tr>
		<td class="btnSuaXoa">
	    	<a href="SuaQuyetDinh?MaQD=<%=qd.getMaQuyetDinh()%>">Sửa</a>
	    	&nbsp;&nbsp;&nbsp;&nbsp;
	    	<a class="btnXoa" href="XoaQD?MaQD=<%=qd.getMaQuyetDinh()%>">Xoá</a>
	    </td>
		<td><%=qd.getMaQuyetDinh()%></td>
		<td><%=qd.getNoiDung()%></td>
		<td><%=qd.getNgayApDung()%></td>
		<td><%=qd.getLanSuaDoi()%></td>
		<td><%=qd.getNgaySuaDoi()%></td>
		<td><%=qd.getNgayKy()%></td>
	</tr>
	<%
}
%>
</table>
</div>
</body>
</html>