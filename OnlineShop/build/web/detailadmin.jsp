<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/detail.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/home.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
    </head>
    <body>
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
            <div class="row" style="margin: 30px">
                <div class="col-sm-9">
                    <div class="container">
                        <div class="card">
                            <div class="row">
                                <aside class="col-sm-5 border-right">
                                    <article class="gallery-wrap"> 
                                        <div class="img-big-wrap">
                                            <div> <a href="#"><img src="${detailP.image}"></a></div>
                                        </div>
                                        <div class="img-small-wrap">
                                        </div>
                                    </article>
                                </aside>
                                <aside class="col-sm-7">
                                    <article class="card-body p-5">
                                        <h3 class="title mb-3">${detailP.name}</h3>

                                        <p class="price-detail-wrap"> 
                                            <span class="price h3"> 
                                                <span class="currency"></span>Price: <span class="num" style="color:
                                                                                           red">${detailP.money}$</span>
                                            </span> 
                                        </p>
                                        <dl class="item-property">
                                            <dt>Description:</dt>
                                            <dd><p>
                                                    ${detailP.description}
                                                </p></dd>
                                        </dl>


                                        <div class="row">
                                            <div class="col-sm-5">
                                                <dl class="param param-inline">
                                                    <dt>Quantity: </dt>
                                                    <form name="f" action="cart?pid=${detailP.id}&uid=${sessionScope.acc.uID}" method="post" style="width:70px;">
                                                        <input type="text" name="quantity" value="1"/>
                                                        <input type="submit" style="margin-top: 15px; height: 50px; width: 187px;"
                                                               value="Add to cart"
                                                               class="btn btn-lg btn-outline-primary text-uppercase"/>                                                  
                                                    </form>
                                                </dl>
                                            </div>
                                        </div>
                                    </article>
                                </aside>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
