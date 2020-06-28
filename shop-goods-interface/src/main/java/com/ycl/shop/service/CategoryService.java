package com.ycl.shop.service;

import java.util.List;

import com.ycl.shop.entity.Category;



/**
 * 分类的管理
 * @author 45466
 *
 */
public interface CategoryService {
	
	public int add(Category category);
	
	public int udpate(Category category);
	
	public int del(int id);
	
	public List<Category> list(int parentId);
	
	

}
