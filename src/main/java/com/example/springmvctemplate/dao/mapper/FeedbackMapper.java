package com.example.springmvctemplate.dao.mapper;

import com.example.springmvctemplate.domain.Feedback;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackMapper implements RowMapper<Feedback> {
    @Override
    public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException {
        Feedback f = new Feedback();
        f.setRating(rs.getInt("rating"));
        f.setFeedback(rs.getString("feedback"));
        return f;
    }
}
