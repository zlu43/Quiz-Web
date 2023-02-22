package com.example.springmvctemplate.dao;

import com.example.springmvctemplate.dao.mapper.UserMapper;
import com.example.springmvctemplate.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User validateLogin(String username, String password) {
        String sql = "select * from User where user_name = ? and user_password = ? and is_active = true";
        List<User> rs = jdbcTemplate.query(sql, new Object[] {username, password}, new UserMapper());
        return rs.size() > 0 ? rs.get(0) : null;
    }

    public void register(String username, String password,
                         String firstname, String lastname,
                         String phone, String email, String address) {
        String sql = "insert into User( " +
                "user_name, user_password, " +
                "firstname, lastname, " +
                "phone, email, address, " +
                "is_admin, is_active) " +
                "values (?, ?, ?, ?, ?, ?, ?, FALSE, TRUE)";
        jdbcTemplate.update(sql, username, password, firstname, lastname, phone, email, address);
    }

    public void deleteUserById(int user_id) {
        String sql = "delete from User where user_id = ?";
        jdbcTemplate.update(sql, user_id);
    }

    public void activateOrSuspendUserById(int user_id, String action) {
        String sql;
        if (action.equals("activate")) {
            sql = "update User set is_active = true where user_id = ?";
        } else {
            sql = "update User set is_active = false where user_id = ?";
        }
        jdbcTemplate.update(sql, user_id);
    }

    public User getUserById(int user_id) {
        String sql = "select * from User where user_id = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), user_id);
    }

    public List<User> getAllUsers() {
        String sql = "select * from User";
        return jdbcTemplate.query(sql, new UserMapper());
    }


}
