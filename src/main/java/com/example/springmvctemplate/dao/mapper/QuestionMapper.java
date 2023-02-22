package com.example.springmvctemplate.dao.mapper;

import com.example.springmvctemplate.domain.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question q = new Question();
        q.setQuestion_id(rs.getInt("question_id"));
        q.setCategory_id(rs.getInt("category_id"));
        q.setQuestion_content(rs.getString("question_content"));
        q.setIs_active(rs.getBoolean("is_active"));
        return q;
    }
}
