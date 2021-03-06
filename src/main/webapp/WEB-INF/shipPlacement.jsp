<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JavaCourses1
  Date: 01.02.2018.
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sea Battle field</title>
</head>
<body>


<c:set var="myField" value="${playerGameContext.player.myField}"/>


<form method="post">
    <table style="text-align: center">
        <tr>
        <c:forEach var="col" items=" ,A,B,C,D,E,F,G,H,I,J">
            <td>${col}</td>
        </c:forEach>
        </tr>
        <c:forEach var="row" begin="1" end="10">
            <tr>
                <td>${row}</td>
                <c:forEach var="col" items="A,B,C,D,E,F,G,H,I,J">
                    <c:set var="addr" value="${col}${row}"/>
                    <td class="${myField.getCell(addr)}">
                        <input type="checkbox" name="addr"
                               value="${addr}" ${myField.hasShip(addr) ? "checked" : ""}>
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Start!">
</form>


<c:if test="${myField.invalid}">
    <div class="w3-display-top w3-panel w3-red">
        <h3>Sorry!</h3>
        <p>Your ships are not placed correctly. Please check and correct.</p>
    </div>
</c:if>


</body>
</html>
