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



}
