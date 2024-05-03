<%@page import="Models.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
	
	if(VaiTro.equals("Admin"))
		{%><jsp:forward page="formAdmin.jsp" /><%}
}
%>
<title>Nhân viên</title>

<link rel="stylesheet" href="css/style.css">
<script>
var msg = "<%=request.getAttribute("message")%>";
console.log("Print this message");
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
				<a> <img alt="" src="img/user.png"> Nhân viên</a>
				<a href = "<%=request.getContextPath()%>/Logout"> <img alt="" src="img/logout.png" > Đăng xuất (Log out)</a>
			</div>
		</div>
	</header>
	
	<div class="sidenav">
        <a href="<%=request.getContextPath()%>/TreeView" id="btnCoCau">Cơ cấu công ty</a>
        <a href="<%=request.getContextPath()%>/ThongTinCaNhan" id="btnThongTin">Thông tin cá nhân</a>
        <a href="<%=request.getContextPath()%>/XemDanhGia" id="btnDanhGia">Khen thưởng - Kỷ luật</a>
        <a href="<%=request.getContextPath()%>/LSLamViec" id="btnLichSu">Lịch sử làm việc</a>
        <a href="<%=request.getContextPath()%>/LTCongTac" id="btnLichTrinh">Lịch trình công tác</a>
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
		    default:
		    	break;
		    }%>
			<div style="width: 84.5%; height: 83%;" class="form">
				<jsp:include page="<%=form %>"></jsp:include>
			</div>
			<script src="js/NhanVien.js"></script>  
			<script>
			  	SetCurrentTab("<%= CurrentTab %>");
		    </script>
		<% } %>
   
</body>

</html>