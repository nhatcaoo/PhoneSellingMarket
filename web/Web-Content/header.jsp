<%-- 
    Document   : header
    Created on : Jun 27, 2018, 4:16:44 PM
    Author     : duydnse04661
--%>

<link href="/PhoneSellingMarket/CSS_Style/Home.css" rel="stylesheet" type="text/css"/>

<div id="bigHeader">
    <h1 class="magin logo">Loan's Phone</h1>
    <p class="colorWhite fontTimeNewRoman subLogo colorWhite">Bring your smartest technology devices to your home</p>
</div>
<div id="menuBar">

    <a href="/PhoneSellingMarket/HomeContronller" class="subMenuBar noneLine fontBold">Home</a>
    <a href="/PhoneSellingMarket/CartController" class="subMenuBar noneLine ">View Cart</a>
     <form name="form1" method="get" style="margin-left: 750px; margin-top: -20px;" action="LogoutServlet"> 
         <button type="submit" class="subMenuBar noneLine">Logout</button>            
     </form>
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