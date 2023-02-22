package com.example.springmvctemplate.dao.mapper;

import com.example.springmvctemplate.domain.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category ca = new Category();
        ca.setCategory_id(rs.getInt("category_id"));
        ca.setCategory_name(rs.getString("name"));
        return ca;
    }
}
