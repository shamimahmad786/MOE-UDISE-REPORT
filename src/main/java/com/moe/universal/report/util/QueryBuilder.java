package com.moe.universal.report.util;

import com.moe.universal.report.pojo.InputDependency;
import com.moe.universal.report.pojo.QueryBuilderDependency;

public class QueryBuilder {

	
	public String gereratQuery(QueryBuilderDependency dependency) {
		String query=null;
		query=" select "+dependency.getFieldSet() +" from "+ dependency.getTableName();
		
if(dependency.getIsCondition().equalsIgnoreCase("Y")) {
	query += " where "+dependency.getCondition();
		}
		
System.out.println("dependency.getIsGroup()--->"+dependency.getIsGroup());
		if(dependency.getIsGroup() != null && dependency.getIsGroup().equalsIgnoreCase("Y")) {
			query +=" group by  "+	dependency.getGroupSet();
		}
		
		
		System.out.println("dependency.getIsOrderBy()--->"+dependency.getIsOrderBy());
		if(dependency.getIsOrderBy() != null &&dependency.getIsOrderBy().equalsIgnoreCase("Y")) {
			query += "  order by "+	dependency.getOrderBy();
		}
		
		System.out.println("Prepared query--->"+query);
		
		return query;
	}
}
