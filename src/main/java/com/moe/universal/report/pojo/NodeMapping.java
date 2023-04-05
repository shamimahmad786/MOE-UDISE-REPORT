package com.moe.universal.report.pojo;

import java.util.Objects;

public class NodeMapping {
	
	private Integer id;
	private String name;
	private Integer parent;
	private Integer value;
	
	
	
	public NodeMapping(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, parent);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodeMapping other = (NodeMapping) obj;
		return Objects.equals(name, other.name) && Objects.equals(parent, other.parent);
	}
	

	
}
