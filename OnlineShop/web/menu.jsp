<%-- 
    Document   : Menu
    Created on : Mar 4, 2023, 5:29:29 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/home.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<!--begin of menu-->
<nav class="navbar navbar-expand-lg navbar-light">
    <div class="container">
        <a class="navbar-brand" href="#!">
            <img src="image/logo.png">
        </a>
        <div class="ban collapse navbar-collapse" id="navbarSupportedContent">
            <form method="get" action="search" class="form-inline ms-auto ">
                <ul class="navbar-nav">
                    <div class="search-dad"><input class="form-control" type="search" placeholder="Search" name="search"
                                                   aria-label="Search">
                        <div class="search"><button class="btn " type="submit"><i
                                    class="fa-solid fa-magnifying-glass"></i></button></div>
                    </div>
                </ul>
            </form>
        </div>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <form class="d-flex ms-auto">
                <button class="btn_cart" type="submit">
                    <a href="detail_cart.jsp" style="text-decoration: none; color: black;">
                        <i class="bi-cart-fill me-1"></i><i class="fa-solid fa-cart-shopping"></i> 
                        Cart
                        <span class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.size}</span>
                    </a>
                </button>
            </form>
        </div>
    </div>
</nav>
<!-- Header-->
<header class="header">
    <ul class="menu">
        <li class="tag"><a href="home"><i class="fa-solid fa-house"></i> Home</a></li>
        <li class="tag has_submenu">
            <a href="#"><i class="fa-solid fa-mobile-screen"></i> Phone</a>
            <ul class="sub_menu dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                <c:forEach items="${listC}" var="o">
                    <li class="cate"><a class="dropdown-item" href="category?cateID=${o.cateID}">${o.cateName}</a></li>
                   
                    </c:forEach> 
                    <li>abc</li>
            </ul>
        </li>
        <li class="tag"><a href="category?cateID=5"><i class="fa-solid fa-laptop"></i> Laptop</a></li>
            <c:if test="${sessionScope.acc == null}">
            <li class="tag login" style="margin-left: 63%;"><a href="login.jsp">Login <i class="fa-solid fa-left-to-line"></i></a>
            </li>
        </c:if>
        <c:if test="${sessionScope.acc != null}">
            <li class="tag has_submenu" style="margin-left: 64%; margin-right: 10px; padding: 13px 5px 0 5px;">
                <a href="#"><i class="fa-solid fa-user"></i> ${sessionScope.acc.username}</a>
                <ul  class="sub_menu dropdown-menu dropdown-menu-dark" 
                     aria-labelledby="navbarDarkDropdownMenuLink">                 
                    <li class="logout"><a href="changepass.jsp">Change password</a></li>
                    <li class="logout"><a href="logout">Logout</a></li>
                    <li class="logout"><a href="home_history?uid=${sessionScope.acc.uID}">History</a></li>
                </ul>
            </li>

        </c:if>
    </ul>
</header>
<!--end of menu-->
