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

<c:forEach items="${requestScope.cartProductList}" var="product">
<table>
<tr><td>Product Name:- </td><td><c:out value="${product.productName}"></c:out></td></tr>
<tr><td>Product Id:- </td><td><c:out value="${product.productId}"></c:out></td></tr>
<tr><td>Product Id:- </td><td><c:out value="${product.price}"></c:out></td></tr>
<td><button id="dbtn${product.productId}" onclick="deleteProduct('${product.productId}','${product.categoryId}')">Remove</button></td></tr>
<tr><td></td><td></td></tr>
</table>
</c:forEach>
<form id="productForm">
<input type="hidden" id="rmCatId" name = "rmCatId"/>
<input type="hidden" id="rmProductId" name = "rmProductId"/>
<button onclick="checkout()">Check out</button>
</form>
<script type="text/javascript">
function checkout(){
	document.getElementById("rmProductId").value = "-1";
	document.getElementById("rmCatId").value = "-1";
	document.getElementById("productForm").action = "/Ecom/E_Com_Web/docs/ECom_WebContent/html/addPayment.html";
	document.getElementById("productForm").submit();
}
function deleteProduct(productId,catId){
	
	var isDelete = confirm("Do you want to remove this product?");
	if (isDelete == true){
		document.getElementById("rmProductId").value = productId;
		document.getElementById("rmCatId").value = catId;
		document.getElementById("productForm").action = "/Ecom/RemoveProductServlet";
		document.getElementById("productForm").submit();
	}
}
</script>
</body>
</html>