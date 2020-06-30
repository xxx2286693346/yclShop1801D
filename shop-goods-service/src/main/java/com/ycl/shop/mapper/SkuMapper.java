package com.ycl.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ycl.shop.entity.Sku;
import com.ycl.shop.entity.SkuVo;
import com.ycl.shop.entity.SpecOption;

public interface SkuMapper {

	//添加主表
	int insert(Sku sku);
	//添加子表
	int insertSpecOption(@Param("skuId")Integer id,@Param("opt") SpecOption specOption);
	//修改
	int update(Sku sku);
	
	//删除主表
	int delete(int[] ids);
	//删除子表
	int deleteSpecOption(int... ids);

	//查询
	List<Sku> list(SkuVo skuvo);
	//回显
	Sku findById(int id);

	

	

}
