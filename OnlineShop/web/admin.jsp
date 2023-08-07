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
        <div class="collapse navbar-collapse" id="navbarSupportedContent">

        </div>
    </div>
</nav>
<!-- Header-->
<header class="header">
    <ul class="menu">
        <li class="tag"><a href="homeadmin"><i class="fa-solid fa-house"></i> Home</a></li>
        <li class="tag has_submenu">
            <a href="#"> Category</a>
            <ul class="sub_menu dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                <li class="cate"><a class="dropdown-item" href="insertcate.jsp">Insert</a></li>
                <li class="cate"><a class="dropdown-item" href="deletecate.jsp">Delete&Update</a></li>
            </ul>
        </li>
        <li class="tag has_submenu">
            <a href="#"> Product</a>
            <ul class="sub_menu dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                <li class="cate"><a class="dropdown-item" href="insertproduct.jsp">Insert</a></li>
                <li class="cate"><a class="dropdown-item" href="deleteproduct.jsp">Delete&Update</a></li>
            </ul>
        </li>
        <li class="tag"><a href="account">Manage Account</a></li>
        <li class="tag"><a href="mngcus">Manage Customer</a></li>
        <li class="tag has_submenu" style="margin-left: 33%; margin-right: 10px; padding: 13px 5px 0 5px;">
            <a href="#"><i class="fa-solid fa-user"></i> ${sessionScope.acc.username}</a>
            <ul  class="sub_menu dropdown-menu dropdown-menu-dark" 
                 aria-labelledby="navbarDarkDropdownMenuLink">                 
                <li class="logout"><a href="changepass.jsp">Change password</a></li>
                <li class="logout"><a href="logout">Logout</a></li>
            </ul>
        </li>         
    </ul>
</header>
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
                                
                                    ${o.name}
                                
                            </p>
                            <p>Price: <span>${o.money}$</span></p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
</div>
<!--end of menu-->
