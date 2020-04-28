<%-- 
    Document   : index
    Created on : Apr 28, 2020, 9:27:12 AM
    Author     : adesh
--%>

<%@page import="com.doubt.domain.Doubt" %>
<%@page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--
    ItemDao itemData = DataConnection.getItemDao();
    List<Items> itemsList = itemData.getFullItems();
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VNIT DOUBT Portal</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h1>VNIT DOUBT PORTAL Portal</h1>
        <h2>List of Items:</h2>
        <ul>
            <%-- <%
                for(Items item: itemsList){
                out.println("<li>" + item + "</li>");
            }
            %> --%>
            
            <c:forEach items="${doubtsList}" var="doubts">
                <li><p>${doubts.name}</p>
                    <p>${doubts.question}</p>
                    <p>${doubts.answer}</p>
                    </li>
            </c:forEach>
        </ul>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
