<%-- 
    Document   : Detail
    Created on : Jun 1, 2018, 11:37:17 AM
    Author     : duydnse04661
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/PhoneSellingMarket/CSS_Style/Home.css" rel="stylesheet" type="text/css"/>
        <title>View Cart</title>
    </head>
    <body>
        <div id="mainBoxShadow">
            <!-- the big header content logo and sub blog -->
            <%@include file="header.jsp" %>
            <!-- the menu bar background color red -->
            <div id="menuBar">
                <a href="/PhoneSellingMarket/HomeContronller" class="subMenuBar noneLine fontBold">Home</a>
                <a href="/PhoneSellingMarket/CartController" class="subMenuBar noneLine ">View Cart</a>
                <a href="/PhoneSellingMarket/LoginController" class="subMenuBar noneLine">Logout</a>
            </div>
            <!-- display all content and advertising -->
            <div id="bigContener">
                <!-- display all blog (list blog) -->
                <div id="listBlogs" class="fontArial">
                    <!-- display sub content -->
                    <h1 class="fontTimeNewRoman">${product.productName}:${product.price}$</h1>
                    <div id="contentDetail">
                        <span>
                            <img class="imgDetail floatRight" src="${product.pricture}"/>
                            <p class="fontSortDescription magin">${product.productContent}</p>
                            <br>
                            <form method="GET" style="text-align: center;">
                                <input value="" name="quantity">
                                <input type ="hidden" name ="ID" value="<%= request.getParameter("ID") %>">
                                <button type="submit">Add to cart</button>
                            </form>
                        </span>
                    </div>
            </div>
                <!-- the advertising -->
                
            </div>
            <!--Display the footer of pages-->
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
