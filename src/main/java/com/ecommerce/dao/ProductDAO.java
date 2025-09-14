package com.ecommerce.dao;
import com.ecommerce.model.Product;
import com.ecommerce.util.DBConnection;
import java.sql.*; import java.util.*;
public class ProductDAO {
    public List<Product> listAll() throws SQLException {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT id,name,description,price,stock FROM products";
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Product p = new Product();
                p.setId(rs.getInt("id")); p.setName(rs.getString("name")); p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price")); p.setStock(rs.getInt("stock")); list.add(p);
            }
        }
        return list;
    }
    public Product findById(int id) throws SQLException {
        String sql = "SELECT id,name,description,price,stock FROM products WHERE id=?";
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,id); try(ResultSet rs = ps.executeQuery()){ if(rs.next()){ Product p=new Product(); p.setId(rs.getInt("id")); p.setName(rs.getString("name")); p.setDescription(rs.getString("description")); p.setPrice(rs.getDouble("price")); p.setStock(rs.getInt("stock")); return p; } }
        }
        return null;
    }
}
