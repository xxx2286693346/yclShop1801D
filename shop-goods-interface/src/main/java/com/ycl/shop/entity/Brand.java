package com.ycl.shop.entity;

import java.io.Serializable;

/**
 * 
    * @ClassName: Brand
    * @Description: TODO(品牌的实体类)
    * @author 袁成龙
    * @date 2020年6月23日
    *
 */
public class Brand implements Serializable{
	
	
	    /**
	    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	    */
	    
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String firstChar;
	private int  deletedFlag;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstChar() {
		return firstChar;
	}
	public void setFirstChar(String firstChar) {
		this.firstChar = firstChar;
	}
	public int getDeletedFlag() {
		return deletedFlag;
	}
	public void setDeletedFlag(int deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Brand(Integer id, String name, String firstChar, int deletedFlag) {
		super();
		this.id = id;
		this.name = name;
		this.firstChar = firstChar;
		this.deletedFlag = deletedFlag;
	}
	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", firstChar=" + firstChar + ", deletedFlag=" + deletedFlag + "]";
	}
	
	
}
