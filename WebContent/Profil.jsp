<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="modele.*,controlleur.*,java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/profil.css">
</head>
<body>

    <%
    Acheteur acheteur = null;
    Vendeur vendeur = null;

    if (session.getAttribute("Acheteur") instanceof Acheteur) {
        acheteur = (Acheteur) session.getAttribute("Acheteur");
    } else if (session.getAttribute("Vendeur") instanceof Vendeur) {
        vendeur = (Vendeur) session.getAttribute("Vendeur");
    }
    %>
    
    <%if(acheteur==null){%>
     
      <%@include file="include/teteV.jsp" %>
   
     <% }else {%>
     
      <%@include file="include/teteA.jsp" %>

     <%}%>
    

    <h1>Votre Compte</h1>

    <form action="ProfilS" method="post">

        <label for="nom">Nom: </label>
        <% if (acheteur != null) {%>
            <input type="text" name="nom" value="<%=acheteur.getNom() %>" required><br><br>
        <%} else if (vendeur != null) {%>
            <input type="text" name="nom" value="<%=vendeur.getNom()%>" required><br><br>
        <%} else {%>
            <input type="text" name="nom" placeholder="Votre nom et prenom" required><br><br>
        <%}%>

        <label for="adresse">Adresse: </label>
        <% if (acheteur != null) {%>
            <input type="text" name="adresse" value="<%=acheteur.getAdresse()%>" required><br><br>
        <%} else if (vendeur != null) {%>
            <input type="text" name="adresse" value="<%=vendeur.getAdresse()%>" required><br><br>
        <%} else {%>
            <input type="text" name="adresse" required><br><br>
        <%}%>

        <label for="tel">Numéro de Telephone:</label>
        <% if (acheteur != null) {%>
            <input type="number" name="tel" value="<%=acheteur.getTel()%>" required><br><br>
        <%} else if (vendeur != null) {%>
            <input type="number" name="tel" value="<%=vendeur.getTel()%>" required><br><br>
        <%} else {%>
            <input type="number" name="tel" required><br><br>
        <%}%>

        <label for="ident">Nom d'utilisateur: </label>
        <% if (acheteur != null) {%>
            <input type="text" name="ident" value="<%=acheteur.getIdent()%>" required><br><br>
        <%} else if (vendeur != null) {%>
            <input type="text" name="ident" value="<%=vendeur.getIdent()%>" required><br><br>
        <%} else {%>
            <input type="text" name="ident" required><br><br>
        <%}%>

        <label for="pass">Mot de passe: </label>
        <% if (acheteur != null) {%>
            <input type="text" name="pass" value="<%=acheteur.getPass()%>" required><br><br>
        <%} else if (vendeur != null) {%>
            <input type="text" name="pass" value="<%=vendeur.getPass()%>" required><br><br>
        <%} else {%>
            <input type="text" name="pass" required><br><br>
        <%}%>


        <button type="submit" name="action" value="modifier">Modifier</button>


    </form>
<br>
<br>

<%@ include file="include/Pied.jsp" %>

</body>
</html>