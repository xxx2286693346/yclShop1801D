package com.ycl.shop.entity;

import java.io.Serializable;

/**
 * 
    * @ClassName: SpecOption
    * @Description: TODO(规格属性)
    * @author 袁成龙
    * @date 2020年6月24日
    *
 */
public class SpecOption implements Serializable{
	
	
	    /**
	    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	    */
	    
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String  optionName;
	private Integer  specId;;
	private String pecName;
	private Integer  orders;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public String getPecName() {
		return pecName;
	}
	public void setPecName(String pecName) {
		this.pecName = pecName;
	}
	public Integer getOrders() {
		return orders;
	}
	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	
	public Integer getSpecId() {
		return specId;
	}
	public void setSpecId(Integer specId) {
		this.specId = specId;
	}
	public SpecOption() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SpecOption [id=" + id + ", optionName=" + optionName + ", specId=" + specId + ", pecName=" + pecName
				+ ", orders=" + orders + "]";
	}
	
	
	
	
}
