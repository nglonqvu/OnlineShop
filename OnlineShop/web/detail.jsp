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
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
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
