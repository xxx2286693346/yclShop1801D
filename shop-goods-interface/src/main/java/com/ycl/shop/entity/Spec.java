package com.ycl.shop.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
    * @ClassName: Spec
    * @Description: TODO(规格的实体类)
    * @author 袁成龙
    * @date 2020年6月24日
    *
 */
public class Spec implements Serializable{
	
	
	    /**
	    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	    */
	    
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String specName;
	private List<SpecOption> options;
	
	
	
	public List<SpecOption> getOptions() {
		return options;
	}
	public void setOptions(List<SpecOption> options) {
		this.options = options;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	
	@Override
	public String toString() {
		return "Spec [id=" + id + ", specName=" + specName + ", options=" + options + "]";
	}
	
	public Spec(Integer id, String specName, List<SpecOption> options) {
		super();
		this.id = id;
		this.specName = specName;
		this.options = options;
	}
	public Spec() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Spec(String specName) {
		super();
		this.specName = specName;
	}
	
	
	
}
