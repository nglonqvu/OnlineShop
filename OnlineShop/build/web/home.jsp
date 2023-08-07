<%-- 
    Document   : home
    Created on : Feb 21, 2023, 2:15:50 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.sql.*" %>
<%@page import = "model.Product"%>
<%@page import = "model.Category"%>
<%@page import = "java.util.*" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta(name='viewport', content='width=device-width, initial-scale=1, shrink-to-fit=no' )>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/home.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
    </head>

    <body>
        <!-- Navigation-->
        <jsp:include page="menu.jsp"></jsp:include>
        <!-- Product-->
        <div class="container">
            <div class="row">
                <c:if test="${listP == null}">
                    <h3>Not found product</h3>
                </c:if>
                <c:if test="${listP != null}">
                    <c:forEach items="${listP}" var="o">
                        <div class="col-md-3 product">
                            <div class="product_item">
                                <img src="${o.image}"/>
                                <div class="product_content">
                                    <p style="margin-top: 20px; font-size: 19px; font-weight: 500;">
                                        <a href="detail?pid=${o.id}" style="text-decoration: none; color: black;">
                                            ${o.name}
                                        </a>
                                    </p>
                                    <p>Price: <span>${o.money}$</span></p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <!-- Footer-->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>