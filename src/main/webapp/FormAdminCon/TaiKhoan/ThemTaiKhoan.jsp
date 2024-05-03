<%@page import="Models.ThongTinDangNhap"%>
<%@page import="Models.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
NhanVien nv = (NhanVien)session.getAttribute("NV");
if(nv == null)
{
	%> 	<jsp:forward page="formLogin.jsp" /> <%
}
else
{
	String VaiTro = nv.getChucVu();
	if(VaiTro.equals("Giam doc"))
		{%><jsp:forward page="formGiamDoc.jsp" /><%}
		
	if(VaiTro.equals("Truong phong"))
		{%><jsp:forward page="formTruongPhong.jsp" /><%}
	
	if(VaiTro.equals("Nhan vien"))
		{%><jsp:forward page="formNhanvien.jsp" /><%}
}
%>
<title>Thêm</title>
<link rel="stylesheet" href="../../css/styleFormThem.css">
<style>
body{
	display: flex;
	justify-content: center;
	align-items: center;
}
table{
	width: 530px;
}

th, td {
  padding-top: 10px;
  padding-bottom: 20px;
}

table, th, td {
  /* border:1px solid black;  */
  border:none; 
}

.label{
	width: 130px;
} 

.input{
	display: flex;
	width: 400px;
}
</style>
</head>
<body>
<%
ThongTinDangNhap tk = (ThongTinDangNhap)request.getAttribute("TK");
if(tk == null) tk = new ThongTinDangNhap();
int c = 0;
if(tk.getMaNV()== null)
{
	%><form action="ThemTK" method="post">
		<h2>Thêm tài khoản</h2><%
}
else
{
	c = 1;
	%><form action="SuaTK" method="post">
		<h2>Sửa tài khoản</h2><%
}
%>
	<table>
	  <tr>
	   <td class="label">Mã nhân viên</td>
	   <td class="input"><input class="input" type="text" name = "MaNhanVien" <%if(c==1){ %> value = "<%=tk.getMaNV()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Tài khoản</td>
	   <td class="input"><input class="input" type="text" name = "TaiKhoan" <%if(c==1){ %> value = "<%=tk.getTaiKhoan()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Mật khẩu</td>
	   <td class="input"><input class="input" type="text" name = "MatKhau" <%if(c==1){ %> value = "<%=tk.getMatKhau()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	  	<td >
	  		<button style="width: 200px; background-color: red; margin-left: 100px;" type = "submit">Lưu</button>
	  	</td>
	  </tr>
	</table>
</form>
</body>
</html>