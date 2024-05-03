<%@page import="Models.BoPhan"%>
<%@page import="Models.PhongBan"%>
<%@page import="java.util.List"%>
<%@page import="Models.ChiNhanh"%>
<%@page import="DAO.DAO_TreeView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.css" rel="stylesheet" type="text/css"/>
<style>
summary {
  display: block;
  cursor: pointer;
  outline: 0; 
}

summary::-webkit-details-marker {
    display: none;
  }

body {
  background-color: white;
  color: black;  
  font-size: 1.6rem;
  font-family: arial;
  margin: 0;
  padding: 3rem;
}

.TongThe{
	position: absolute;
	height: 100%;
	width: 100%;
	overflow: scroll;
}

.tree-nav__item {
  display: block;
  white-space: nowrap;
  color: black;
  position: relative;
}
.tree-nav__item.is-expandable::before {
  border-left: 1px solid #333;
  content: "";
  height: 100%;
  left: 0.8rem;
  position: absolute;
  top: 2.4rem;
  height: calc(100% - 2.4rem);
}
.tree-nav__item .tree-nav__item {
  margin-left: 2.4rem;
}
.tree-nav__item.is-expandable[open] > .tree-nav__item-title::before {
  font-family: "ionicons";
  transform: rotate(90deg);
}
.tree-nav__item.is-expandable > .tree-nav__item-title {
  padding-left: 2.4rem;
}
.tree-nav__item.is-expandable > .tree-nav__item-title::before {
  position: absolute;
  will-change: transform;
  transition: transform 300ms ease;
  font-family: "ionicons";
  color: black;
  font-size: 1.1rem;
  content: "\f125";
  left: 0;
  display: inline-block;
  width: 1.6rem;
  text-align: center;
}

.tree-nav__item-title {
  cursor: pointer;
  display: block;
  outline: 0;
  color: black;
  font-size: 1.5rem;
  line-height: 3.2rem;
}
.tree-nav__item-title .icon {
  display: inline;
  padding-left: 1.6rem;
  margin-right: 0.8rem;
  color: black;
  font-size: 1.4rem;
  position: relative;
}
.tree-nav__item-title .icon::before {
  top: 0;
  position: absolute;
  left: 0;
  display: inline-block;
  width: 1.6rem;
  text-align: center;
}

.tree-nav__item-title::-webkit-details-marker {
  display: none;
}
</style>
</head>
<body>
<div class="TongThe">
<%
DAO_TreeView controll = new DAO_TreeView();
List<ChiNhanh> listCN = controll.LayDSChiNhanh();
%>
<nav class="tree-nav">
	<a class="tree-nav__item-title">
	    <i class="icon ion-android-star"></i>
	    Cơ cấu công ty (<%=listCN.size() %> chi nhánh)
	 </a>
<%
for(ChiNhanh cn : listCN)
{
	List<PhongBan> ListPB = controll.LayDSPhongBan(cn.getMaChiNhanh());
	%>
	<details class="tree-nav__item is-expandable">
		<summary class="tree-nav__item-title"><%=cn.getMaChiNhanh()%>: <%=cn.getTenChiNhanh() %> (<%=ListPB.size() %> phòng ban)</summary>
		<%
		for(PhongBan pb : ListPB)
		{
			List<BoPhan> ListBP = controll.LayDSBoPhan(pb.getMaPhongBan());
			%>
			<details class="tree-nav__item is-expandable">
				<summary class="tree-nav__item-title"><%=pb.getMaPhongBan()%>: <%=pb.getTenPhongBan() %> (<%=ListBP.size()%> bộ phận)</summary>
					<div class="tree-nav__item">
					<%
						for(BoPhan bp : ListBP)
						{
							%>
							<a class="tree-nav__item-title "><i></i><%=bp.getMaBoPhan()%>: <%=bp.getTenBoPhan() %></a>
							<%
						}
						%>
					</div>
			</details>
			<%
		}
		%>
	</details>
	<%
}
%>
</nav>
</div>
</body>
</html>