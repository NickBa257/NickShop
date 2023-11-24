<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>		
<%@page import ="modele.*,controlleur.*,java.sql.*" %>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/enre.css">
</head>
<body>

   <script type="text/javascript">
    <%if (request.getAttribute("msg") != null) {%>
        alert("<%=request.getAttribute("msg")%>");
	<%}%>
		
	</script>

   <div class="Conteneur">

		<h1>Page d'Enregistrement</h1><br>
		
	<form action="EnreS" method="post">
		 
			  <input type="text" name="nom" placeholder="Votre nom et prenom" required><br><br>
		  
		 
		
			  <input type="text" name="adresse" placeholder="Votre Adresse"required><br><br>
		
			
		
			  <input type="number" name="tel"  placeholder="Votre Numero de téléphone" required><br><br>
		    
		
		
		
			  <input type="text" name="ident"  placeholder="Votre Identifiant" required><br><br>
		  
				
		
			  <input type="text" name="pass" placeholder="Votre Mot de Passe" required><br><br>
		  
		     <label for="radio">Acheteur</label>
		     <input type="radio" name="radio" value="Acheteur">
		     
		     <label for="radio">Vendeur</label>
		     <input type="radio" name="radio" value="Vendeur"><br><br>

        <button type="submit">Enregistrer</button>
       
	</form>
	
	<a href="Login.jsp">Se connecter</a>
	
</div>

</body>
</html>