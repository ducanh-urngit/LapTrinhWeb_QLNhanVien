<%@page import="Models.NhanVien"%>
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
<h2>Quản lý nhân viên</h2>
<div class = "BTNThem">
	<form action="ImportDSNV" method = "post" enctype="multipart/form-data">
		<input type="file" name="excelFile">
		<button class="BTN" type="submit">Import</button>
	</form>
	<a href="<%=request.getContextPath()%>/Them"><input class="BTN" type="button" value="Thêm nhân viên"></a>
</div>
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
			<a href="Sua?MaNV=<%=nv.getMaNV()%>">Sửa</a>
			&nbsp;&nbsp;&nbsp;&nbsp; 
			<a class="btnXoa" href="Xoa?MaNV=<%=nv.getMaNV()%>">Xoá</a></td>
			
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
	}
	%>
</table>
</div>
</body>
</html>