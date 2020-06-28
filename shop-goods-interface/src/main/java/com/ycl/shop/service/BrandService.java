package com.ycl.shop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ycl.shop.entity.Brand;

/**
 * 
    * @ClassName: BrandService
    * @Description: TODO(品牌的管理)
    * @author 袁成龙
    * @date 2020年6月23日
    *
 */
public interface BrandService {
	
	/**
	 * 
	    * @Title: add
	    * @Description: TODO(添加品牌)
	    * @param @param brand
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	int add(Brand brand);
	/**
	 * 
	    * @Title: add
	    * @Description: TODO(修改品牌)
	    * @param @param brand
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	int update(Brand brand);
	/**
	 * 
	    * @Title: add
	    * @Description: TODO(删除品牌)
	    * @param @param brand
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	int delete(int[] ids);
	/**
	 * 
	    * @Title: add
	    * @Description: TODO(查询品牌)
	    * @param @param brand
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	PageInfo<Brand> list(Brand brand);
	/**
	 * 
	    * @Title: add
	    * @Description: TODO(查询所有品牌)
	    * @param @param brand
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	List<Brand> brands();
	/**
	 * 
	    * @Title: add
	    * @Description: TODO(查品牌)
	    * @param @param brand
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	Brand getByidBrand(int id);
}
