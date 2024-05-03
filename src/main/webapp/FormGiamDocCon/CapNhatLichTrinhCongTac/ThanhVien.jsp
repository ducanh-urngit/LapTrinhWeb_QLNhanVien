<%@page import="Models.NhanVien"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.TongThe{
	position: absolute;
	height: 100%;
	width: 100%;
	overflow: scroll;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

.btnSuaXoa{
	text-align: center; 
	width: 100px;
}
</style>
</head>
<body>
<div class = "TongThe">
<h2>Cập nhật lịch trình công tác</h2>

<table style="width: 300%;">
  
  <tr>
  	<th></th>
    <th>Mã nhân viên</th>
    <th>Họ tên</th>
    <th>Ngày sinh</th>
    <th>Giới tính</th>
    <th>Dân tộc</th>
    <th>Tôn giáo</th>
    
    <th>CCCD</th>
    <th>Ngày cấp</th>
    <th>Nơi cấp</th>
    <th>Địa chỉ</th>
    <th>Email</th>
    <th>SĐT</th>
    <th>Chức vụ</th>
    <th>Trình độ</th>
    <th>Mã chi nhánh</th>
    <th>Mã phòng ban</th>
    <th>Mã bộ phận</th>
    <th>Lương</th>
  </tr>
  <%
  List<NhanVien> NVList = (List<NhanVien>)request.getAttribute("listNV");
  for (NhanVien nv : NVList) {
		%><tr>
		<td class="btnSuaXoa">
			<a href="CapNhatLTCT?MaNV=<%=nv.getMaNV()%>">Công tác</a>
			
		<td><%=nv.getMaNV()%></td>
		<td><%=nv.getHoTen()%></td>
		
      	<td><%=nv.getNgaySinh()%></td>
		
		<td><%=nv.getGioiTinh() %></td>
		<td><%=nv.getDanToc()%></td>
		<td><%=nv.getTonGiao()%></td>
		<td><%=nv.getCCCD()%></td>
		
      	<td><%=nv.getNgayCap() %></td>
		
		<td><%=nv.getNoiCap()%></td>
		<td><%=nv.getDiaChi()%></td>
		<td><%=nv.getEmail()%></td>
		<td><%=nv.getSDT()%></td>
		<td><%=nv.getChucVu()%></td>
		<td><%=nv.getTringDo()%></td>
		<td><%=nv.getMaChiNhanh()%></td>
		<td><%=nv.getMaPhongBan()%></td>
		<td><%=nv.getMaBoPhan()%></td>
		<td><%=nv.getLuong()%></td>
		</tr><%
	} %>
</table>
</div>
</body>
</html>