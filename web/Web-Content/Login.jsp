<%-- 
    Document   : AdminLogin
    Created on : Jun 11, 2018, 8:11:12 AM
    Author     : hieu bach
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="/PhoneSellingMarket/CSS_Style/Home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="mainBoxShadow">
            <!-- the big header content logo and sub blog -->
            <%@include file="header.jsp" %>
            <c:if test="${param.error != null}">
                <script>
                    alert("${param.error}");
                </script>
            </c:if>
                <form action="../LoginController" style="text-align: center;">
                <h2>Welcome to Loan's Phone </h2>
                <table style="margin-left: 400px;">
                    <tr>
                        <th>Username</th>
                        <td><input value="" name="username"></td>
                    </tr>
                    <tr>
                        <th>Password</th>
                        <td><input type="password" name="password" value=""></td>
                    </tr>
                </table>
                <br>
                <input type="submit" value="Login" style="width: 10%;margin-left: 0px" />
            </form>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
