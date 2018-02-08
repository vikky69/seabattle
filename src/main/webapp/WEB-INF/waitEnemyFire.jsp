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
    <meta http-equiv="refresh" content="5">
    <title>Sea Battle field</title>

    <style>
        form{
            text-align: center;
        }

        table{
            border-collapse: collapse;
        }
        td {
            width: 30px;
            height: 30px;
            text-align: center;
            border: 1px solid black;
        }


           td.SHIP {
           background-color: darkgrey;
           }

        td.HIT {
            background-color: red;
        }

        td.MISS {
            background-color: aqua;
        }



           </style>

</head>
<body>


<c:set var="myField" value="${playerGameContext.player.myField}"/>
<c:set var="enemyField" value="${playerGameContext.player.enemyField}"/>

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


                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>

</form>


<div>
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
                    <td class="${enemyField.getCell(addr)}">

                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>

</div>


</body>
</html>
