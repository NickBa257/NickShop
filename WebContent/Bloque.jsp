<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Compte à rebours</title>
</head>
<body>
    <h1>Compte à rebours</h1>
    <p>Temps restant avant la fin du blocage : <%= getRemainingTime(request) %></p>
    <%!
        public String getRemainingTime(HttpServletRequest request) {
         
            Cookie[] cookies = request.getCookies();
            long tps=0;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("TpsB")) {
                        tps = Long.parseLong(cookie.getValue());
                        break;
                    }
                }
            }
               
            long minutes = (tps/1000) /60 ;
            long seconds = (tps/1000) % 60;
            
            return minutes + " minutes " + seconds + " secondes";
        }
    %>
</body>
</html>