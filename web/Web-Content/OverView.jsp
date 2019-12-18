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
                
                <form name="form1" method="get" style="margin-left: 700px;" action="servlet/PrintResultsServlet"> 

                    <select name="Events">
                        <option value="0" selected>Select Catalogue</option>
                        <option value="100M Run">100M Run</option>
                        <option value="200M Run">200M Run</option>
                        <option value="400M Run">400M Run</option>
                        <option value="800M Run">800M Run</option>
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
                    <c:forEach items="${arrBlog}" var="row">
                        <Div id="linePaginCafe">
                            <a class="fontBlack noneLine" href="/J3.L.P0015/DetailController?ID=${row.id}">
                                <h1 class="fontTimeNewRoman">${row.title}</h1></a>
                            <div id="contentDetail">
                                <span>
                                    <img class="imgDetail floatRight" src="${row.picture}"/>
                                    <p class="fontSortDescription magin">${row.sortContent}</p>
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
                                <a class="deactivation" href="OverViewController?CurrentPage=${num.number}">
                                    <c:out value="${num.number}"/>
                                </a>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
                <!-- the advertising -->
                
            </div>
            <!--Display the footer of pages-->
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
