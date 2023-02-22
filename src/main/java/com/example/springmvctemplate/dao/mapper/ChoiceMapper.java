package com.example.springmvctemplate.dao.mapper;

import com.example.springmvctemplate.domain.Choice;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChoiceMapper implements RowMapper<Choice> {

    @Override
    public Choice mapRow(ResultSet rs, int rowNum) throws SQLException {
        Choice ch = new Choice();
        ch.setChoice_id(rs.getInt("choice_id"));
        ch.setQuestion_id(rs.getInt("question_id"));
        ch.setChoice_content(rs.getString("choice_content"));
        ch.set_answer(rs.getBoolean("is_answer"));
        return ch;
    }
}
