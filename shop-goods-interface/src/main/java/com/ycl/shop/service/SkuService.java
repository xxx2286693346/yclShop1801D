package com.ycl.shop.service;

import com.github.pagehelper.PageInfo;
import com.ycl.shop.entity.Sku;
import com.ycl.shop.entity.SkuVo;


//sku管理
public interface SkuService {
		//添加
		int add(Sku sku);
		//删除
		int delete(int[] ids);
		//修改
		int update(Sku sku);
		//查询
		PageInfo<Sku> list(SkuVo vo);
		//回显功能
		Sku getById(int id);
}
