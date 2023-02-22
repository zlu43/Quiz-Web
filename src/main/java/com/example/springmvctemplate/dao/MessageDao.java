package com.example.springmvctemplate.dao;

import com.example.springmvctemplate.dao.mapper.MessageMapper;
import com.example.springmvctemplate.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addMessage(String name, String email, String message) {
        String sql = "insert into Message (name, email, message) values (?, ?, ?)";
        jdbcTemplate.update(sql, name, email, message);
    }

    public List<Message> getAllMessage() {
        String sql = "select * from Message";
        return jdbcTemplate.query(sql, new MessageMapper());
    }
}
