<%@page import="Models.BoPhan"%>
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
		
	if(VaiTro.equals("Admin"))
		{%><jsp:forward page="formAdmin.jsp" /><%}
	
	if(VaiTro.equals("Nhan vien"))
		{%><jsp:forward page="formNhanvien.jsp" /><%}
}
%>
<title>Cập nhật thành viên</title>
<link rel="stylesheet" href="../css/styleFormThem.css">
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
BoPhan bp = (BoPhan)request.getAttribute("BP");
if(bp == null) bp = new BoPhan();
int c = 1;

%>
<form action="CapNhatTVBP" method="post">
	<h2>Cập nhật thành viên bộ phận</h2>
	<table>
		
	  <tr>
	   <td class="label">Mã nhân viên</td>
	   <td class="input"><input class="input" type="text" name = "MaNhanVien" ></td>
	  </tr>
		
	  <tr>
	   <td class="label">Mã bộ phận</td>
	   <td class="input"><input class="input" type="text" name = "MaBoPhan" readonly <%if(c==1){ %> value = "<%=bp.getMaBoPhan()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Mã phòng ban</td>
	   <td class="input"><input class="input" type="text" name = "MaPhongBan" readonly <%if(c==1){ %> value = "<%=bp.getMaPhongBan()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Tên bộ phận</td>
	   <td class="input"><input class="input" type="text" name = "TenBoPhan" readonly <%if(c==1){ %> value = "<%=bp.getTenBoPhan()%>"<%} %>></td>
	  </tr>
	  
	  <tr>
	  	<td >
	  		<button style="width: 90px; margin-left: 100px;" type = "submit">Lưu</button>
	  	</td>
	  </tr>
	</table>
</form>
</body>
</html>