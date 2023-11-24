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
	Acheteur acheteur = null;
	acheteur = (Acheteur) session.getAttribute("Acheteur");

	String nom = acheteur.getNom();

	Connection con = Db.getConnection();
	ResultSet rs = Db.Affichage("select CommandeId,NomProduit,PrixTotal,Date_Commande from commande where NomClient='" + nom + "' ");
	
	int Total = 0;
	%>
	
	<%@ include file="include/teteA.jsp" %>

	<table>

        <th>CommandeId</th>
		<th>Quantite et Nom des Produits</th>
		<th>Prix Total</th>
		<th>Date de la commande</th>

		<%
			while(rs.next()){
		%>
		<tr>

            <td><%=rs.getInt(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getInt(3)%></td>
			<td><%=rs.getString(4)%></td>

			<%
				Total = Total + rs.getInt(3);
			%>

		</tr>
		<%
			}
		%>

	</table>


	<p>
		La Totalité de toutes vos commandes est élevée a :<%=Total%>Fbu
	</p>

<%@include file="include/Pied.jsp"%>
</body>
</html>