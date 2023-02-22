package com.example.springmvctemplate.dao.mapper;

import com.example.springmvctemplate.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUser_id(rs.getInt("user_id"));
        user.setUser_name(rs.getString("user_name"));
        user.setFirstname(rs.getString("firstname"));
        user.setLastname(rs.getString("lastname"));
        user.setPhone(rs.getString("phone"));
        user.setAddress(rs.getString("address"));
        user.setEmail(rs.getString("email"));
        user.setIs_admin(rs.getBoolean("is_admin"));
        user.setIs_active(rs.getBoolean("is_active"));
        return user;
    }
}

