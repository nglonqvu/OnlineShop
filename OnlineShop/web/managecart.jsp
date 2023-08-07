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
    <h2 style="margin: 20px 0;">Manage Cart</h2>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered m-0">
                <thead>
                    <tr>
                        <th class="text-center py-3 px-4 text-center" style="width: 150px;">Username</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 200px;">Customer</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 400px;">Cart</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 100px;">Price</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 100px;">Status</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 150px;">Accept Cart</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 150px;">Delete cart</th>  
                    </tr>
                </thead>
                <tbody>
                    <c:forEach  items="${listHis}" var="h">
                        <tr>
                            <td class="align-middle p-4 text-center" >
                                <c:forEach  items="${listA}" var="a">
                                    <c:if test="${h.id == a.uID}">
                                        ${a.username}
                                    </c:if>
                                </c:forEach>
                            </td>   
                            <td class="align-middle p-4 text-center" >${h.name}<br>${h.city}<br>${h.address}<br>${h.phone}</td>  
                            <td class="p-4">
                                                <div class="media align-items-center" style="display: flex;">
                                                    <img  style="margin-left: 20px;" src="${h.pImg}" height="20%" width="20%" alt="">
                                                    &nbsp;&nbsp;&nbsp;<div class="media-body">
                                                       ${h.pName}
                                                    </div>
                                                     &nbsp;&nbsp;&nbsp;<div class="media-body">
                                                       Quantity : ${h.amount}
                                                    </div>
                                                </div>
                            </td><td class="align-middle p-4 text-center" >${h.amount*h.pPrice}$</td>
                            </td><td class="align-middle p-4 text-center" >${h.status}</td>
                            <td class="align-middle p-6">
                                <form class="align-middle" action="deuphis" method="get" style="text-align: center;">
                                    <input type="hidden" name="cartid" value="${h.cartid}">
                                    <button style="border: 0; color: red; background-color: white;" class="shop-tooltip close float-none" type="submit"><i class="fa-solid fa-check" style="font-size: 30px;"></i></button>
                                </form>
                            </td> 
                            <td class="align-middle p-6">
                                <form class="align-middle" action="deuphis" method="post" style="text-align: center;">
                                    <input type="hidden" name="cartid" value="${h.cartid}">
                                    <button style="border: 0; color: red; background-color: white;" class="shop-tooltip close float-none" type="submit"><i class="fa-solid fa-circle-xmark" style="font-size: 30px;"></i></button>
                                </form>
                            </td>
                              
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>        
</div>
