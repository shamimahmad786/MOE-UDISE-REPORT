package com.moe.universal.report.pojo;

import java.util.Objects;

public class SunBurstChartBean {
	
	private String id;
	private String name;
	private String parent;
	private String column_name;
	private Integer value;
	//private String color;
	
	
	
	public SunBurstChartBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public SunBurstChartBean(String id, String name, String parent, String column_name, Integer value) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.column_name = column_name;
		this.value = value;
	}
	
//
//
//	public String getColor() {
//		return color;
//	}
//
//
//
//	public void setColor(String color) {
//		this.color = color;
//	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}



	@Override
	public int hashCode() {
		return Objects.hash(column_name, id, name);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SunBurstChartBean other = (SunBurstChartBean) obj;
		return Objects.equals(column_name, other.column_name) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}





	
	
	

}
