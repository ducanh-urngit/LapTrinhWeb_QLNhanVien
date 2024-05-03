<%@page import="Models.ThongTinDangNhap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styleFormCon.css">
<style>
.BTNThem{
	position: absolute;
	right: 10px;
	top: 5px;
	display: block;
	height: 50px;
	width: 700px;
}
.BTNThem form{
	display: inline;
}

.BTN{
	height: 50px;
	width: 150px;
	margin-left: 50px;
	right: 0;
	background-color: #CCFFFF;
	border-bottom-left-radius: 50px 20px;
	border-top-right-radius: 50px 20px;
	cursor: pointer;
}
</style>
</head>

<body>
<div class = "TongThe">
<h2>Quản lý tài khoản</h2>
<div class = "BTNThem">
	<form action="ImportTK" method = "post" enctype="multipart/form-data">
		<input type="file" name="excelFile">
		<button class="BTN" type="submit">Import</button>
	</form>
	<a href = "<%=request.getContextPath()%>/ThemTaiKhoan"><input class="BTN" type="button" value="Thêm tài khoản" ></a>
</div>
<table style="width: 100%;">
  
  <tr>
    <th>Mã nhân viên</th>
    <th>Tài khoản</th>
    <th>Mật khẩu</th>
    <th></th>
  </tr>
<%
List<ThongTinDangNhap> TKList = (List<ThongTinDangNhap>)request.getAttribute("listTK");
for (ThongTinDangNhap tk : TKList)
{
	%>
	<tr>
		<td><%=tk.getMaNV()%></td>
		<td><%=tk.getTaiKhoan()%></td>
		<td><%=tk.getMatKhau()%></td>
		<td class="btnSuaXoa">
	    	<a href="SuaTaiKhoan?MaTK=<%=tk.getMaNV()%>">Sửa</a>
	    	&nbsp;&nbsp;&nbsp;&nbsp;
	    	<a class="btnXoa" href="XoaTK?MaTK=<%=tk.getMaNV()%>">Xoá</a>
	    </td>
	</tr>
	<%
}
%>
</table>
</div>
</body>
</html>