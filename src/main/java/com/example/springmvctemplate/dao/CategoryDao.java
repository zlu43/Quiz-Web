package com.example.springmvctemplate.dao;

import com.example.springmvctemplate.dao.mapper.CategoryMapper;
import com.example.springmvctemplate.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addCategory(String category_name) {
        String sql = "insert into Category (name) values (?)";
        jdbcTemplate.update(sql, category_name);
    }

    public void deleteCategory(String category_id) {
        String sql = "delete from Category where category_id = ?";
        jdbcTemplate.update(sql, category_id);
    }

    public void updateCategory(int category_id, String category_name) {
        String sql = "update Category set name = ? where category_id = ?";
        jdbcTemplate.update(sql, category_name, category_id);
    }

    public Category getCategoryById(int category_id) {
        String sql = "select * from Category where category_id = ?";
        List<Category> rs = jdbcTemplate.query(sql, new CategoryMapper(), category_id);
        return rs.size() > 0 ? rs.get(0) : null;
    }

    public int getIdByCategoryName(String category_name) {
        String sql = "select category_id from Category where name = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, category_name);
    }

    public String getCategoryNameById(int category_id) {
        String sql = "select name from Category where category_id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, category_id);
    }

    public List<Category> getAllCategory() {
        String sql = "select * from Category";
        return jdbcTemplate.query(sql, new CategoryMapper());
    }



}
