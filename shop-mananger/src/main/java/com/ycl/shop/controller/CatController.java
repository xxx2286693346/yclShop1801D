package com.ycl.shop.controller;

import java.util.List;


import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycl.shop.entity.Category;
import com.ycl.shop.service.CategoryService;


@Controller
@RequestMapping("cat")
public class CatController {
	
	@Reference
	private CategoryService catService;
	
	/**
	 * 跳转到jsp 页面进行渲染
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		System.out.println("!@#$%@");
		return "cat/index";
	}
	
	//查询
	@RequestMapping("data")
	@ResponseBody
	public List<Category> getData(){
		System.out.println("@@@@@@@@@@@@");
		// 获取到所有分类的数据
		 List<Category> categories = catService.list(0);
		 for (Category category : categories) {
			System.out.println("@@"+category);
		}
		 return categories;
		
	}
	
	
	//添加
	@RequestMapping("add")
	@ResponseBody
	public String add(Category category){
		 return catService.add(category)>0?"ok":"failed";
		
	}
	
	
	//修改
	@RequestMapping("update")
	@ResponseBody
	public String update(Category category){
		 return catService.udpate(category)>0?"ok":"failed";
		
	}
	
	//删除
	@RequestMapping("delete")
	@ResponseBody
	public String delte(int id){
		 return catService.del(id)>0?"ok":"failed";
		
	}
	
	
}
