package com.ycl.shop.mapper;

import java.util.List;

import com.ycl.shop.entity.Spec;
import com.ycl.shop.entity.SpecOption;

public interface SpecMapper {
	
		//添加Spec
		int addSpec(Spec spec);
		//删除Spec
		int deleteSpec(int[] ids);
		//修改Spec
		int updateSpec(Spec spec);
		//查询Spec
		List<Spec> listSpec(Spec spec);
		//回显功能Spec
		Spec getspecByid(int id);
		//添加规格明细
		int addOption(SpecOption specOption);
		//删除规格明细
		int delOption(int... ids);
		//查询所有的
		List<Spec> listAll();
}
