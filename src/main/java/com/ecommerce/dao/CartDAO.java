package com.ecommerce.dao;
import com.ecommerce.model.CartItem;
import com.ecommerce.util.DBConnection;
import java.sql.*; import java.util.*;
public class CartDAO {
    public List<CartItem> listByUserId(int userId) throws SQLException {
        List<CartItem> items = new ArrayList<>();
        String sql = "SELECT c.id, c.product_id, c.quantity, p.name, p.price FROM cart_items c JOIN products p ON c.product_id = p.id WHERE c.user_id = ?";
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,userId); try(ResultSet rs = ps.executeQuery()){ while(rs.next()){ CartItem it = new CartItem(); it.setId(rs.getInt("id")); it.setProductId(rs.getInt("product_id")); it.setQuantity(rs.getInt("quantity")); it.setProductName(rs.getString("name")); it.setPrice(rs.getDouble("price")); items.add(it);} }
        }
        return items;
    }
    public void addToCart(int userId, int productId, int qty) throws SQLException {
        String sql = "INSERT INTO cart_items(user_id,product_id,quantity) VALUES(?,?,?)";
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){ ps.setInt(1,userId); ps.setInt(2,productId); ps.setInt(3,qty); ps.executeUpdate(); }
    }
    public void removeById(int id) throws SQLException { String sql="DELETE FROM cart_items WHERE id=?"; try(Connection con=DBConnection.getConnection(); PreparedStatement ps=con.prepareStatement(sql)){ ps.setInt(1,id); ps.executeUpdate(); } }
}
