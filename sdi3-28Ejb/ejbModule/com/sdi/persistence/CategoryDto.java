package com.sdi.persistence;

import java.util.List;

import com.sdi.model.Category;

public interface CategoryDto {

	List<Category> findByUsername(String username);

}
