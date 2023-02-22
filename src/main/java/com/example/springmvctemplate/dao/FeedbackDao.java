package com.example.springmvctemplate.dao;

import com.example.springmvctemplate.dao.mapper.FeedbackMapper;
import com.example.springmvctemplate.domain.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeedbackDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addFeedback(int rating, String feedback) {
        String sql = "insert into Feedback (rating, feedback) values (?, ?)";
        jdbcTemplate.update(sql, rating, feedback);
    }

    public List<Feedback> getAllFeedback() {
        String sql = "select * from Feedback";
        return jdbcTemplate.query(sql, new FeedbackMapper());
    }
}
