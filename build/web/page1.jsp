<%-- 
    Document   : page1
    Created on : Jun 27, 2019, 12:58:12 PM
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
        <% String username = request.getParameter("username");
        
        if(!username.equals("admin")){
            throw new Exception ("Unauthorized Access");
        } else {
            %>
            <jsp:include page="page2.jsp">
                <jsp:param name="secret-key" value="<%=secretKey %>" />
            </jsp:include>
        <%}%>
        <%! private String secretKey = "1234"; %>
    </body>
</html>
