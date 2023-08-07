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
    <h2 style="margin: 20px 0;">Manage Account</h2>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered m-0">
                <thead>
                    <tr>
                        <th class="text-center py-3 px-4 text-center" style="width: 100px;">User</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 100px;">Password</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 100px;">Customer</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 100px;">Admin</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 100px;">Ban</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 100px;">Upgrade to Admin</th>
                        <th class="text-center py-3 px-4 text-center" style="width: 100px;">Delete Admin</th>   
                    </tr>
                </thead>
                <tbody>
                    <c:forEach  items="${listA}" var="a">
                        <tr>
                            <td class="align-middle p-4 text-center" >${a.username}</td>   
                            <td class="align-middle p-4 text-center" >${a.password}</td>  
                            <td class="align-middle p-4 text-center" >${a.isIsSell()}</td>   
                            <td class="align-middle p-4 text-center" >${a.isIsAdmin()}</td>  
                            <td class="align-middle p-6">
                                <form class="align-middle" action="deupacc" method="post" style="text-align: center;">
                                    <input type="hidden" name="username" value="${a.username}">
                                    <button style="border: 0; color: red; background-color: white;" class="shop-tooltip close float-none" type="submit"><i class="fa-solid fa-ban"></i></button>
                                </form>
                            </td>
                            <td class="align-middle p-6">
                                <form class="align-middle" action="deupacc" method="get" style="text-align: center;">
                                    <input type="hidden" name="username" value="${a.username}">
                                    <button style="border: 0; color: red; background-color: white;" class="shop-tooltip close float-none" type="submit"><i class="fa-solid fa-hammer"></i></button>
                                </form>
                            </td>
                            <td class="align-middle p-6">
                                <form class="align-middle" action="account" method="post" style="text-align: center;">
                                    <input type="hidden" name="username" value="${a.username}">
                                    <button style="border: 0; color: red; background-color: white;" class="shop-tooltip close float-none" type="submit"><i class="fa-solid fa-hammer"></i></button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>        
</div>
