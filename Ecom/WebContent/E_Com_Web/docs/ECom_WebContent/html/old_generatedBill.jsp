<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
============================Order Bill==============================
<table>
<tr><td>Order Id:-</td><td><c:out value="${requestScope.orderId}"/></td></tr>
<tr><td>Product Id</td><td>Product Name</td><td>Product Price</td><td>Warrenty</td></tr>
<c:forEach items="${requestScope.orderProductList}" var="product">
<tr><td><c:out value="${product.productId}"/></td>
<td><c:out value="${product.productName}"/></td>
<td><c:out value="${product.price}"/></td><td></td>
</tr>
</c:forEach>
<tr><td>Total</td><td><c:out value="${requestScope.orderPrice}"></c:out></td></tr>
</table>
============================Order Bill==============================
</body>
</html>