package com.moe.universal.report.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QueryBuilderDependency {
	
private String fieldSet;
private String condition;
private String groupSet;
private String filterSet;
private String tableName;
private String isGroup;
private String isCondition;
private String isOrderBy;
private String orderBy;
private Integer yearId;


public Integer getYearId() {
	return yearId;
}
public void setYearId(Integer yearId) {
	this.yearId = yearId;
}
public String getFieldSet() {
	return fieldSet;
}
public void setFieldSet(String fieldSet) {
	this.fieldSet = fieldSet;
}
public String getCondition() {
	return condition;
}
public void setCondition(String condition) {
	this.condition = condition;
}
public String getGroupSet() {
	return groupSet;
}
public void setGroupSet(String groupSet) {
	this.groupSet = groupSet;
}
public String getFilterSet() {
	return filterSet;
}
public void setFilterSet(String filterSet) {
	this.filterSet = filterSet;
}
public String getTableName() {
	return tableName;
}
public void setTableName(String tableName) {
	this.tableName = tableName;
}
public String getIsGroup() {
	return isGroup;
}
public void setIsGroup(String isGroup) {
	this.isGroup = isGroup;
}
public String getIsCondition() {
	return isCondition;
}
public void setIsCondition(String isCondition) {
	this.isCondition = isCondition;
}
public String getIsOrderBy() {
	return isOrderBy;
}
public void setIsOrderBy(String isOrderBy) {
	this.isOrderBy = isOrderBy;
}
public String getOrderBy() {
	return orderBy;
}
public void setOrderBy(String orderBy) {
	this.orderBy = orderBy;
}





}
