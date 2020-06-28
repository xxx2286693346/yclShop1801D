package com.ycl.shop.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.ycl.shop.entity.Spec;
import com.ycl.shop.service.SpecService;

import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-dao.xml",
"classpath:dubbo-provider.xml"})
public class SpecServiceImplTest {
	
	@Autowired
	private SpecService specService;

	@Test
	public void testList() {
		PageInfo<Spec> info = specService.list(null, 1, 10);
		List<Spec> list = info.getList();
		for (Spec spec : list) {
		System.out.println("test  spec"+spec);	
		}
	}

	@Test
	public void testGetspecByid() {
		Spec getspecByid = specService.getspecByid(2);
		System.out.println("@@"+getspecByid);
	}

}
