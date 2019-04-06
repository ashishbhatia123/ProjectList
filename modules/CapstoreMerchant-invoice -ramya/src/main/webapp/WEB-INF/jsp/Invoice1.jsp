`<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice</title>
</head>
<body>
<center>

<header>
			<h1 align="left"><center>CapStore</center></h1>
			<h2 align="right"><a href="index.jsp">Home</a></h2>
			<h1 align="center">Invoice</h1>
</header>

<table border="2">
<tr>
<th>Product Id</th>
<th>Product Name  </th>
<th> Product Size </th>
<th> Product Price </th>
<th> Product discount </th>


<th>Total Price</th></tr>



<c:forEach items="${list}" var="cart_product">
<tr>
<td> <c:out value="${cart_product.prodId}" /> </td>
<td> <c:out value="${cart_product.name}" /> </td>
<td> <c:out value="${cart_product.sizes}" />  </td>
<td> <c:out value="${cart_product.price}" /> </td>
<td><c:out value="${cart_product.prodDiscount}" />  </td> 
</tr>
</c:forEach>

<tr>
<td colspan=6 align="right"><c:out value="${totalPrice }"/></td>
</tr>
</center>
</table>

 <!-- <h2>Brajesh</h2>
  --></body>
</html>