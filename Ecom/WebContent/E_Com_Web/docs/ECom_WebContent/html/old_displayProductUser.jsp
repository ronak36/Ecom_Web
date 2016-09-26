<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${requestScope.productListU}" var="product">
<table>
<tr><td>Product Name:- </td><td><c:out value="${product.productName}"></c:out></td></tr>
<tr><td>Product Id:- </td><td><c:out value="${product.productId}"></c:out></td></tr>
<tr><td>Product Id:- </td><td><c:out value="${product.price}"></c:out></td></tr>
<!-- <tr><td><input type="checkbox" name="warrenty" value="checked"/>Add warrenty for $10</td></tr> -->
<tr><td><button id="ubtn${product.productId}" onclick="addToCart('${product.productId}','${product.categoryId}')">Add to cart</button></td>
<td><button id="dbtn${product.productId}" onclick="checkoutProduct('${product.productId}','${product.categoryId}')">Checkout</button></td></tr>
<tr><td></td></tr>
</table>
</c:forEach>
<form id="productForm">
<input type="hidden" id="actionType" name = "actionType"/>
<input type="hidden" id="coCatId" name = "coCatId"/>
<input type="hidden" id="coProductId" name = "coProductId"/>
<button onclick="viewCart()">View Cart</button>
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
</body>
</html>