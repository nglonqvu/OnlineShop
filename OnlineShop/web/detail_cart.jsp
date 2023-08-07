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
                <div class="container px-3 my-5 clearfix">
                    <!-- Shopping cart table -->
                    <div class="card">
                        <div class="card-header">
                            <h2>Shopping Cart</h2>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered m-0">
                                    <thead>
                                        <tr>
                                            <th class="text-center py-3 px-4 text-center" style="width: 300px;">Product Name </th>
                                            <th class="text-center py-3 px-4 text-center" style="width: 100px;">Price</th>
                                            <th class="text-center py-3 px-4 text-center" style="width: 100px;">Quantity</th>

                                            <th class="text-center py-3 px-4 text-center" style="width: 100px;">Total</th>
                                            <th class="text-center align-middle py-3 px-0 text-center" style="width: 40px;"><a href="#" class="shop-tooltip float-none text-light" title="" data-original-title="Clear cart">
                                                    <i class="ino ion-md-trash"></i></a>Remove</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="p" value="${sessionScope.detailP}"/>
                                    <c:set var="o" value="${sessionScope.cart}"/>
                                    <c:set var="sum" value="0"/>
                                    <c:forEach  items="${o.items}" var="i">
                                        <tr>
                                            <td class="p-6">
                                                <div class="media align-items-center" style="display: flex;">
                                                    <img  style="margin-left: 20px;" src="${i.productImg}" height="15%" width="15%" alt="">
                                                    <div class="media-body">
                                                        <a  style="text-decoration: none; margin-left: 50px; font-weight: 20px;" 
                                                            href="detail?pid=${i.productId}" class="d-block text-dark">${i.productName}</a>
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="align-middle p-4 text-center" >${i.productPrice}</td>
                                            <td class="align-middle p-4" style="display: flex;">
                                                <c:if test="${i.amount >= p.quantity}">
                                                    <a style="text-decoration: none; font-size: 25px;" href="process?num=-1&id=${i.productId}"><i style="padding: 0 10px; color: black;" class="fa-solid fa-minus"></i></a>
                                                    <input style="width: 90%;padding-right: 30px; " class="form-control text-center" type="number" readonly="" value="${p.quantity}"/>
                                                </c:if>
                                                <c:if test="${i.amount < p.quantity}">
                                                    <a style="text-decoration: none; font-size: 25px;" href="process?num=-1&id=${i.productId}"><i style="padding: 0 10px; color: black;" class="fa-solid fa-minus"></i></a>
                                                    <input style="width: 90%;padding-right: 30px; " class="form-control text-center" type="number" readonly="" value="${i.amount}"/>
                                                    <a style="text-decoration: none; font-size: 25px;" 
                                                       href="process?num=1&id=${i.productId}">
                                                        <i style="padding: 0 10px; color: black;" class="fa-solid fa-plus"></i>
                                                    </a>
                                                </c:if>
                                                <c:if test="${p.quantity == 0}">
                                                    <input style="width: 90%;padding-right: 30px; " class="form-control text-center" type="number" readonly="" value="0"/>
                                                   
                                                </c:if>
                                            </td>

                                            <td  class="font-weight-semibold align-middle p-4 text-center" >${i.amount * i.productPrice}$</td>
                                            <c:set var="total" value="${ i.amount * i.productPrice}" />
                                            <c:set var="sum" value="${total+sum}"/>
                                            <td class="align-middle p-6">
                                                <form class="align-middle" action="process" method="post" style="text-align: center;">
                                                    <input type="hidden" name="pid" value="${i.productId}">
                                                    <button style="border: 0; color: red; background-color: white;" class="shop-tooltip close float-none" data-original-title="Remove" type="submit"><i class="fa-solid fa-x"></i></button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- / Shopping cart table -->
                        <div class="row py-5 p-4 bg-white rounded shadow-sm">
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold text-center">Information</div>
                                <div class="p-3 " style="position: relative;">
                                    <form class="text-center" action="customer" method="post">
                                        <input type="hidden" name="uid" value="${acc.uID}">
                                        <input type="hidden" name="status" value="wait">
                                        <input type="hidden" name="cartbuy" value="${sessionScope.cart}">
                                        <label>Name</label> <br>  
                                        <input class="text-center" style="border: 2px solid black; border-radius: 10px; padding: 5px 15px; width: 80%; margin: 0 0 10px;" 
                                               type="text" id="fname" name="infname" required=""><br>    
                                        <label>Phone</label>  <br>  
                                        <input class="text-center" style="border: 2px solid black; border-radius: 10px; padding: 5px 15px; width: 80%; margin: 0 0 10px;"
                                               type="text" id="lname" name="infphone" required=""><br>
                                        <label>City</label>  <br>                                      
                                        <select name="city" class="form-control text-center" style="
                                                border: 2px solid black;
                                                border-radius: 10px;
                                                padding: 5px 10px;
                                                width: 80%;
                                                margin: 0 0 10px 56px;"
                                                required="">
                                            <option>Choose your city</option>
                                            <option value="Hồ Chí Minh">Hồ Chí Minh</option>
                                            <option value="Hà Nội">Hà Nội</option>
                                            <option value="Đà Nẵng">Đà Nẵng</option>
                                            <option value="Cần Thơ">Cần Thơ</option>
                                            <option value=" Thừa Thiên - Huế"> Thừa Thiên - Huế</option>
                                            <option value="An Giang">An Giang</option>
                                            <option value="Bà Rịa-Vũng Tàu">Bà Rịa-Vũng Tàu</option>
                                            <option value="Bạc Liêu">Bạc Liêu</option>
                                            <option value="Bắc Kạn">Bắc Kạn</option>
                                            <option value="Bắc Giang">Bắc Giang</option>
                                            <option value="Bắc Ninh">Bắc Ninh</option>
                                            <option value="Bến Tre">Bến Tre</option>
                                            <option value="Bình Dương">Bình Dương</option>
                                            <option value="Bình Định">Bình Định</option>
                                            <option value="Bình Phước">Bình Phước</option>
                                            <option value="Bình Thuận">Bình Thuận</option>
                                            <option value="Cà Mau">Cà Mau</option>
                                            <option value="Cao Bằng">Cao Bằng</option>
                                            <option value="Đắk Lắk">Đắk Lắk</option>
                                            <option value="Đắk Nông">Đắk Nông</option>
                                            <option value="Điện Biên">Điện Biên</option>
                                            <option value="Đồng Nai">Đồng Nai</option>
                                            <option value="Đồng Tháp">Đồng Tháp</option>
                                            <option value="Gia Lai">Gia Lai</option>
                                            <option value="Hà Giang">Hà Giang</option>
                                            <option value="Hà Nam">Hà Nam</option>
                                            <option value="Hà Tây">Hà Tây</option>
                                            <option value="Hà Tĩnh">Hà Tĩnh</option>
                                            <option value="Hải Dương">Hải Dương</option>
                                            <option value="Hải Phòng">Hải Phòng</option>
                                            <option value="Hòa Bình">Hòa Bình</option>
                                            <option value="Hậu Giang">Hậu Giang</option>
                                            <option value="Hưng Yên">Hưng Yên</option>
                                            <option value="Khánh Hòa">Khánh Hòa</option>
                                            <option value="Kiên Giang">Kiên Giang</option>
                                            <option value="Kon Tum">Kon Tum</option>
                                            <option value="Lai Châu">Lai Châu</option>
                                            <option value="Lào Cai">Lào Cai</option>
                                            <option value="Lạng Sơn">Lạng Sơn</option>
                                            <option value="Lâm Đồng">Lâm Đồng</option>
                                            <option value="Long An">Long An</option>
                                            <option value="Nam Định">Nam Định</option>
                                            <option value="Nghệ An">Nghệ An</option>
                                            <option value="Ninh Bình">Ninh Bình</option>
                                            <option value="Ninh Thuận">Ninh Thuận</option>
                                            <option value="Phú Thọ">Phú Thọ</option>
                                            <option value="Phú Yên">Phú Yên</option>
                                            <option value="Quảng Bình">Quảng Bình</option>
                                            <option value="Quảng Nam">Quảng Nam</option>
                                            <option value="Quảng Ngãi">Quảng Ngãi</option>
                                            <option value="Quảng Ninh">Quảng Ninh</option>
                                            <option value="Quảng Trị">Quảng Trị</option>
                                            <option value="Sóc Trăng">Sóc Trăng</option>
                                            <option value="Sơn La">Sơn La</option>
                                            <option value="Tây Ninh">Tây Ninh</option>
                                            <option value="Thái Bình">Thái Bình</option>
                                            <option value="Thái Nguyên">Thái Nguyên</option>
                                            <option value="Thanh Hóa">Thanh Hóa</option>                                           
                                            <option value="Tiền Giang">Tiền Giang</option>
                                            <option value="Trà Vinh">Trà Vinh</option>
                                            <option value="Tuyên Quang">Tuyên Quang</option>
                                            <option value="Vĩnh Long">Vĩnh Long</option>
                                            <option value="Vĩnh Phúc">Vĩnh Phúc</option>
                                            <option value="Yên Bái">Yên Bái</option></select>
                                        <label>Address</label>  <br>
                                        <input class="text-center" style="border: 2px solid black; border-radius: 10px; padding: 5px 15px; width: 80%; margin: 0 0 10px;"
                                               type="text" id="lname" name="infaddress" required=""><br>
                                        <input type="submit" style="position: absolute;
                                               bottom: -30px;
                                               right: -40px;
                                               width: 100px;" class="btn btn-dark rounded-pill py-2 btn-block" value="Buy">
                                    </form>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold text-center">Total</div>
                                <div class="p-4">
                                    <ul class="list-unstyled mb-4">
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">PRICE</strong><strong>${sum}$</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">SHIP</strong><strong>5$</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong>10%</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">TOTAL</strong>
                                            <h5 class="font-weight-bolder">${sum + 5 + (sum*10/100)}$</h5>
                                        </li>
                                    </ul>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </main>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>


