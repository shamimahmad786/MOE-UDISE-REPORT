package com.moe.universal.report.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class QueryResult {
	private List<Object> columnName;
	private List<Map<String, Object>> rowValue;
	private List<Object> columnDataType;
	private List<HashMap<String, Object>> displaySet;
	private Integer templateType; 
	private List<HashMap<String, String>> filterData;
	
	public List<Object> getColumnName() {
		return columnName;
	}
	public void setColumnName(List<Object> columnName) {
		this.columnName = columnName;
	}
	public List<Map<String, Object>> getRowValue() {
		return rowValue;
	}
	public void setRowValue(List<Map<String, Object>> rowValue) {
		this.rowValue = rowValue;
	}

	public List<Object> getColumnDataType() {
		return columnDataType;
	}
	public void setColumnDataType(List<Object> columnDataType) {
		this.columnDataType = columnDataType;
	}
	
	
	public List<HashMap<String, Object>> getDisplaySet() {
		return displaySet;
	}
	public void setDisplaySet(List<HashMap<String, Object>> displaySet) {
		this.displaySet = displaySet;
	}
	
	
	
	public Integer getTemplateType() {
		return templateType;
	}
	public void setTemplateType(Integer templateType) {
		this.templateType = templateType;
	}
	
	
	
	
	public List<HashMap<String, String>> getFilterData() {
		return filterData;
	}
	public void setFilterData(List<HashMap<String, String>> filterData) {
		this.filterData = filterData;
	}
	@Override
	public String toString() {
		return "QueryResult [columnName=" + columnName + ", rowValue=" + rowValue + "]";
	}
}