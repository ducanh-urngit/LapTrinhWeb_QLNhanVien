<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
form{
	position: absolute;
	height: 100%;
	width: 100%;
	text-align: center;
}
table{
	margin: auto;
  	width: 50%;
}

th, td {
  padding-top: 10px;
  padding-bottom: 20px;
}

table, th, td {
  border:none; 
}
.label{
	width: 130px;
} 

.input{
	display: flex;
	width: 400px;
</style>
</head>
<body>
<%String MaCN = (String)request.getAttribute("MaCN"); %>
<form action="XacNhanKyHopDong" method="post">
	<h2>Ký hợp đồng</h2>
	<table>
	  <tr>
	   <td class="label">Mã hợp đồng</td>
	   <td class="input"><input class="input" type="text" name = "MaHopDong" ></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Mã nhân viên</td>
	   <td class="input"><input class="input" type="text" name = "MaNhanVien" ></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Mã chi Nhánh</td>
	   <td class="input"><input class="input" type="text" name = "MaChiNhanh" readonly value = "<%=MaCN%>" ></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Mã phòng ban</td>
	   <td class="input"><input class="input" type="text" name = "MaPhongBan" ></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Lương</td>
	   <td class="input"><input class="input" type="text" name = "Luong" ></td>
	  </tr>
	  
	  <tr>
	   <td class="label">Ngày ký</td>
	   <td class="input"><input class="input" type="date" name = "NgayKy" ></td>
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