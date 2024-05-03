
function SetCurrentTab(CurrentTab){
	console.log("Hello World");
	switch (CurrentTab){
		case "TreeView":
			document.getElementById("btnCoCau").style.color = "#FFFFFF";
			break;
		case "XemThongTinCaNhan":
			document.getElementById("btnThongTin").style.color = "#FFFFFF";
			break;
		case "XemDanhGia":
			document.getElementById("btnXemDanhGia").style.color = "#FFFFFF";
			break;
		case "XemLichSuLamViec":
			document.getElementById("btnLichSu").style.color = "#FFFFFF";
			break;
		case "XemLichTrinhCongTac":
			document.getElementById("btnLichTrinh").style.color = "#FFFFFF";
			break;
		case "DanhSachNhanVien":
			document.getElementById("btnDanhSach").style.color = "#FFFFFF";
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
		case "CapNhatTruongPhong":
			document.getElementById("btnCapNhatTruongPhong").style.color = "#FFFFFF";
			break;
		case "CapNhatLichTrinh":
			document.getElementById("btnCapNhatLichTrinh").style.color = "#FFFFFF";
			break;
		case "XemLichTrinhCongTacNhanVien":
			document.getElementById("btnLSCapNhatLichTrinh").style.color = "#FFFFFF";
			break;
		case "CapNhatLichSu":
			document.getElementById("btnCapNhatLichSu").style.color = "#FFFFFF";
			break;
		case "XemLichSuLamViecNhanVien":
			document.getElementById("btnLSCapNhatLichSu").style.color = "#FFFFFF";
			break;
		case "KyHopDong":
			document.getElementById("btnKyHopDong").style.color = "#FFFFFF";
			break;
		
		default:
			break;
	}
}
