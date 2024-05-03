
function SetCurrentTab(CurrentTab){
	console.log("Hello World");
	switch (CurrentTab){
		case "TreeView":
			document.getElementById("btnCoCau").style.color = "#FFFFFF";
			break;
		case "XemThongTinCaNhan":
			document.getElementById("btnThongTin").style.color = "#FFFFFF";
			break;
		case "QLNhanVien":
			document.getElementById("btnQLNhanVien").style.color = "#FFFFFF";
			break;
		case "QLChiNhanh":
			document.getElementById("btnQLChiNhanh").style.color = "#FFFFFF";
			break;
		case "QLPhongBan":
			document.getElementById("btnQLPhongBan").style.color = "#FFFFFF";
			break;
		case "QLBoPhan":
			document.getElementById("btnQLBoPhan").style.color = "#FFFFFF";
			break;
		case "QLQuyetDinh":
			document.getElementById("btnQLQuyetDinh").style.color = "#FFFFFF";
			break;
		case "QLHopDong":
			document.getElementById("btnQLHopDong").style.color = "#FFFFFF";
			break;
		case "QLTaiKhoan":
			document.getElementById("btnQLTaiKhoan").style.color = "#FFFFFF";
			break;
		case "TrangThaiLamViec":
			document.getElementById("btnTrangThai").style.color = "#FFFFFF";
			break;
		case "XemTrangThaiLamViecNV":
			document.getElementById("btnLSTrangThai").style.color = "#FFFFFF";
			break;
		case "DanhGiaNhanVien":
			document.getElementById("btnDanhGia").style.color = "#FFFFFF";
			break;
		case "XemDanhGiaNhanVien":
			document.getElementById("btnLSDanhGia").style.color = "#FFFFFF";
			break;
		case "XemLichTrinhCongTacNhanVien":
			document.getElementById("btnCapNhatLichTrinh").style.color = "#FFFFFF";
			break;
		case "XemLichSuLamViecNhanVien":
			document.getElementById("btnCapNhatLichSu").style.color = "#FFFFFF";
			break;
		
		default:
			break;
	}
}
