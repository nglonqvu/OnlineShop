<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Product"%>
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
            <main> 
                <div class="container px-3 my-5 clearfix"></div>
                <!-- Shopping cart table -->
                <div class="card">
                    <div class="card-header">
                        <h2>History</h2>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered m-0">
                                <thead>
                                    <tr>
                                        <th class="text-center py-3 px-4 text-center" style="width: 150px;">Customer</th>                                           
                                        <th class="text-center py-3 px-4 text-center" style="width: 300px;">Product</th>
                                        <th class="text-center py-3 px-4 text-center" style="width: 100px;">Status</th>  
                                        <th class="text-center py-3 px-4 text-center" style="width: 100px;">
                                            Cancel Order</th>
                                    </tr>
                                </thead>
                                <tbody>    

                                <c:forEach items="${sessionScope.listH}" var="h">
                                    <c:set var="total" value="${ h.amount * h.pPrice}" />
                                    <c:set var="sum" value="${total+sum}"/>                     
                                    <tr>
                                        <td class="p-4">
                                            <div>
                                                Name : ${h.name}<br>
                                                City: ${h.city} <br>
                                                Address: ${h.address}<br> 
                                                Phone : ${h.phone}
                                            </div>
                                        </td>
                                        <td class="align-middle p-4 text-center" style="display: flex;"> 
                                            <img  style="margin-left: 20px;" src="${h.pImg}" height="15%" width="15%" alt="">
                                            <div class="media-body" style="display: flex;">
                                                <a  style="text-decoration: none; margin-left: 50px; font-weight: 20px;" class="d-block text-dark">${h.pName}</a>
                                                &nbsp;&nbsp;Quantity: ${h.amount}
                                                &nbsp;&nbsp;Price: ${total}
                                            </div>
                                        </td>
                                        <td  class="font-weight-semibold align-middle p-4 text-center" >${h.status}</td>  
                                        <td class="align-middle p-6">
                                            <form class="align-middle" action="cancel" method="post" style="text-align: center;">
                                                <input type="hidden" name="amountcancel" value="${h.amount}">
                                                <input type="hidden" name="pname" value="${h.pName}">
                                                <input type="hidden" name="cartid" value="${h.cartid}">
                                                <input type="hidden" name="uid" value="${h.id}">
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
        </main>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>


