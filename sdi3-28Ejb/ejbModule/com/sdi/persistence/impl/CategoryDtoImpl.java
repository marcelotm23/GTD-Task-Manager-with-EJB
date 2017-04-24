package com.sdi.persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sdi.model.Category;
import com.sdi.persistence.CategoryDto;
import com.sdi.persistence.util.JdbcTemplate;
import com.sdi.persistence.util.RowMapper;

public class CategoryDtoImpl implements CategoryDto{
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	public class CategoryDtoMapper implements RowMapper<Category> {

		@Override
		public Category toObject(ResultSet rs) throws SQLException {
			Category category = new Category();
			category.setId(rs.getLong("id"));
			category.setName(rs.getString("name"));
			category.setUserId(rs.getLong("user_id"));
			return category;
		}
	}
	@Override
	public List<Category> findByUsername(String username) {
		return jdbcTemplate.queryForList("CATEGORY_FIND_BY_USER_NAME",
				new CategoryDtoMapper(), username);
	}

}
