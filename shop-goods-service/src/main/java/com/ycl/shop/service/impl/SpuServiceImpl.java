package com.ycl.shop.service.impl;

import java.util.List;


import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycl.shop.entity.Spu;
import com.ycl.shop.entity.SpuVo;
import com.ycl.shop.mapper.SpecMapper;
import com.ycl.shop.mapper.SpuMapper;
import com.ycl.shop.service.SpuService;

/*
 * 
    * @ClassName: SpecServiceImpl
    * @Description: TODO(规格管理实现类)
    * @author 袁成龙
    * @date 2020年6月24日
    *
 */
@Service(interfaceClass =SpuService.class )
public class SpuServiceImpl implements SpuService{
	
	@Autowired
	private SpuMapper spuMapper;

	@Override
	public int add(Spu spu) {
		// TODO Auto-generated method stub
		return spuMapper.add(spu);
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		return spuMapper.delete(ids);
	}

	@Override
	public int update(Spu spu) {
		// TODO Auto-generated method stub
		return spuMapper.update(spu);
	}

	@Override
	public PageInfo<Spu> list(SpuVo vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		return new PageInfo<Spu>(spuMapper.list(vo));
	}

	@Override
	public Spu getspuByid(int id) {
		// TODO Auto-generated method stub
		return spuMapper.findById(id);
	}

	
}
