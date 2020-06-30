package com.ycl.shop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycl.shop.entity.Spec;
import com.ycl.shop.entity.SpecOption;
import com.ycl.shop.mapper.SpecMapper;
import com.ycl.shop.service.SpecService;

/*
 * 
    * @ClassName: SpecServiceImpl
    * @Description: TODO(规格管理实现类)
    * @author 袁成龙
    * @date 2020年6月24日
    *
 */
@Service(interfaceClass =SpecService.class )
public class SpecServiceImpl implements SpecService{
	
	@Autowired
	private SpecMapper specMapper;

	@Override
	public int add(Spec spec) {
		// 添加主表
		int result =specMapper.addSpec(spec); //主键自动生成
		
		//插入子表
		List<SpecOption> getoptions = spec.getOptions();
		for (SpecOption specOption : getoptions) {
			specOption.setSpecId(spec.getId());
			result+=specMapper.addOption(specOption);
		}
		return result;
	}

	@Override
	public int delete(int[] ids) {
		int result= specMapper.delOption(ids);
		result+=specMapper.deleteSpec(ids);
		return result;
	}

	@Override
	public int update(Spec spec) {
		System.out.println("%%%%"+spec);
		//修改主表
		int result =specMapper.updateSpec(spec);
		//删除子表
		specMapper.delOption(spec.getId());
		//插入子表
		List<SpecOption> getoptions = spec.getOptions();
		for (SpecOption specOption : getoptions) {
			specOption.setSpecId(spec.getId());
			result+=specMapper.addOption(specOption);
		}
		return result;
	}

	@Override
	public PageInfo<Spec> list(Spec spec, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Spec>(specMapper.listSpec(spec));
	}
	
	@Override
	public Spec getspecByid(int id) {
		return specMapper.getspecByid(id);
	}

	@Override
	public List<Spec> listAll() {
		// TODO Auto-generated method stub
		return specMapper.listAll();
	}

}
