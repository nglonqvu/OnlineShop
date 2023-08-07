<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Account</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400" rel="stylesheet" />    
    </head>
    <body> 
        <jsp:include page="menu.jsp"></jsp:include>
            <div class="container">
                <main>
                    <header class="row tm-welcome-section">
                    <c:set var="a" value="${sessionScope.acc}"/>
                    <h3 class="col-12 text-center tm-section-title" style="margin-top: 10px;">Change password ${a.username}</h3>
                    <h3 style="color: red">${requestScope.ms}</h3>
                    <a href="home" target="_parent" class="tm-register" style="width: 100px;">
                        <i class="fa-solid fa-hand-back-point-left">Back</i>
                    </a>
                    <h2 class="col-12 text-center tm-section-title"></h2>

                    <form action="change?user=${a.username}" method="post" class="text-center">
                        <p class="text-center text-danger">${notice}</p>
                        <input type="text" name="opass" style="margin: 10px auto; padding: 0 30px;" class="form-control text-center" placeholder="Old password" required=""/>
                        <input type="text" name="newpass" style="margin: 10px auto; padding: 0 30px;" class="form-control text-center" placeholder="New password" required=""/>
                        <input type="text" name="renewpass" style="margin: 10px auto; padding: 0 30px;" class="form-control text-center" placeholder="Re-new password" required=""/>                       
                        <input type="submit" class="tm-btn tm-btn-success tm-btn" style="border-radius: 30px; border: 0;" value="Change"> 
                    </form>

                    <h2 class="col-12 text-center tm-section-title"></h2>
                    <h2 class="col-12 text-center tm-section-title"></h2> 
                    <h2 class="col-12 text-center tm-section-title"></h2>  
                </header>
            </main>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>

</html>
<script src="js/jquery.min.js"></script>
<script src="js/parallax.min.js"></script>
<script>
    $(document).ready(function () {
        // Handle click on paging links
        $('.tm-paging-link').click(function (e) {
            e.preventDefault();

            var page = $(this).text().toLowerCase();
            $('.tm-gallery-page').addClass('hidden');
            $('#tm-gallery-page-' + page).removeClass('hidden');
            $('.tm-paging-link').removeClass('active');
            $(this).addClass("active");
        });
    });
</script>