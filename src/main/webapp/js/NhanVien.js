function SetCurrentTab(CurrentTab){
	switch (CurrentTab){
		case "TreeView":
			document.getElementById("btnCoCau").style.color = "#FFFFFF";
			break;
		case "XemThongTinCaNhan":
			document.getElementById("btnThongTin").style.color = "#FFFFFF";
			break;
		case "XemDanhGia":
			document.getElementById("btnDanhGia").style.color = "#FFFFFF";
			break;
		case "XemLichSuLamViec":
			document.getElementById("btnLichSu").style.color = "#FFFFFF";
			break;
		case "XemLichTrinhCongTac":
			document.getElementById("btnLichTrinh").style.color = "#FFFFFF";
			break;
		default:
			break;
	}
}