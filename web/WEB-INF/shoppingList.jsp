
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>register</title>
    </head>
    <body>
        <h1>Hello ${username}</h1><a href ="shoppingList?logout">Log Out</a><br>
        <h1>List</h1>
        <form action="shoppingList" method="post">
                Add Item: <input type="text" name="item">
                <input type="submit">
                <input type="hidden" name="action" value="add">
        </form><br>
        <form action="shoppingList" method="post">
        <table border="1">
            <c:forEach var="item" items="${items}" varStatus="status">
                <tr>
                    <td><input type="radio" name="list" value="${status.index}">${item}</td>
                </tr>
            </c:forEach>
        </table>        
                <input type="submit" value="Delete">
                <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
