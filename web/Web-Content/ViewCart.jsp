<%-- 
    Document   : ViewCart
    Created on : Dec 19, 2019, 6:11:20 AM
    Author     : Beloyten
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/PhoneSellingMarket/CSS_Style/Home.css" rel="stylesheet" type="text/css"/>
        <title>ViewCart</title>
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
                    <h1 class="title">Cart</h1>
                    <c:forEach items="${carts}" var="row">
                        <c:if test = "${row.status==0}"> 
                        
                        <Div id="linePaginCafe">
                            <a class="fontBlack noneLine" href="/PhoneSellingMarket/DetailController?ID=${row.productID}">
                                <h1 class="fontTimeNewRoman">${row.name}</h1></a>
                            <div id="contentDetail">
                                <span>
                                   <img class="imgCart floatRight" src="${row.picture}"/>
                                    <p class="fontSortDescription magin">Quantity: ${row.quantity}</p>
                                    <p class="fontSortDescription magin" value = "">Price:    ${row.price * row.quantity}VND</p>
                                    <p class="fontSortDescription magin" value = ""></p>
                                </span>
                            </div>
                        </Div>
                                    </c:if>
                    </c:forEach>
                    <!--display number pagination-->
                   
                </div>
                <!-- the advertising -->

            </div>
            <!--Display the footer of pages-->
           
        </div>
    </body>
</html>