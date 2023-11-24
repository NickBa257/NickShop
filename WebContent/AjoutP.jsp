<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="modele.*,controlleur.*,java.util.ArrayList,java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/ajoutP.css">
</head>
<body>

	<%@ include file="include/teteV.jsp"%>

	<%
		Vendeur vendeur = null;
	vendeur = (Vendeur) session.getAttribute("Vendeur");

	int id = vendeur.getId();

	Connection con = Db.getConnection();
	ResultSet rs = Db.Affichage("select * from produit where VId='" + id + "' ");
	%>
	
	<script type="text/javascript">
    <%if (request.getAttribute("msg") != null) {%>
        alert("<%=request.getAttribute("msg")%>");
	<%}%>
		
	</script>

	<div class="Conteneur1">

		<h1>Enregistrement des Produits</h1>
		<br>

		<form action="AjoutPS" method="post">

			<%
				if (request.getAttribute("id") != null) {
			%>
			<input type="hidden" name="id"
				value="<%=request.getAttribute("id")%>"><br>
			<br>
			<%
				} else {
			%>
			<input type="hidden" name="id" placeholder="L'id du Produit"><br>
			<br>
			<%
				}
			%>

			<%
				if (request.getAttribute("nomP") != null) {
			%>
			<input type="text" name="nomP"
				value="<%=request.getAttribute("nomP")%>"
				placeholder="Le Nom du Produit" required><br>
			<br>
			<%
				} else {
			%>
			<input type="text" name="nomP" placeholder="Le Nom du Produit"
				required><br>
			<br>
			<%
				}
			%>

			<%
				if (request.getAttribute("categorie") != null) {
			%>
			<input type="text" name="categorie"
				value="<%=request.getAttribute("categorie")%>"
				placeholder="La Catégorie" required><br>
			<br>
			<%
				} else {
			%>
			<input type="text" name="categorie" placeholder="La Catégorie"
				required><br>
			<br>
			<%
				}
			%>

			<%
				if (request.getAttribute("quantite") != null) {
			%>
			<input type="text" name="quantite"
				value="<%=request.getAttribute("quantite")%>"
				placeholder="Precisez la Quantité" required><br>
			<br>
			<%
				} else {
			%>
			<input type="text" name="quantite" placeholder="Precisez la Quantité"
				required><br>
			<br>
			<%
				}
			%>

			<%
				if (request.getAttribute("prix") != null) {
			%>
			<input type="text" name="prix"
				value="<%=request.getAttribute("prix")%>"
				placeholder="Entrez le Prix" required><br>
			<br>
			<%
				} else {
			%>
			<input type="text" name="prix" placeholder="Entrez le Prix" required><br>
			<br>
			<%
				}
			%>

			<%
				if (request.getAttribute("image") != null) {
			%>
			<input type="file" name="image"
				value="<%=request.getAttribute("image")%>"><br>
			<br>
			<%
				} else {
			%>
			<input type="file" name="image"><br>
			<br>
			<%
				}
			%>

			<button type="submit" name="action" value="enregistrer">Enregistrer</button>
			<br>
			<br>
			<button type="submit" name="action" value="modifier">Modifier</button>

		</form>
	</div>


	<h2 align="center">Catégorie T-shirt</h2>

	<div class="shirts">

		<div class="row">
           <% rs.beforeFirst(); %>
			<%
				while (rs.next()) {
			%>

			<%
				if (rs.getString("categorie").equalsIgnoreCase("T-Shirt") || rs.getString("categorie").equalsIgnoreCase("T Shirt")
					|| rs.getString("categorie").equalsIgnoreCase("TShirt")
					|| rs.getString("categorie").equalsIgnoreCase("TShirts")) {
			%>

			<div class="T">
				<img src="IMAGE/<%=rs.getString("image")%>" alt="UDUPIRA">

				<P>
					Nom:<%=rs.getString("Nom")%><br> <br> Prix:<%=rs.getInt("Prix")%>
					Fbu<br> <br> Quantite en Stock :<%=rs.getInt("Quantite")%><br>
					<br>
				</p>

				<a
					href="AjoutPS?id=<%=rs.getInt(1)%>&nomP=<%=rs.getString(2)%>&categorie=<%=rs.getString(3)%>&quantite=<%=rs.getInt(4)%>&prix=<%=rs.getInt(5)%>&image=<%=rs.getString(6)%>&action=modifier"
					class="lien">Modifier</a> <a
					href="AjoutPS?id=<%=rs.getInt(1)%>&action=supprimer" class="lien">Supprimer</a>

			</div>

			<%
				}
			%>

			<%
				}
			%>
		</div>

	</div>

	<h2 align="center">Catégorie chaussures</h2>


	<div class="chaussures">

		<div class="row">
         <% rs.beforeFirst(); %>
			<%
				while (rs.next()) {
			%>

			<%
				if (rs.getString("categorie").equalsIgnoreCase("Chaussure")
					|| rs.getString("categorie").equalsIgnoreCase("ChaussureS")) {
			%>

			<div class="C1">
				<img src="IMAGE/<%=rs.getString("image")%>" alt="CHAUSSURE">

				<P>
					Nom:<%=rs.getString("Nom")%><br> <br> Prix:<%=rs.getInt("Prix")%>
					Fbu<br> <br> Quantite en Stock :<%=rs.getInt("Quantite")%><br>
					<br>
				</p>

				<a
					href="AjoutPS?id=<%=rs.getInt(1)%>&nomP=<%=rs.getString(2)%>&categorie=<%=rs.getString(3)%>&quantite=<%=rs.getInt(4)%>&prix=<%=rs.getInt(5)%>&image=<%=rs.getString(6)%>&action=modifier"
					class="lien">Modifier</a> <a
					href="AjoutPS?id=<%=rs.getInt(1)%>&action=supprimer" class="lien">Supprimer</a>

			</div>

			<%
				}
			%>
			<%
				}
			%>

		</div>

	</div>

	<h2 align="center">Catégorie Pantalons</h2>


	<div class="pantalons">

		<div class="row">
           <% rs.beforeFirst(); %>
			<%
				while (rs.next()) {
			%>

			<%
				if (rs.getString("categorie").equalsIgnoreCase("Pantalon") || rs.getString("categorie").equalsIgnoreCase("PantalonS")) {
			%>

			<div class="C1">
				<img src="IMAGE/<%=rs.getString("image")%>" alt="pantalon">

				<P>
					Nom:<%=rs.getString("Nom")%><br> <br> Prix:<%=rs.getInt("Prix")%>
					Fbu<br> <br> Quantite en Stock :<%=rs.getInt("Quantite")%><br>
					<br>
				</p>

				<a
					href="AjoutPS?id=<%=rs.getInt(1)%>&nomP=<%=rs.getString(2)%>&categorie=<%=rs.getString(3)%>&quantite=<%=rs.getInt(4)%>&prix=<%=rs.getInt(5)%>&image=<%=rs.getString(6)%>&action=modifier"
					class="lien">Modifier</a> <a
					href="AjoutPS?id=<%=rs.getInt(1)%>&action=supprimer" class="lien">Supprimer</a>

			</div>

			<%
				}
			%>
			<%
				}
			%>

		</div>

	</div>

	<p>Contact:</p>


	<br>

</body>
<%@include file="include/Pied.jsp"%>
</html>