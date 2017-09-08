
<!-- Spring and JSP taglibs -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- Bootstrap core CSS -->
<link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/css/shop-homepage.css" rel="stylesheet">

</head>
<body>

	<spring:url value="/my.cart" var="goMyCartPage" htmlEscape="true" />
	<spring:url value="/my.orders" var="goMyOrders" htmlEscape="true" />
	<spring:url value="/details" var="showProductDetails" htmlEscape="true" />

	<spring:url value="/home" var="goHomePage" htmlEscape="true" />
	<spring:url value="/category" var="showByCategory" htmlEscape="true"/>
	<spring:url value="/brand" var="showByBrand" htmlEscape="true"/>
	<spring:url value="/my.cart/add" var="addProductToCart" htmlEscape="true"/>
	<spring:url value="/product/remove?id=" var="removeProduct" htmlEscape="true"/>
	<spring:url value="/login" var="goLoginPage" htmlEscape="true"/>
	<spring:url value="/logout" var="gologoutPge" htmlEscape="true" />
	
	<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="${ goHomePage }">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            
           <c:choose>
            	<c:when test="${ isLoginCase == 'correct' }">
            		<li class="nav-item">
		              <a class="nav-link" href="${ goMyCartPage }">My Cart</a>
		            </li>
		            <li class="nav-item">
		              <a class="nav-link" href="${ goMyOrders }">My Orders</a>
		            </li>
		            <li class="nav-item">
		              <a class="nav-link" href="#">Profile</a>
		            </li>
		            <li class="nav-item">
		              <a class="nav-link" href="#">Logout</a>
		            </li>
            	</c:when>
            	
            	<c:otherwise>
            		<li class="nav-item">
			            <a class="nav-link" href="${ goLoginPage }">Login</a>
			        </li>
            	</c:otherwise>            	
            </c:choose>
            
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <div class="col-lg-3">

          <h1 class="my-4">Categories</h1>
          <div class="list-group">
            <a href="${ showByCategory }/laptop" class="list-group-item">Laptop</a>
            <a href="${ showByCategory }/tablet" class="list-group-item">Tablet</a>
            <a href="${ showByCategory }/mobile" class="list-group-item">Smart Phone</a>
          </div>
          
          <br/>
          
          <c:if test="${ clickCategory != null }">
          	  <h1 class="my-4">Brands</h1>
	          <div class="list-group">
	            <a href="${ clickCategory }/apple" class="list-group-item">Apple</a>
	            <a href="${ clickCategory }/asus" class="list-group-item">Asus</a>
	            <a href="${ clickCategory }/lenova" class="list-group-item">Lenova</a>
	            <a href="${ clickCategory }/sonny" class="list-group-item">Sonny</a>
	            <a href="${ clickCategory }/samsung" class="list-group-item">Samsung</a>
	          </div>
          </c:if>

        </div>
        <!-- /.col-lg-3 -->

         <div class="col-md-9">
         		<br>
		      	<div class="row">
         			<div class="col-md-offset-3 col-md-4">
         				<h3>Products</h3>
         			</div>
         		</div>
		 		<div class="row">		 			
					<c:forEach items="${ products }" var="varProduct">
						
				        <div class="col-lg-4 col-md-6 mb-4">
				             <div class="card-body">
				                  <h4 class="card-title">
				                      <a href="#">${ varProduct.name }</a>
				                  </h4>
				                  <h5>
				                  	   ${ varProduct.unitPrice } $
				                  </h5>
				                  <p class="card-text">${varProduct.description }</p>	                  
				            </div>
				             <div class="card-footer">
				             			<a href="${ showProductDetails }/${varProduct.id}">Show Details</a>
					                	<a href="${ addProductToCart }?id=${varProduct.id}">Add to Cart</a>
					               </div>				            
					        </div>  
					    </c:forEach>          
				   </div>      
			 </div>	
      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
      </div>
      <!-- /.container -->
    </footer>

   <!-- Bootstrap core JavaScript -->
    <script src="resources/vendor/jquery/jquery.min.js"></script>
    <script src="resources/vendor/popper/popper.min.js"></script>
    <script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>
	
	

</body>
</html>