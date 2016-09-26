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

	<c:forEach items="${requestScope.productList}" var="product">
		<table>
			<tr>
				<td>Product Name:-</td>
				<td><c:out value="${product.productName}"></c:out></td>
			</tr>
			<tr>
				<td>Product Id:-</td>
				<td><c:out value="${product.productId}"></c:out></td>
			</tr>
			<tr>
				<td>Product Id:-</td>
				<td><c:out value="${product.price}"></c:out></td>
			</tr>
			<tr>
				<td><button id="ubtn${product.productId}"
						onclick="updateProduct('${product.productId}','${product.categoryId}')">Update</button></td>
				<td><button id="dbtn${product.productId}"
						onclick="deleteProduct('${product.productId}','${product.categoryId}')">Delete</button></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
		</table>
	</c:forEach>
	<form id="productForm">
		<input type="hidden" id="delCatId" name="delCatId" /> <input
			type="hidden" id="delProductId" name="delProductId" />
	</form>
	<script type="text/javascript">
		function updateProduct(productId) {
			alert("update is clicked");
		}
		function alertme() {
			alert("alert me worked well");
		}
		function deleteProduct(productId, catId) {

			var isDelete = confirm("Do you want to delete this product?");
			if (isDelete == true) {
				document.getElementById("delProductId").value = productId;
				document.getElementById("delCatId").value = catId;
				document.getElementById("productForm").action = "/Ecom/DeleteProductServlet";
				document.getElementById("productForm").submit();
			}
		}
	</script>
</body>
</html>