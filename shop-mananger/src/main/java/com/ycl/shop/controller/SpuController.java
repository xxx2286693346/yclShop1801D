package com.ycl.shop.controller;

import java.util.List;



import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.ycl.shop.entity.Brand;
import com.ycl.shop.entity.Spu;
import com.ycl.shop.entity.SpuVo;
import com.ycl.shop.service.BrandService;
import com.ycl.shop.service.SpuService;

@Controller
@RequestMapping("spu")
public class SpuController {
	
	@Reference
	private SpuService spuService;
	
	
	@Reference
	private BrandService brandService;
	
	@Autowired
	HgFileUtils fileUtils;
	
	
	@RequestMapping("list")
	public String list(Model model,SpuVo spuVo) {
		spuVo.setPageSize(20);
		PageInfo<Spu> list = spuService.list(spuVo);
		List<Spu> list2 = list.getList();
		for (Spu spu : list2) {
			System.out.println("######"+spu);
		}
		model.addAttribute("spuvo", spuVo);
		model.addAttribute("brandId", spuVo.getBrandId());
		model.addAttribute("info", list);
		//得到所有的 品牌
		List<Brand> brands = brandService.brands();
		model.addAttribute("brands", brands);
		return "/spu/list";
		
	}
	
	
	
	
	//去添加
	@RequestMapping("toadd")
	public String toadd(Model model) {
		//得到所有的 品牌
		List<Brand> brands = brandService.brands();
		model.addAttribute("brands", brands);
		return "spu/add";
	}
	
	
	
	//添加
	@RequestMapping("add")
	@ResponseBody
	public String add(Model model,Spu spu,
			@RequestParam("myFile") MultipartFile file) {
		
		String uploadPath = fileUtils.upload(file);
		spu.setSmallPic(uploadPath);
		
		return spuService.add(spu)>0?"ok":"failed";
		
	}
	
	
	//删除
	@RequestMapping("del")
	@ResponseBody
	public String del(Model model,@RequestParam("ids[]") int[] ids) {
		return spuService.delete(ids)>0?"ok":"failed";
		
	}
	
	
	
	
	/**
	 * 去修改 获取数据 进行回显
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Model model,int id) {
		Spu spu = spuService.getspuByid(id);
		System.out.println("spu is"+spu);
		model.addAttribute("spu", spu);
		
		// 得到所有的品牌
		List<Brand> brandList = brandService.brands();
		model.addAttribute("brandList", brandList);
		return "spu/update";
	}
	
	/**
	 *    接收修改的参数
	 * @param request
	 * @param spu
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Model model,Spu spu,
			@RequestParam("myFile") MultipartFile file) {
		
		String uploadPath = fileUtils.upload(file);
		spu.setSmallPic(uploadPath);
		
		return spuService.update(spu)>0?"ok":"failed";
		
	}
}
