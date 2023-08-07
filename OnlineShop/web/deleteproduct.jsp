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

<div class="text-center">
    <h2 style="margin: 20px 0;">Delete&Update Product</h2>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered m-0">
                <thead>
                    <tr>
                        <th class="text-center py-3 px-4 text-center" style="width: 100px;">Name</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 200px;">Image</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 100px;">Price</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 100px;">Title</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 500px;">Description</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 50px;">Category</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 50px;">Quantity</th>                           
                        <th class="text-center align-middle py-3 px-0 text-center" style="width: 100px;"><a href="#" class="shop-tooltip float-none text-light">
                                <i class="ino ion-md-trash"></i></a>Remove</th>
                        <th class="text-center align-middle py-3 px-0 text-center" style="width: 100px;"><a href="#" class="shop-tooltip float-none text-light">
                                <i class="ino ion-md-trash"></i></a>Update</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach  items="${sessionScope.listP1}" var="p">
                        <tr>
                            <td class="align-middle p-4 text-center" >${p.name}</td>
                            <td class="align-middle p-4 text-center">
                                <img src="${p.image}" height="70%" width="70%" alt="">                                   
                            </td>
                            <td class="align-middle p-4 text-center" >${p.money}$</td>
                            <td class="align-middle p-4 text-center" >${p.title}</td>
                            <td class="align-middle p-4" >${p.description}</td>
                            <td class="align-middle p-4 text-center" >${p.cateId}</td>
                            <td class="align-middle p-4 text-center" >${p.quantity}</td>
                            <td class="align-middle p-6">
                                <form class="align-middle" action="deup" method="post" style="text-align: center;">
                                    <input type="hidden" name="pname" value="${p.name}">
                                    <button style="border: 0; color: red; background-color: white;" class="shop-tooltip close float-none" type="submit"><i class="fa-solid fa-x"></i></button>
                                </form>
                            </td>
                            <td class="align-middle p-6">
                                <form class="align-middle" action="deup" method="get" style="text-align: center;">
                                    <input type="hidden" name="pname" value="${p.name}">
                                    <button style="border: 0; color: red; background-color: white;" class="shop-tooltip close float-none" type="submit"><i class="fa-solid fa-wrench"></i></button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>        
</div>
