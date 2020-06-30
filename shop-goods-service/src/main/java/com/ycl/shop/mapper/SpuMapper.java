package com.ycl.shop.mapper;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ycl.shop.entity.Spu;
import com.ycl.shop.entity.SpuVo;

public interface SpuMapper {
	
			//添加
			int add(Spu spu);
			//删除
			int delete(int[] ids);
			//修改
			int update(Spu spu);
			//查询
			List<Spu> list(SpuVo vo);
			//回显功能
			Spu findById(int id);
}
