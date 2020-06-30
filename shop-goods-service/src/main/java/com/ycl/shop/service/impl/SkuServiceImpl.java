package com.ycl.shop.service.impl;

import java.util.List;



import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycl.shop.entity.Sku;
import com.ycl.shop.entity.SkuVo;
import com.ycl.shop.entity.SpecOption;
import com.ycl.shop.mapper.SkuMapper;
import com.ycl.shop.mapper.SpuMapper;
import com.ycl.shop.service.SkuService;


/*
 * 
    * @ClassName: SpecServiceImpl
    * @Description: TODO(规格管理实现类)
    * @author 袁成龙
    * @date 2020年6月24日
    *
 */
@Service(interfaceClass =SkuService.class )
public class SkuServiceImpl implements SkuService{
	
	@Autowired
	private SkuMapper skuMapper;

	@Override
	public int add(Sku sku) {
		// TODO Auto-generated method stub
		//插入主表 生成主键
		int result = skuMapper.insert(sku);
		List<SpecOption> options = sku.getOptions();
		//插入子表
		for (SpecOption specOption : options) {
			result+=skuMapper.insertSpecOption(sku.getId(),specOption);
		}
		
		return result;
	}

	@Override
	public int update(Sku sku) {
		// TODO Auto-generated method stub
		//修改主表
		int result = skuMapper.update(sku);
		// 删除子表的数据
		result += skuMapper.deleteSpecOption(sku.getId());
		
		//重新添加   插入子表
		List<SpecOption> options = sku.getOptions();
		for (SpecOption specOption : options) {
			result+=skuMapper.insertSpecOption(sku.getId(),specOption);
		}
		return result;
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		// 先删除子表
		int  result = skuMapper.deleteSpecOption(ids);
		//再删除主表
		result += skuMapper.delete(ids);
		
		return result;
	}

	@Override
	public PageInfo<Sku> list(SkuVo skuvo) {
		// TODO Auto-generated method stub
		PageHelper.startPage(skuvo.getPageNum(), skuvo.getPageSize());
		
		return new PageInfo<Sku>(skuMapper.list(skuvo)) ;
	}

	@Override
	public Sku getById(int id) {
		// TODO Auto-generated method stub
		return skuMapper.findById(id);
	}

	
	
}
