<%@page import="Models.ChiNhanh"%>
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
<h2>Quản lý chi nhánh</h2>
<a href="<%=request.getContextPath()%>/ThemChiNhanh"><input class = "btnThem" type="button" value="Thêm chi nhánh"></a>
<table style="width: 100%;">
  
  <tr>
    <th>Mã chi nhánh</th>
    <th>Tên chi nhánh</th>
    <th>Địa chỉ</th>
    <th>Mã giám đốc</th>
    <th>Mã phó giám đốc</th>
    <th></th>
  </tr>
  
<%
List<ChiNhanh> CNList = (List<ChiNhanh>)request.getAttribute("listCN");
for (ChiNhanh cn : CNList)
{
	%>
	<tr>
		<td><%=cn.getMaChiNhanh()%></td>
		<td><%=cn.getTenChiNhanh()%></td>
		<td><%=cn.getDiaChi()%></td>
		<td><%=cn.getMaGiamDoc()%></td>
		<td><%=cn.getMaPhoGiamDoc()%></td>
		<td class="btnSuaXoa">
	    	<a href="SuaChiNhanh?MaCN=<%=cn.getMaChiNhanh()%>">Sửa</a>
	    	&nbsp;&nbsp;&nbsp;&nbsp;
	    	<a class="btnXoa" href="XoaCN?MaCN=<%=cn.getMaChiNhanh()%>">Xoá</a>
	    </td>
	</tr>
	<%
}
%>
</table>
</div>
</body>
</html>