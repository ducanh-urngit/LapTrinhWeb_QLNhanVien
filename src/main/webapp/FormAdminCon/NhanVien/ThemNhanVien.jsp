<%@page import="Models.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
NhanVien NV = (NhanVien)session.getAttribute("NV");
if(NV == null)
{
	%> 	<jsp:forward page="formLogin.jsp" /> <%
}
else
{
	String VaiTro = NV.getChucVu();
	if(VaiTro.equals("Giam doc"))
		{%><jsp:forward page="formGiamDoc.jsp" /><%}
		
	if(VaiTro.equals("Truong phong"))
		{%><jsp:forward page="formTruongPhong.jsp" /><%}
	
	if(VaiTro.equals("Nhan vien"))
		{%><jsp:forward page="formNhanvien.jsp" /><%}
}
%>
<title>Thêm</title>
<style>

table{
	width: 100%;
}

th, td {
  padding-top: 10px;
  padding-bottom: 20px;
}

table, th, td {
  border:none;
}

</style>
</head>
<body>
<%
NhanVien nv = (NhanVien)request.getAttribute("NV");
int c = 0;
if(nv.getMaNV() == null)
{
	%><form action="ThemNV" method="post">
		<h2>Thêm nhân viên</h2><%
}
else
{
	c = 1;
	%><form action="SuaNV" method="post">
		<h2>Sửa nhân viên</h2><%
}
%>
	<table>
	  <tr>
	   <td><table>
	   			<tr>
	   				<td>Mã Nhân viên</td>
	   				<td><input type="text" name = "MaNV" <%if(c==1){ %> value = "<%=nv.getMaNV()%>"<%} %>></td>
	   			</tr>
	   			<tr>
	   				<td>Họ tên</td>
	   				<td><input type="text" name = "HoTen" <%if(c==1){ %> value = "<%=nv.getHoTen()%>"<%} %>></td>
	   			</tr>
	   			<tr>
	   				<td>Ngày sinh</td>
	   				<td><input type="date" name = "NgaySinh" <%if(c==1){ %> value = "<%=nv.getNgaySinh()%>"<%} %>></td>
	   			</tr>
	   			<tr>
	   				<td>Giới tính</td>
	   				<td><input type="text" name = "GioiTinh" <%if(c==1){ %> value = "<%=nv.getGioiTinh()%>"<%} %>></td>
	   			</tr>
	   			<tr>
	   				<td>Dân tộc</td>
	   				<td><input type="text" name = "DanToc" <%if(c==1){ %> value = "<%=nv.getDanToc()%>"<%} %>></td>
	   			</tr>
	   			<tr>
	   				<td>Tôn giáo</td>
	   				<td><input type="text" name = "TonGiao" <%if(c==1){ %> value = "<%=nv.getTonGiao()%>"<%} %>></td>
	   			</tr>
	   			
	   		</table>
	   	</td>
	    <td>
	    	<table>
	   			<tr>
	   				<td>CCCD</td>
	   				<td><input type="text" name = "CCCD"<%if(c==1){ %> value = "<%=nv.getCCCD()%>"<%} %>></td>
	   			</tr>
	   			<tr>
	   				<td>Ngày cấp</td>
	   				<td><input type="date" name = "NgayCap"<%if(c==1){ %> value = "<%=nv.getNgayCap()%>"<%} %>></td>
	   			</tr>
	   			<tr>
	   				<td>Nơi cấp</td>
	   				<td><input type="text" name = "NoiCap"<%if(c==1){ %> value = "<%=nv.getNoiCap()%>"<%} %>></td>
	   			</tr>
	   			<tr>
	   				<td>Địa chỉ</td>
	   				<td><textarea style="resize: none" rows="3"  type="text" name = "DiaChi"><%if(c==1){ %><%=nv.getDiaChi()%><%} %></textarea></td>
	   			</tr>
	   			<tr>
	   				<td>Email</td>
	   				<td><input type="text" name = "Email"<%if(c==1){ %> value = "<%=nv.getEmail()%>"<%} %>></td>
	   			</tr>
	   			<tr>
	   				<td>SĐT</td>
	   				<td><input type="text" name = "SDT"<%if(c==1){ %> value = "<%=nv.getSDT()%>"<%} %>></td>
	   			</tr>
	   			
	   		</table>
		</td>
		<td>
	    	<table>
	   			<tr>
	   				<td>Chức vụ</td>
	   				<%String cv = "";
	   				if(c == 1) {cv = nv.getChucVu();}%>
	   				<td><select name = "ChucVu">
	   					<option value="Nhan vien" <% if(cv.equals("Nhan vien")) { %> selected="selected"<% } %>>Nhân viên
						</option>
	   					<option value="Giam doc" <% if(cv.equals("Giam doc")) { %> selected="selected"<% } %>>Giám đốc
						</option>
	   					<option value="Truong phong" <% if(cv.equals("Truong phong")) { %> selected="selected"<% } %>>Trưởng phòng
						</option>
	   					<option value="Admin" <% if(cv.equals("Admin")) { %> selected="selected"<% } %>>Admin
						</option>
	   				</td>
	   			</tr>
	   			<tr>
	   				<td>Trình độ</td>
	   				<td><input type="text" name = "TrinhDo"<%if(c==1){ %> value = "<%=nv.getTringDo()%>"<%} %>></td>
	   			</tr>
	   			<tr>
	   				<td>Mã chi nhánh</td>
	   				<td><input type="text" name = "MaChiNhanh"<%if(c==1){ %> value = "<%=nv.getMaChiNhanh()%>"<%} %>></td>
	   			</tr>
	   			<tr>
	   				<td>Mã phòng ban</td>
	   				<td><input type="text" name = "MaPhongBan"<%if(c==1){ %> value = "<%=nv.getMaPhongBan()%>"<%} %>></td>
	   			</tr>
	   			<tr>
	   				<td>Mã bộ phận</td>
	   				<td><input type="text" name = "MaBoPhan"<%if(c==1){ %> value = "<%=nv.getMaBoPhan()%>"<%} %>></td>
	   			</tr>
	   			<tr>
	   				<td>Lương</td>
	   				<td><input type="text" name = "Luong"<%if(c==1){ %> value = "<%=nv.getLuong()%>"<%} %>></td>
	   			</tr>
	   			
	   		</table>
		</td>
	  </tr>
	  
	  <tr>
	  	<td>
	  		<button style="width: 90px; margin-left: 100px;" type = "submit" >Lưu</button>
	  	</td>
	  </tr>
	</table>
</form>
</body>
</html>