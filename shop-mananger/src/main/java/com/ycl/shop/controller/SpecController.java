package com.ycl.shop.controller;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ycl.shop.entity.Spec;
import com.ycl.shop.entity.SpecOption;
import com.ycl.shop.service.SpecService;

@Controller
@RequestMapping("spec")
public class SpecController {
	
	@Reference
	private SpecService specService;
	
	/**
	 * 
	    * @Title: add
	    * @Description: TODO(接收添加请求调用服务)
	    * @param @param spec
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@ResponseBody
	@PostMapping("add")
	public String add(Spec spec) {
		System.out.println("spec is " + spec);
		List<SpecOption> options = spec.getOptions();
		// 数据进行清洗
		for (int i = options.size()-1; i >=0; i--) {
			SpecOption option = options.get(i);
			if(option.getOptionName()==null || "".equals(option.getOptionName())) {
				options.remove(i);
			}
		}
		return specService.add(spec)>0?"ok":"failed";
	}
	
	/**
	 * 
	    * @Title: toadd
	    * @Description: TODO(进入到添加页面)
	    * @param @param spec
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@GetMapping("toadd")
	public String toadd() {
		return "spec/add";
	}
	
	/**
	 * 
	    * @Title: list
	    * @Description: TODO(列表)
	    * @param @param model
	    * @param @param specname
	    * @param @param pageNum
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("list")
	public String list(Model model,@RequestParam(defaultValue = "")String specname,@RequestParam(defaultValue = "1")int pageNum) {
		PageInfo<Spec> list = specService.list(new Spec(specname), pageNum, 5);
		model.addAttribute("info", list);
		return "spec/list";
	}
	
	
	
	/**
	 * 
	    * @Title: del
	    * @Description: TODO(删除)
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@ResponseBody
	@RequestMapping("del")
	public boolean del(@RequestParam(value = "ids[]")int[] ids) {
		return specService.delete(ids)>0;
	}
	
	
	
	/**
	 * 
	    * @Title: toupdate
	    * @Description: TODO(跳转到修改的jsp)
	    * @param @param model
	    * @param @param id
	    * @param @return    参数
	    * @return Spec    返回类型
	    * @throws
	 */
	@RequestMapping("toupdate")
	public String toupdate(Model model,int id) {
		Spec spec = specService.getspecByid(id);
		model.addAttribute("spec", spec);
		return "spec/update";
	}
	
	
	
	/**
	 * 
	    * @Title: update
	    * @Description: TODO(修改执行)
	    * @param @param ids
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Spec spec) {
		System.out.println("@@@"+spec);
		List<SpecOption> options = spec.getOptions();
		// 数据进行清洗
		for (int i = options.size()-1; i >=0; i--) {
			SpecOption option = options.get(i);
			if(option.getOptionName()==null || "".equals(option.getOptionName())) {
				options.remove(i);
			}
		}
		return specService.update(spec)>0?"ok":"failed";
	}
}
