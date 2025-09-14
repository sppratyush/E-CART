package com.ecommerce.dao;
import com.ecommerce.model.CartItem;
import com.ecommerce.util.DBConnection;
import java.sql.*; import java.util.*;
public class OrderDAO {
    public int createOrder(int userId, double total, List<CartItem> items) throws SQLException {
        String sqlOrder = "INSERT INTO orders(user_id, total) VALUES(?,?)";
        try(Connection con = DBConnection.getConnection()){
            con.setAutoCommit(false);
            try(PreparedStatement ps = con.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS)){
                ps.setInt(1,userId); ps.setDouble(2,total); ps.executeUpdate();
                try(ResultSet gk = ps.getGeneratedKeys()){ if(gk.next()){ int orderId = gk.getInt(1); String sqlItem = "INSERT INTO order_items(order_id,product_id,quantity,price) VALUES(?,?,?,?)"; try(PreparedStatement psi = con.prepareStatement(sqlItem)){ for(CartItem it: items){ psi.setInt(1, orderId); psi.setInt(2, it.getProductId()); psi.setInt(3, it.getQuantity()); psi.setDouble(4, it.getPrice()); psi.addBatch(); } psi.executeBatch(); } try(PreparedStatement pclear = con.prepareStatement("DELETE FROM cart_items WHERE user_id=?")){ pclear.setInt(1,userId); pclear.executeUpdate(); } con.commit(); return orderId; } }
            } catch(Exception e){ con.rollback(); throw e; } finally { con.setAutoCommit(true); }
        }
        return -1;
    }
}
