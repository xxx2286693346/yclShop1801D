package com.ycl.shop.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ycl.shop.entity.Brand;
import com.ycl.shop.service.BrandService;


@Controller
@RequestMapping("brand")
public class BrandController {

	@Reference
	private BrandService brandService;
	
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		List<Brand> list = brandService.brands();
		list.forEach(x->{System.out.println("x is " + x);});
		request.setAttribute("list", list); 
		return "brand/list";
	}
	
}
