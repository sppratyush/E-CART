package com.ecommerce.dao;
import com.ecommerce.model.User;
import com.ecommerce.util.DBConnection;
import java.sql.*;
public class UserDAO {
    public void create(String name, String email, String passwordHash) throws SQLException {
        String sql = "INSERT INTO users(name,email,password_hash) VALUES(?,?,?)";
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){ ps.setString(1,name); ps.setString(2,email); ps.setString(3,passwordHash); ps.executeUpdate(); }
    }
    public User findByEmail(String email) throws SQLException {
        String sql = "SELECT id,name,email,password_hash FROM users WHERE email=?";
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){ ps.setString(1,email); try(ResultSet rs=ps.executeQuery()){ if(rs.next()){ User u=new User(); u.setId(rs.getInt("id")); u.setName(rs.getString("name")); u.setEmail(rs.getString("email")); u.setPasswordHash(rs.getString("password_hash")); return u; } } }
        return null;
    }
}
