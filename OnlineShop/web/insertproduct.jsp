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
    <div class="insert text-center">
        <h2 style="margin: 20px 0;">ADD PRODUCT</h2>
        <form action="insertproduct" method="POST" >
            <p class="text-danger">${err}</p>
            <input type="text" class="text-center" style="border: 2px solid black; border-radius: 10px; padding: 4px 15px; width: 40%; margin: 0 0 10px;" 
                   placeholder="Name" name="name" required=""><br>  
            <input type="url" class="text-center" style="border: 2px solid black; border-radius: 10px; padding: 4px 15px; width: 40%; margin: 0 0 10px;"
                   placeholder="Image" name="img" required=""><br> 
            <input type="text" class="text-center" style="border: 2px solid black; border-radius: 10px; padding: 4px 15px; width: 40%; margin: 0 0 10px;" 
                   placeholder="Price" name="price" required=""><br>  
            <input type="text" class="text-center" style="border: 2px solid black; border-radius: 10px; padding: 4px 15px; width: 40%; margin: 0 0 10px;"
                   placeholder="Title" name="title" required=""><br>
            <input type="text" class="text-center" style="border: 2px solid black; border-radius: 10px; padding: 4px 15px; width: 40%; margin: 0 0 10px;" 
                   placeholder="Description" name="des" required=""><br>  
            <select name="cate" class="form-control text-center" style="
                    border: 2px solid black; border-radius: 10px; padding: 4px 15px; width: 40%;
                    margin: 0 0 10px 388px;"
                    required="">
                <option>Choose category</option>
                <c:forEach items="${sessionScope.listC1}" var="o">
                    <option value="${o.cateID}">${o.cateName}</option>
                </c:forEach>
            </select>
            <input type="text" class="text-center" style="border: 2px solid black; border-radius: 10px; padding: 4px 15px; width: 40%; margin: 0 0 10px;"
                   placeholder="Quantity" name="quantity" required=""><br>
            <input type="submit" value="Add">
        </form>
    </div>        
</div>