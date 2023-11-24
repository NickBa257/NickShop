<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="modele.*,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/style.css">
</head>
<body>

	<%
		ArrayList<Panier> tabPa0 = (ArrayList) session.getAttribute("tableau");
	%>

	<section class="header-section">

		<div class="container">
			<header class="navbar">
				<div class="logo">
					<img src="IMAGE/LOGO 1.png" alt="logo 1">
				</div>
				<nav>
					<ul>
						<li><a href="AccueilA.jsp"><img alt="" src="IMAGE/icons8-home-26.png"></a>&nbsp;&nbsp;&nbsp;</li>
								
						<li><a href="Commande.jsp"><img alt="" src="IMAGE/icons8-box-50.png"></a></li>

						<%
							if (tabPa0 != null) {
						%>

						<%
							if (tabPa0.size() != 0) {
						%>

						<li><a href="Panier.jsp"><img alt=""
								src="IMAGE/icons8-add-to-cart-50.png"><%=tabPa0.size()%></a></li>

						<%
							} else {
						%>

						<li><a href="Panier.jsp"><img alt=""
								src="IMAGE/icons8-add-to-cart-50.png"><%=0%></a></li>

						<%
							}
						%>

						<%
							} else {
						%>

						<li><a href="Panier.jsp"><img alt=""
								src="IMAGE/icons8-add-to-cart-50.png">0</a></li>

						<%
							}
						%>

						<li><a href="Profil.jsp"><img alt="" src="IMAGE/people.png"></a></li>
						<li><a href="DeconnectionS"><img alt=""
								src="IMAGE/icons8-logout.gif"></a></li>
					</ul>
				</nav>
			</header>

		</div>

	</section>

</body>
</html>