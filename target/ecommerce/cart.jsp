<%@ page import="java.util.*, com.ecommerce.model.CartItem" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    List<CartItem> items = (List<CartItem>) request.getAttribute("cartItems");
    if(items == null) items = new ArrayList<>();
%>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<div class="container">
    <h1>Your Cart</h1>
    <table>
        <tr><th>Product</th><th>Qty</th></tr>
        <% for(CartItem it: items){ %>
            <tr>
                <td><%=it.getProductName()%></td>
                <td><%=it.getQuantity()%></td>
            </tr>
        <% } %>
    </table>
    <a href="../checkout">Checkout</a>
</div>
</body>
</html>
