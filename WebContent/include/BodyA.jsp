<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="modele.*,java.sql.*,controlleur.*,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/Body.css">
</head>
<body>

	<%
		ArrayList<Produit> tabP = Outils.getProduit();
	%>

	<h2 align="center">Catégorie T-shirt</h2>

	<div class="shirts">

		<div class="row">

			<%
				for (Produit p : tabP) {
			%>

			<%
				if (p.getCategorie().equalsIgnoreCase("T-Shirt") || p.getCategorie().equalsIgnoreCase("T Shirt")
						|| p.getCategorie().equalsIgnoreCase("TShirt") || p.getCategorie().equalsIgnoreCase("TShirts")) {
			%>

			<div class="T">
				<img src="IMAGE/<%=p.getImage()%>" alt="UDUPIRA">

				<P>
					Nom:<%=p.getNom()%><br>
					<br> Prix:<%=p.getPrix()%>
					Fbu<br>
					<br> Quantite en Stock :<%=p.getQuantite()%><br>
					<br>
				</p>


				<form method="post">

					<button type="submit" formaction="PanierS?id=<%=p.getP_id()%>">Ajouter
						au panier</button>
					<br>
					<button type="submit" formaction="CommandeS?total=<%=p.getPrix()%>&id=<%=p.getP_id()%>">Commander</button>

				</form>

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

			<%
				for (Produit p : tabP) {
			%>

			<%
				if (p.getCategorie().equalsIgnoreCase("Chaussure") || p.getCategorie().equalsIgnoreCase("ChaussureS")) {
			%>

			<div class="1C">
				<img src="IMAGE/<%=p.getImage()%>" alt="CHAUSSURE">

				<P>
					Nom:<%=p.getNom()%><br>
					<br> Prix:<%=p.getPrix()%>
					Fbu<br>
					<br> Quantite en Stock :<%=p.getQuantite()%><br>
					<br>
				</p>

				<form method="post">

					<button type="submit" formaction="PanierS?id=<%=p.getP_id()%>">Ajouter
						au panier</button>
					<br>
					<button type="submit" formaction="CommandeS?total=<%=p.getPrix()%>&id=<%=p.getP_id()%>">Commander</button>

				</form>
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

			<%
				for (Produit p : tabP) {
			%>

			<%
				if  (p.getCategorie().equalsIgnoreCase("Pantalon") || p.getCategorie().equalsIgnoreCase("PantalonS")) {
			%>

			<div class="1C">
				<img src="IMAGE/<%=p.getImage()%>" alt="pantalon">

				<P>
					Nom:<%=p.getNom()%><br>
					<br> Prix:<%=p.getPrix()%>
					Fbu<br>
					<br> Quantite en Stock :<%=p.getQuantite()%><br>
					<br>
				</p>

				<form method="post">

					<button type="submit" formaction="PanierS?id=<%=p.getP_id()%>">Ajouter
						au panier</button>
					<br>
					<button type="submit" formaction="CommandeS?total=<%=p.getPrix()%>&id=<%=p.getP_id()%>">Commander</button>

				</form>
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


</body>
</html>