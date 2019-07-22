<%-- 
    Document   : newstudent
    Created on : Jun 26, 2019, 11:58:10 AM
    Author     : stpap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Student</title>
    </head>
    <body>
        <jsp:useBean id="student" class="entities.Student" scope="page" />
        <jsp:setProperty name="student" property="surname" value="Tasos" />
        Student Surname :  <%= student.getSurname()%>
        
        <h1><%= request.getAttribute("title") %></h1>
        <form method="POST" action="InsertStudent">
            Name: <input name="name" type="text"/><br />
            Surname :<input name="surname" type="text"/><br />
            Grade: <input name="grade" type="number"/><br />
            BirthDate: <input name="birthdate" type="date"/><br />
            <input type="Submit" name="new" value="New Student"/><br />
            
        </form>
    </body>
</html>
