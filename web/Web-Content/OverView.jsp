<%-- 
    Document   : OverView
    Created on : Jun 1, 2018, 11:46:30 AM
    Author     : duydnse04661
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/PhoneSellingMarket/CSS_Style/Home.css" rel="stylesheet" type="text/css"/>
        <title>OverView Page</title>
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
                <form name="form1" method="get" style="margin-left: 750px; margin-top: -20px;" action="servlet/PrintResultsServlet"> 

                    <select name="Events">
                            <c:forEach items="${catalogues}" var="row">
                        
                        <option >${row.catalogueName}</option>
                            </c:forEach>
                    </select>
                </form>
                <form name="form2" method="POST" style="margin-left: 900px; margin-top: -20px;">
                    <button type="submit">OK</button>

                </form>

            </div>
            <!-- display all content and advertising -->
            <div id="bigContener">
                <!-- display all blog (list blog) -->
                <div id="listBlogs" class="fontArial">
                    
                    <!-- display sub content -->
                    <h1 class="title">Products</h1>
                    <c:forEach items="${Products}" var="row">
                        <Div id="linePaginCafe">
                            <a class="fontBlack noneLine" href="/PhoneSellingMarket/DetailController?ID=${row.productID}">
                                <h1 class="fontTimeNewRoman">${row.productName}</h1></a>
                            <div id="contentDetail">
                                <span>
                                   <img class="imgDetail floatRight" src="${row.pricture}"/>
                                    <p class="fontSortDescription magin">${row.productContent}</p>
                                </span>
                            </div>
                        </Div>
                    </c:forEach>
                    <!--display number pagination-->
                    <div id="numberPagination">
                        <c:forEach items="${arrNumPagination}" var="num">
                            <c:if test="${num.type==1}">
                                <a class="activation">
                                    <c:out value="${num.number}"/>
                                </a>
                            </c:if>
                            <c:if test="${num.type==2}">
                                <a class="deactivation" href="HomeContronller?CurrentPage=${num.number}">
                                    <c:out value="${num.number}"/>
                                </a>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
                <!-- the advertising -->

            </div>
            <!--Display the footer of pages-->
           
        </div>
    </body>
</html>
