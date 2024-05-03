<%@page import="Models.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
NhanVien nv = (NhanVien)session.getAttribute("NV");
if(nv == null )
{
	%> 	<jsp:forward page="formLogin.jsp" /> <%
}
else
{
	String VaiTro = nv.getChucVu();
	if(VaiTro.equals("Nhan vien"))
		{%><jsp:forward page="formNhanvien.jsp" /><%}
		
	if(VaiTro.equals("Truong phong"))
		{%><jsp:forward page="formTruongPhong.jsp" /><%}
	
	if(VaiTro.equals("Admin"))
		{%><jsp:forward page="formAdmin.jsp" /><%}
}
%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Giám đốc</title>

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/GiamDocAdmin.css">
</head>
<body>
<header>
		<div class="header">
			<h3>Quản lý nhân sự</h3>
			<h5>Nhóm 24</h5>

			<div class = "dangxuat">
				<a> <img alt="" src="img/user.png"> Giám đốc</a>
				<a href = "<%=request.getContextPath()%>/Logout"> <img alt="" src="img/logout.png" > Đăng xuất (Log out)</a>
			</div>
		</div>
	</header>

	<div class="sidenav">
        <a href="<%=request.getContextPath()%>/TreeView" id="btnCoCau">Cơ cấu công ty</a>
        <a href="<%=request.getContextPath()%>/ThongTinCaNhan" id="btnThongTin">Thông tin cá nhân</a>
        <a href="<%=request.getContextPath()%>/XemDanhGia" id="btnXemDanhGia">Khen thưởng - Kỷ luật</a>
        <a href="<%=request.getContextPath()%>/LSLamViec" id="btnLichSu">Lịch sử làm việc</a>
        <a href="<%=request.getContextPath()%>/LTCongTac" id="btnLichTrinh">Lịch trình công tác</a>
        <a href="<%=request.getContextPath()%>/DanhSachNV" id="btnDanhSach">Danh sách nhân viên</a>
        <a href="<%=request.getContextPath()%>/TTLamViec" id="btnTrangThai">Cập nhật trạng thái làm việc</a>
        <a href="<%=request.getContextPath()%>/DSTrangThaiLV" id="btnLSTrangThai" >Lịch sử cập nhật trạng thái làm việc</a>
        <a href="<%=request.getContextPath()%>/DanhGiaNV" id="btnDanhGia">Đánh giá</a>
        <a href="<%=request.getContextPath()%>/DSDanhGia" id="btnLSDanhGia" >Xem lịch sử đánh giá</a>
        <a href="<%=request.getContextPath()%>/PhongBan" id="btnCapNhatTruongPhong">Cập nhật trưởng phòng</a>
        <a href="<%=request.getContextPath()%>/LichTrinhCT" id="btnCapNhatLichTrinh">Cập nhật lịch trình công tác</a> 
        <a href="<%=request.getContextPath()%>/DSLichTrinhCT" id="btnLSCapNhatLichTrinh" >Xem cập nhật lịch trình công tác</a>
		<a href="<%=request.getContextPath()%>/LichSuLV" id="btnCapNhatLichSu">Chuyển nhân viên/Nghỉ việc</a> 
		<a href="<%=request.getContextPath()%>/DSLichSuLV" id="btnLSCapNhatLichSu" >Xem cập nhật lịch sử làm việc</a>
		<a href="<%=request.getContextPath()%>/KyHopDong" id="btnKyHopDong">Ký hợp đồng</a>
    </div>
    
      <%
      String CurrentTab = (String)request.getAttribute("CurrentTab");
  		if(CurrentTab != null)
		{
  			String form = "";
		    switch(CurrentTab){
			    case "TreeView":
			    	form = "FormNhanVienCon/TreeView.jsp";
			    	break;
			    case "XemThongTinCaNhan":
			    	form = "FormNhanVienCon/ThongTinCaNhan.jsp";
			    	break;
			    case "XemDanhGia":
			    	form = "FormNhanVienCon/DanhGia.jsp";
			    	break;
			    case "XemLichSuLamViec":
			    	form = "FormNhanVienCon/LichSuLamViec.jsp";
			    	break;
			    case "XemLichTrinhCongTac":
			    	form = "FormNhanVienCon/LichTrinhCongTac.jsp";
			    	break;
			    case "DanhSachNhanVien":
			    	form = "FormTruongPhongCon/DanhSachNhanVien.jsp";
			    	break;
			    case "TrangThaiLamViec":
			    	form = "FormTruongPhongCon/TrangThaiLamViec/CapNhatTrangThaiLamViec.jsp";
			    	break;
			    case "XemTrangThaiLamViecNV":
			    	form = "FormNhanVienCon/TrangThaiLamViec.jsp";
			    	break;
			    case "DanhGiaNhanVien":
			    	form = "FormTruongPhongCon/DanhGiaNhanVien/DanhGiaNhanVien.jsp";
			    	break;
			    case "XemDanhGiaNhanVien":
			    	form = "FormNhanVienCon/DanhGia.jsp";
			    	break;
			    case "CapNhatTruongPhong" :
			    	form = "FormGiamDocCon/CapNhatTruongPhong/DanhSachPhongBan.jsp";
					break;
			    case "CapNhatLichTrinh" :
			    	form = "FormGiamDocCon/CapNhatLichTrinhCongTac/ThanhVien.jsp";
					break;
			    case "XemLichTrinhCongTacNhanVien":
			    	form = "FormNhanVienCon/LichTrinhCongTac.jsp";
			    	break;
			    case "CapNhatLichSu" :
			    	form = "FormGiamDocCon/CapNhatLichSuLamViec/ThanhVien.jsp";
					break;
			    case "XemLichSuLamViecNhanVien":
			    	form = "FormNhanVienCon/LichSuLamViec.jsp";
			    	break;
			    case "KyHopDong" :
			    	form = "FormGiamDocCon/KyHopDong.jsp";
					break;
			    
		 }%>
			<div style="width: 84.5%; height: 83%;" class="form">
				<jsp:include page="<%=form %>"></jsp:include>
			</div>
			<script src="js/GiamDoc.js"></script>
			<script>
			  	SetCurrentTab("<%= CurrentTab %>");
		    </script>
		<% } %> 
</body>
<script>
var msg = "<%= request.getAttribute("message") %>";
if(msg != "null")
	alert(msg);
</script>
</html>