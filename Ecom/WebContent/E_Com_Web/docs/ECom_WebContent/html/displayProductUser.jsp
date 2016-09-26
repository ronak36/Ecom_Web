<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Products</title>

<!-- Bootstrap core CSS -->
<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="../../assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/dashboard.css" rel="stylesheet">
<link href="../css/grid.css" rel="stylesheet">
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Project name</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Help</a></li>
				<li><a href="LogoutServlet">Logout</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
	</nav>

	<div class="container">

		<c:forEach items="${productListU}" var="product">
			<div class="table-responsive">
            <table class="table table-striped">
				<tr>
					<td><b>Product Name:-</b></td>
					<td><c:out value="${product.productName}"></c:out></td>
				</tr>
				<tr>
					<td><b>Product Id:-</b></td>
					<td><c:out value="${product.productId}"></c:out></td>
				</tr>
				<tr>
					<td><b>Product Price:-</b></td>
					<td><c:out value="${product.price}"></c:out></td>
				</tr>
				<!-- <tr><td><input type="checkbox" name="warrenty" value="checked"/>Add warrenty for $10</td></tr> -->
				<tr>
					<td><button class="btn btn-primary" id="ubtn${product.productId}"
							onclick="addToCart('${product.productId}','${product.categoryId}')">Add
							to cart</button></td>
					<td><button class="btn btn-primary" id="dbtn${product.productId}"
							onclick="checkoutProduct('${product.productId}','${product.categoryId}')">Checkout</button></td>
				</tr>
				
			</table>
			</div>
		</c:forEach>
		<form id="productForm">
			<input type="hidden" id="actionType" name="actionType" /> <input
				type="hidden" id="coCatId" name="coCatId" /> <input type="hidden"
				id="coProductId" name="coProductId" />
			<button class="btn btn-primary" onclick="viewCart()">View Cart</button>
		</form>
		<script type="text/javascript">
function viewCart(productId,catId){
	document.getElementById("coProductId").value = "1";
	document.getElementById("coCatId").value = "1";
	document.getElementById("actionType").value = "nocheckout";
	document.getElementById("productForm").action = "/Ecom/ViewCartServlet";
	document.getElementById("productForm").submit();
}

function addToCart(productId,catId){
	document.getElementById("coProductId").value = productId;
	document.getElementById("coCatId").value = catId;
	document.getElementById("actionType").value = "nocheckout";
	document.getElementById("productForm").action = "/Ecom/AddToCartServlet";
	document.getElementById("productForm").submit();
}

function checkoutProduct(productId,catId){
		document.getElementById("coProductId").value = productId;
		document.getElementById("coCatId").value = catId;
		document.getElementById("actionType").value = "checkout";
		document.getElementById("productForm").action = "/Ecom/AddToCartServlet";
		document.getElementById("productForm").submit();
}
</script>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="../../assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
