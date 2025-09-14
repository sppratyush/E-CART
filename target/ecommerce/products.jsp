<%@ page import="java.util.*, com.ecommerce.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    if(products == null) products = new ArrayList<>();
%>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="container">
    <h1>Products</h1>
    <% for(Product p: products){ %>
        <div style="border:1px solid #eee;padding:10px;margin-bottom:8px;">
            <h3><%=p.getName()%></h3>
            <p><%=p.getDescription()%></p>
            <p>₹<%=p.getPrice()%></p>
            <a href="cart/add?productId=<%=p.getId()%>">Add to cart</a>
        </div>
    <% } %>
</div>
</body>
</html>
