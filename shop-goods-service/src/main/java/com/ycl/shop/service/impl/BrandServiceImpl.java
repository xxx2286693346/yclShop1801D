package com.ycl.shop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.ycl.shop.entity.Brand;
import com.ycl.shop.mapper.BrandMapper;
import com.ycl.shop.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{
	
	@Autowired
	private BrandMapper brandMapper;
	@Override
	public int add(Brand brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Brand brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<Brand> list(Brand brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Brand> brands() {
		return brandMapper.brands();
	}

	@Override
	public Brand getByidBrand(int id) {
		return brandMapper.getByidBrand(id);
	}

}
