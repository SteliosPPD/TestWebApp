<%-- 
    Document   : page2
    Created on : Jun 27, 2019, 12:58:24 PM
    Author     : stpap
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String username = request.getParameter("username");
            String secretKey = request.getParameter("secret-key");
            out.println("Welcome " + username + ", your secret key is: " + secretKey);
            out.println(request.getRequestURI());
            %>
    </body>
</html>
