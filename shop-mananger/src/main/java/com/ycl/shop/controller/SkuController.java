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
import com.ycl.shop.entity.Sku;
import com.ycl.shop.entity.SkuVo;
import com.ycl.shop.entity.Spec;
import com.ycl.shop.entity.SpecOption;
import com.ycl.shop.entity.Spu;
import com.ycl.shop.service.BrandService;
import com.ycl.shop.service.SkuService;
import com.ycl.shop.service.SpecService;
import com.ycl.shop.service.SpuService;


@Controller
@RequestMapping("sku")
public class SkuController {
	
	@Reference
	private SkuService skuService;
	
	@Reference
	private SpuService spuService;
	
	@Reference
	private SpecService specService;
	
	@Autowired
	HgFileUtils fileUtils;
	
	
	@Reference
	private BrandService brandService;
	
	@RequestMapping("list")
	public String list(Model model,SkuVo skuVo) {
		PageInfo<Sku> pageInfo = skuService.list(skuVo);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("skuVo", skuVo);
		return "sku/list";
		
	}
	
	
	/**
	 * 
	    * @Title: toAdd
	    * @Description: TODO(进入添加)
	    * @param @param request
	    * @param @param spuId
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("toAdd")
	public String toAdd(Model model,int spuId) {
		
		Spu spu = spuService.getspuByid(spuId);
		model.addAttribute("spu", spu);
		
		List<Spec> specList = specService.listAll();
		model.addAttribute("specList", specList);
		
		return "sku/add";
	}
	
	
	
	/**
	 * 添加sku
	 * @param request
	 * @param sku
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public String add(Model model,Sku sku,
			@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("cartThumbnailFile") MultipartFile cartThumbnailFile ) {
		System.out.println("sku is"+sku);
		List<SpecOption> list = sku.getOptions();
		//数据清零一下
		 for (int i = list.size()-1; i >=0; i--) {
			SpecOption option = list.get(i);
			if(null == option.getSpecId() || 0==option.getSpecId()) {
				list.remove(i);
			}
		}
		// 处理图片
		 sku.setImage(fileUtils.upload(imageFile)); 
		 sku.setCartThumbnail(fileUtils.upload(cartThumbnailFile)); 
		 
		return skuService.add(sku)>0?"ok":"failed";
	}
	
	/**
	 * 获取一个规格的所有属性
	 * @param specId
	 * @return
	 */
	@RequestMapping("getSpecOptions")
	@ResponseBody
	public List<SpecOption> getOptions(int specId){
		Spec spec = specService.getspecByid(specId);
		if(spec==null)
			return null;
		return spec.getOptions();
	}

		
	
	//去修改
	@RequestMapping("toUpdate")
	public String toUpdate(Model model,int id ) {
		//获取sku对象
		Sku sku = skuService.getById(id);
		model.addAttribute("sku", sku);
		
		// 获取规格
		List<Spec> specList = specService.listAll();
		model.addAttribute("specList", specList);
		
		return "sku/update";
	}
	
	
	
	
	//修改
	@RequestMapping("update")
	@ResponseBody
	public String update(Model model,Sku sku,
			@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("cartThumbnailFile") MultipartFile cartThumbnailFile ) {
		List<SpecOption> list = sku.getOptions();
		//数据清零一下
		 for (int i = list.size()-1; i >=0; i--) {
			SpecOption option = list.get(i);
			if(null == option.getSpecId() || 0==option.getSpecId()) {
				list.remove(i);
			}
		}
		// 处理图片
		 if(imageFile!=null && !imageFile.isEmpty()) {
		 sku.setImage(fileUtils.upload(imageFile)); 
		 sku.setCartThumbnail(fileUtils.upload(cartThumbnailFile)); 
		 }
		 
		return skuService.update(sku)>0?"ok":"failed";
	}
	
	
	@RequestMapping("del")
	@ResponseBody
	public String del(Model model,@RequestParam("ids[]") int[] ids) {
		
		return skuService.delete(ids)>0?"ok":"failed";
		
	}
}
