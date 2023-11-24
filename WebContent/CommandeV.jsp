<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList,controlleur.*,modele.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commande</title>
<link rel="stylesheet" href="Css/commande.css">
</head>
<body>
	<%
	Vendeur vendeur = null;
	vendeur = (Vendeur) session.getAttribute("Vendeur");

	int id = vendeur.getId();

	Connection con = Db.getConnection();
	ResultSet rs = Db.Affichage("select CommandeId,NomProduit,Quantite,PrixTotal,NomClient,Date_Commande,Effectue from commandev where NomProduit in (select Nom from produit where VId='"+id+"') ");
	
	int Total = 0;
	%>
	
	<%@ include file="include/teteV.jsp" %>

	<table>

        <th>CommandeId</th>
		<th>Nom du Produit</th>
		<th>Quantité</th>
		<th>Prix Total</th>
		<th>Nom du Client</th>
		<th>Date de la commande</th>
		<th>Effectue</th>

		<%
			while(rs.next()){
		%>
		<tr>
            <td><%=rs.getInt(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getInt(3)%></td>
			<td><%=rs.getInt(4)%></td>
			<td><%=rs.getString(5)%></td>
			<td><%=rs.getString(6)%></td>
			<td><%=rs.getString(7)%></td>

			<%
				Total = Total + rs.getInt(4);
			%>

		</tr>
		<%
			}
		%>

	</table>


	<p>
		La Totalité de toutes vos gain est élevée a :<%=Total%>Fbu
	</p>


</body>
<%@include file="include/Pied.jsp"%>

</html>