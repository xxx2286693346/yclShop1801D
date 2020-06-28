package com.ycl.shop.service;

import com.github.pagehelper.PageInfo;
import com.ycl.shop.entity.Spec;
import com.ycl.shop.entity.Spu;
import com.ycl.shop.entity.SpuVo;

public interface SpuService {
		//添加
		int add(Spu spu);
		//删除
		int delete(int[] ids);
		//修改
		int update(Spu spu);
		//查询
		PageInfo<Spu> list(SpuVo vo);
		//回显功能
		Spu getspuByid(int id);
}
