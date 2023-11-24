<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, modele.*, controlleur.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/panier.css">
</head>
<body>

	<%
	  int total = 0;
	
	  ArrayList<Panier> tabPa = (ArrayList)session.getAttribute("tableau");
	%>

	<%@ include file="include/teteA.jsp"%>

	<%
		if (tabPa == null) {
	%>

	<%
		} else {
	%>
	
    <table>
		<tr>
			<th>Nom du produit</th>
			<th>Quantité</th>
			<th>Prix</th>
		</tr>

		<%
			for (Panier p : tabPa) {
		%>
		<tr>
			<td><%=p.getNom()%></td>
			<td><input type="number" name="Q" value=<%=p.getQuantite()%> readonly>  &nbsp; &nbsp; &nbsp; <a href="PanierS?id=<%=p.getP_id()%>&action=plus"class="button-link">+</a> &nbsp; &nbsp; &nbsp;<a href="PanierS?id=<%=p.getP_id()%>&action=moins"class="button-link">-</a> </td>
			<td><%= p.getPrix()*p.getQuantite() %> Fbu</td>
			<td><a href="PanierS?id=<%=p.getP_id()%>&action=retirer"class="button-linkR">Retirer</a> </td>
		</tr>
		<%
			total = total + ( p.getPrix()*p.getQuantite()) ;
		%>
		
		<%
			}
		%>

	</table>
	
	
	
	<%}%>

	<p>
		Total:<%=total%> Fbu
	</p>

		<a href="CommandeS?total=<%=total%>" class="pay-button">Payer</a>

<%@include file="include/Pied.jsp"%>
</body>

</html>