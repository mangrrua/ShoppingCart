
<!-- Spring and JSP taglibs -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>



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

	<spring:url value="/category" var="showByCategory" htmlEscape="true"/>
	<spring:url value="/home" var="goHomePage" htmlEscape="true" />
	<spring:url value="/brand" var="showByBrand" htmlEscape="true"/>
	<spring:url value="/my.cart/add" var="addProductToCart" htmlEscape="true"/>
	<spring:url value="/product/remove?id=" var="removeProduct" htmlEscape="true"/>
	
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
            
            <li class="nav-item">
              <a class="nav-link" href="#">Login</a>
            </li>
            
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">
			
		<div class="row">
			<div class="col-lg-offset-3 col-lg-6">
				<form:form modelAttribute="customerLogin" method="POST">
					<fieldset>
						<legend>Login</legend>
						<br>
						<br>
						
						<c:if test="${ failedLogin != null }">
							<div class="form-group">
								<label class="control-label col-lg-2" for="name">
									${ failedLogin }
								</label>
							</div>
						</c:if>
						
						<div class="form-group">				
							<label class="control-label col-lg-2" for="name">
								Username:
							</label>
							<div class="col-lg-10">													
								<form:hidden path="id" />
								<form:input path="userName" type="text" name="userName" class="form:input-large"/>
								
							</div>
						</div>
						
						<div class="form-group">				
							<label class="control-label col-lg-2" for="name">
								Password:
							</label>
							<div class="col-lg-10">													
								<form:hidden path="id" />
								<form:input path="password" type="password" name="password" class="form:input-large"/>
								
							</div>
						</div>
						
						<div class="form-group">										
							<div class="col-lg-10">													
								<form:hidden path="id" />
								<input type="submit" value="Login" class="form:input-large"/>
								
							</div>
						</div>
					</fieldset>
				</form:form>		
			</div> <!-- end col-md -->	
			
		</div> <!-- end row -->	
      
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