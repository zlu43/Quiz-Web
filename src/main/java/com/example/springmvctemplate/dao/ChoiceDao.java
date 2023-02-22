package com.example.springmvctemplate.dao;

import com.example.springmvctemplate.dao.mapper.ChoiceMapper;
import com.example.springmvctemplate.domain.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChoiceDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int checkCorrect(int choice_id) {
        String sql = "select * from Choice where choice_id = ? and is_answer = true";
        List<Choice> rs = jdbcTemplate.query(sql, new ChoiceMapper(), choice_id);
        return rs.size();
    }

    public void addChoice(int question_id, String choice_content, Boolean is_answer) {
        String sql = "insert into Choice (question_id, choice_content, is_answer) values (?, ?, ?)";
        jdbcTemplate.update(sql, question_id, choice_content, is_answer);
    }

    public void deleteChoiceById(int choice_id) {
        String sql = "delete from Choice where choice_id = ?";
        jdbcTemplate.update(sql, choice_id);
    }

    public void deleteChoiceByQuestionId(int question_id) {
        String sql = "delete from Choice where question_id = ?";
        jdbcTemplate.update(sql, question_id);
    }

    public void updateChoiceContentById(int choice_id, String choice_content, boolean is_answer) {
        String sql = "update Choice set choice_content = ?, is_answer = ? where choice_id = ?";
        System.out.println(choice_id);
        System.out.println(choice_content);
        System.out.println(is_answer);
        jdbcTemplate.update(sql, choice_content, is_answer, choice_id);
    }

    public Choice getChoiceById(int choice_id) {
        String sql = "select * from Choice where choice_id = ?";
        List<Choice> rs = jdbcTemplate.query(sql, new ChoiceMapper(), choice_id);
        return rs.size() > 0 ? rs.get(0) : null;
    }

    public List<Choice> getChoiceByQuestionId(int question_id) {
        String sql = "select * from Choice where question_id = ?";
        return jdbcTemplate.query(sql, new ChoiceMapper(), question_id);
    }

    public List<Choice> getAllChoices() {
        String sql = "select * from Choice";
        return jdbcTemplate.query(sql, new ChoiceMapper());
    }


}
