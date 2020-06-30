package com.ycl.shop.controller;

import java.util.List;


import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ycl.shop.entity.Brand;
import com.ycl.shop.service.BrandService;

@Controller
@RequestMapping("brand")
public class BrandController {
	
	@Reference
	private BrandService brandService;
	
	@RequestMapping("list")
	public String list(Model model) {
		List<Brand> brands = brandService.brands();
		for (Brand brand : brands) {
			System.out.println("@@@@"+brand);
		}
		
		return "brand_list";
	}
}
