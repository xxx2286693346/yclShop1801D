package com.ycl.shop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ycl.shop.entity.Spec;

public interface SpecService {
	
	//添加
	int add(Spec spec);
	//删除
	int delete(int[] ids);
	//修改
	int update(Spec spec);
	//查询
	PageInfo<Spec> list(Spec spec,int pageNum,int pageSize);
	//回显功能
	Spec getspecByid(int id);
}
