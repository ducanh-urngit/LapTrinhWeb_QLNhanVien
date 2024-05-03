package Models;

public class PhanQuyen {

	public PhanQuyen() {
		super();
	}
	
	public String LayPhanQuyen(String VaiTro)
	{
		String form = "";
		switch (VaiTro){
			case "Nhan vien":
				form = "formNhanvien.jsp";
				break;
			case "Giam doc":
				form = "formGiamDoc.jsp";
				break;
			case "Truong phong":
				form = "formTruongPhong.jsp";
				break;
			case "Admin":
				form = "formAdmin.jsp";
				break;	
		}
		return form;
	}
}
