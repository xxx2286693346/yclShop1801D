package com.ycl.shop.mapper;

import java.util.List;

import com.ycl.shop.entity.Category;


public interface CategoryDao {

	int add(Category category);

	int update(Category category);

	int delete(int id);

	 List<Category>  list(int parentId);

}
