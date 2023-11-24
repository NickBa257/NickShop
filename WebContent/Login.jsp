<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/login.css">

</head>
<body>

	<script type="text/javascript">
    <%if (request.getAttribute("msg") != null) {%>
        alert("<%=request.getAttribute("msg")%>");
	<%}%>
		
	</script>

	<div class="Conteneur">

		<h1>Page de connexion</h1>

		<form action="LoginS" method="post">

			<input type="text" name="ident" placeholder="Votre Identifiant"
				required> <br> <br> <input class="input2"
				type="password" name="pass" placeholder="Votre Mot de Passe"
				required> <br>

			<button type="submit">Se connecter</button>
		</form>

		<br> <a href="Enre.jsp">Créer un compte</a>
		
	</div>

</body>
</html>
