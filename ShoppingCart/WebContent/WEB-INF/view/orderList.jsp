
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

	<spring:url value="/my.cart/remove.all" var="removeAllProductInCart" htmlEscape="true" />
	<spring:url value="/my.cart/remove.one" var="removeProductInCartById" htmlEscape="true" />
	<spring:url value="/my.cart/remove.same.all" var="removeAllProductInCartById" htmlEscape="true" />
	<spring:url value="/my.cart" var="goMyCartPage" htmlEscape="true" />
	<spring:url value="/my.cart/remove" var="removeOrderInOrder" htmlEscape="true" />

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
        <a class="navbar-brand" href="#">Shopping Cart</a>
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
		              <a class="nav-link" href="#">My Orders</a>
		            </li>
		            <li class="nav-item">
		              <a class="nav-link" href="#">Profile</a>
		            </li>
		            <li class="nav-item">
		              <a class="nav-link" href="${ goLogoutPage }">Logout</a>
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
				<div class="col-md-3">
		          <h1 class="my-4">Categories</h1>
		          <div class="list-group">
		            <a href="${ showByCategory }/laptop" class="list-group-item">Laptop</a>
		            <a href="${ showByCategory }/tablet" class="list-group-item">Tablet</a>
		            <a href="${ showByCategory }/mobile" class="list-group-item">Smart Phone</a>
		          </div>
		
		          <h1 class="my-4">Brands</h1>
		          <div class="list-group">
		            <a href="${ showByBrand }/apple" class="list-group-item">Apple</a>
		            <a href="${ showByBrand }/asus" class="list-group-item">Asus</a>
		            <a href="${ showByBrand }/lenova" class="list-group-item">Lenova</a>
		            <a href="${ showByBrand }/sonny" class="list-group-item">Sonny</a>
		            <a href="${ showByBrand }/samsung" class="list-group-item">Samsung</a>
		          </div>
		      </div>
		      <!-- /.row -->
		      
		      
		      <div class="col-md-9">
		      	<br>
		      	<div class="row">
         			<div class="col-md-offset-3 col-md-4">
         				<h3>My Orders</h3>
         			</div>
         		</div>
		 		
		 		<c:choose>
		 			<c:when test="${ products != null }">
		 				<div class="row">		 			
								<div class="col-md-12">
										<legend>Person List</legend>
										<div class="table-responsive">
										
													<table id="example" class="table table-striped table-bordered">							
													<thead>
														<tr>
															<th>ID</th>
															<th>Creation Time</th>
															<th>Total Quantity</th>
															<th>Total Price</th>
															<th>Delete</th>
														</tr>
													</thead>
													
													<tbody>
													
														<c:forEach items="${ myOrders }" var="varOrder">
															<tr>
																<td><c:out value="${ varOrder.id }" /></td>
																<td><c:out value="${ varOrder.creationTime }" /></td>
																<td><c:out value="${ varOrder.totalQuantity }" /></td>
																<td><c:out value="${ varOrder.totalPrice }" /></td>							 
																
																<td><a href="${ removeOrderInOrder }?id=${varOrder.id}"
																	class="btn btn-danger" type="button">Delete</a>
																</td>
															</tr>
														</c:forEach> 
													</tbody>
												</table>
												
											</div><!-- end table div -->
									</div><!-- end col-md -->
									                 
						   </div> 
		 			</c:when>
		 			
		 			<c:otherwise>
		 				<br>
		 				<br>
		 				<div class="row">
		 					Not products purchased... 
		 				</div>
		 			
		 			</c:otherwise>
		 			
		 		</c:choose>
		 		     
			 </div>	
		</div>
  
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