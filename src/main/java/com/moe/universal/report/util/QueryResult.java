package com.moe.universal.report.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.moe.universal.report.pojo.NodeMapping;
import com.moe.universal.report.pojo.SunBurstChartBean;

@Component
public class QueryResult {
	private List<Object> columnName;
	private List<Map<String, Object>> rowValue;
	private List<Map<String, Object>> yearList;
	private List<Object> columnDataType;
	private List<HashMap<String, Object>> displaySet;
	private Integer templateType; 
	private List<HashMap<String, String>> filterData;
	
	private List<Map<String, Object>> tableHader;
	private Map<NodeMapping,NodeMapping> tableHader1;
	private Set<SunBurstChartBean> data;
	
	
	
	
	public List<Map<String, Object>> getYearList() {
		return yearList;
	}
	public void setYearList(List<Map<String, Object>> yearList) {
		this.yearList = yearList;
	}
	public Set<SunBurstChartBean> getData() {
		return data;
	}
	public void setData(Set<SunBurstChartBean> data) {
		this.data = data;
	}
	public Map<NodeMapping, NodeMapping> getTableHader1() {
		return tableHader1;
	}
	public void setTableHader1(Map<NodeMapping, NodeMapping> tableHader1) {
		this.tableHader1 = tableHader1;
	}
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
	
	
	
	
	public List<Map<String, Object>> getTableHader() {
		return tableHader;
	}
	public void setTableHader(List<Map<String, Object>> tableHader) {
		this.tableHader = tableHader;
	}
	@Override
	public String toString() {
		return "QueryResult [columnName=" + columnName + ", rowValue=" + rowValue + "]";
	}
}