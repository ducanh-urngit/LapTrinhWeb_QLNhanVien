<%@page import="Models.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
NhanVien nv = (NhanVien)session.getAttribute("NV");
if(nv == null || nv.getChucVu()==null)
{
	%> <jsp:forward page="formLogin.jsp" /> <%
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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/GiamDocAdmin.css">
<link rel="stylesheet" href="css/style.css">

<title>Admin</title>

<script>
var msg = "<%= request.getAttribute("message") %>";
if(msg != "null")
	alert(msg);
</script>
</head>
<body>
	<header>
		<div class = "header">
			<h3>Quản lý nhân sự</h3>
			<h5>Nhóm 24</h5>
			<div class = "dangxuat">
				<a> <img alt="" src="img/user.png"> Admin</a>
				<a href = "<%=request.getContextPath()%>/Logout"> <img alt="" src="img/logout.png" > Đăng xuất (Log out)</a>
			</div>
		</div>
	</header>
	
	<div class="sidenav">
        <a href="<%=request.getContextPath()%>/TreeView" id="btnCoCau">Cơ cấu công ty</a>
        <a href="<%=request.getContextPath()%>/ThongTinCaNhan" id="btnThongTin">Thông tin cá nhân</a>
        <a href="<%=request.getContextPath()%>/QLNhanVien" id="btnQLNhanVien" >Quản lý nhân viên</a>
        <a href="<%=request.getContextPath()%>/QLChiNhanh" id="btnQLChiNhanh" >Quản lý Chi Nhánh</a>
        <a href="<%=request.getContextPath()%>/QLPhongBan" id="btnQLPhongBan" >Quản lý Phòng ban</a>
        <a href="<%=request.getContextPath()%>/QLBoPhan" id="btnQLBoPhan" >Quản lý bộ phận</a>
        <a href="<%=request.getContextPath()%>/QLQuyetDinh" id="btnQLQuyetDinh" >Quản lý quyết định</a>
        <a href="<%=request.getContextPath()%>/QLHopDong" id="btnQLHopDong" >Quản lý hợp đồng</a>
        <a href="<%=request.getContextPath()%>/QLTaiKhoan" id="btnQLTaiKhoan" >Quản lý tài khoản</a>
        <a href="<%=request.getContextPath()%>/TTLamViec" id="btnTrangThai" >Cập nhật trạng thái làm việc</a>
        <a href="<%=request.getContextPath()%>/DSTrangThaiLV" id="btnLSTrangThai" >Lịch sử cập nhật trạng thái làm việc</a>
        <a href="<%=request.getContextPath()%>/DanhGiaNV" id="btnDanhGia" >Đánh giá</a>
        <a href="<%=request.getContextPath()%>/DSDanhGia" id="btnLSDanhGia" >Xem lịch sử đánh giá</a>
        <a href="<%=request.getContextPath()%>/DSLichTrinhCT" id="btnCapNhatLichTrinh" >Quản lý lịch trình công tác</a>
        <a href="<%=request.getContextPath()%>/DSLichSuLV" id="btnCapNhatLichSu" >Quản lý lịch sử làm việc</a>
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
		    case "QLNhanVien":
		    	form = "FormAdminCon/NhanVien/QLNhanVien.jsp";
		    	break;
		    case "QLChiNhanh":
		    	form = "FormAdminCon/ChiNhanh/QLChiNhanh.jsp";
		    	break;
		    case "QLPhongBan":
		    	form = "FormAdminCon/PhongBan/QLPhongBan.jsp";
		    	break;
		    case "QLBoPhan":
		    	form = "FormAdminCon/BoPhan/QLBoPhan.jsp";
		    	break;
		    case "QLQuyetDinh":
		    	form = "FormAdminCon/QuyetDinh/QLQuyetDinh.jsp";
		    	break;
		    case "QLHopDong":
		    	form = "FormAdminCon/HopDong/QLHopDong.jsp";
		    	break;
		    case "QLTaiKhoan":
		    	form = "FormAdminCon/TaiKhoan/QLTaiKhoan.jsp";
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
		    case "XemLichTrinhCongTacNhanVien":
		    	form = "FormNhanVienCon/LichTrinhCongTac.jsp";
		    	break;
		    case "XemLichSuLamViecNhanVien":
		    	form = "FormNhanVienCon/LichSuLamViec.jsp";
		    	break;
		    
		    
		    default:
		    	break;
		    }%>
			<div style="width: 84.5%; height: 83%;" class="form">
				<jsp:include page="<%=form %>"></jsp:include>
			</div>
			<script src="js/admin.js"></script>
			<script>
			  	SetCurrentTab("<%= CurrentTab %>");
		    </script>
		<% } %>

</body>

</html>