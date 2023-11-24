<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/pied.css">
</head>
<body>


	<footer class="footer"> @2023 NickShop sa Designed by NickBa </footer>

	<script>
		function adjustFooterPosition() {
			var contentHeight = document.documentElement.offsetHeight;
			var windowHeight = window.innerHeight;
			var footer = document.getElementById('footer');

			if (contentHeight < windowHeight) {
				footer.style.position = 'fixed';
				footer.style.bottom = '0';
			} else {
				footer.style.position = 'static';
			}
		}

		// Appeler la fonction lors du chargement de la page
		window.addEventListener('load', adjustFooterPosition);
		// Appeler la fonction lors du redimensionnement de la fenêtre
		window.addEventListener('resize', adjustFooterPosition);
	</script>
</body>
</html>