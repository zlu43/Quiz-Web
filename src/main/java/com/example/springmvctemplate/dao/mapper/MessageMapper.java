package com.example.springmvctemplate.dao.mapper;

import com.example.springmvctemplate.domain.Message;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageMapper implements RowMapper<Message> {
    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        Message m = new Message();
        m.setName(rs.getString("name"));
        m.setEmail(rs.getString("email"));
        m.setMessage(rs.getString("message"));
        return m;
    }
}
