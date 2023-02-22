package com.example.springmvctemplate.dao.mapper;

import com.example.springmvctemplate.domain.Quiz;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizMapper implements RowMapper<Quiz> {

    @Override
    public Quiz mapRow(ResultSet rs, int rowNum) throws SQLException {
        Quiz q = new Quiz();
        q.setQuiz_id(rs.getInt("quiz_id"));
        q.setUser_id(rs.getInt("user_id"));
        q.setCategory_id(rs.getInt("category_id"));
        q.setStart_time(rs.getString("start_time"));
        q.setEnd_time(rs.getString("end_time"));
        return q;
    }
}
