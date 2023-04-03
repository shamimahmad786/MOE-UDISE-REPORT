package com.moe.universal.report.query;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moe.universal.report.pojo.InputDependency;
import com.moe.universal.report.pojo.QueryBuilderDependency;
import com.moe.universal.report.util.NativeRepository;
import com.moe.universal.report.util.QueryBuilder;

@Component
public class EnrollmentQuery {

	@Autowired
	NativeRepository nativeRepository;
	
	public String enrollmentQuery(Map<String, Object> dependency, Map<String, String> dependentValue) {
	
		QueryBuilder qbObj=new QueryBuilder();
		QueryBuilderDependency qbuildObj=new QueryBuilderDependency();
		String query = null;
		
		if(String.valueOf(dependency.get("mapId")).equalsIgnoreCase("1001")) {
//			if(String.valueOf(dependency.get("reportFor")).equalsIgnoreCase("N")) {
				qbuildObj.setFieldSet("sum(cpp_b) as cpp_b, sum(cpp_g) as cpp_g, sum(c1_b) as c1_b, sum(c1_g) as c1_g, sum(c2_b) as c2_b, sum(c2_g) as c2_g, sum(c3_b) as c3_b, sum(c3_g) as c3_g, sum(c4_b) as c4_b, sum(c4_g) as c4_g, sum(c5_b) as c5_b, sum(c5_g) as c5_g, sum(c6_b) as c6_b, sum(c6_g) as c6_g, sum(c7_b) as c7_b, sum(c7_g) as c7_g, sum(c8_b) as c8_b, sum(c8_g) as c8_g, sum(c9_b) as c9_b, sum(c9_g) as c9_g, sum(c10_b) as c10_b, sum(c10_g) as c10_g, sum(c11_b) as c11_b, sum(c11_g) as c11_g, sum(c12_b) as c12_b, sum(c12_g) as c12_g");
//				qbuildObj.setDisplaySet(CollumnMapping.getColumnDescription());
				qbuildObj.setTableName("udisereportnew.enrollment_social_categorywise esc");
				qbuildObj.setIsCondition("Y");
//				qbuildObj.setIsGroup("Y");
				qbuildObj.setCondition(" 1=1 ");
				
//				
//				qbuildObj.setIsOrderBy("Y");
//				qbuildObj.setOrderBy("social_category_id  ");
//			}
			
			
			
			getDynamicQueryPojo(qbuildObj,dependency,dependentValue);
			qbuildObj.setGroupSet(" grouping sets ( ("+qbuildObj.getGroupSet()+"), () ) ");
			 query=qbObj.gereratQuery(qbuildObj);
			 
//			 if(query !=null) {
//				 nativeRepository.executeQueries(query);
//			 }
			 
		}else if(String.valueOf(dependency.get("mapId")).equalsIgnoreCase("1002")) {
			
			qbuildObj.setFieldSet(" sum(c1_b+c2_b+c3_b+c4_b+c5_b) filter(where sch_broad_mgt_id = 1) as primary_boys_govt , \r\n"
					+ "sum(c6_b+c7_b+c8_b) filter(where sch_broad_mgt_id= 1) as upper_primary_boys_govt, \r\n"
					+ "sum(c9_b+c10_b) filter(where sch_broad_mgt_id= 1) as secondary_boys_govt,\r\n"
					+ "sum(c11_b+c12_b) filter(where sch_broad_mgt_id= 1) as higher_secondary_boys_govt,\r\n"
					+ "sum(c1_b+c2_b+c3_b+c4_b+c5_b) filter(where sch_broad_mgt_id = 2) as primary_boys_govt_aided ,\r\n"
					+ "sum(c6_b+c7_b+c8_b) filter(where sch_broad_mgt_id= 2) as upper_primary_boys_govt_aided,\r\n"
					+ "sum(c9_b+c10_b) filter(where sch_broad_mgt_id= 2) as secondary_boys_govt_aided,\r\n"
					+ "sum(c11_b+c12_b) filter(where sch_broad_mgt_id= 2) as higher_secondary_boys_govt_aided,\r\n"
					+ "sum(c1_b+c2_b+c3_b+c4_b+c5_b) filter(where sch_broad_mgt_id = 3) as primary_boys_private ,\r\n"
					+ "sum(c6_b+c7_b+c8_b) filter(where sch_broad_mgt_id= 3) as upper_primary_boys_private,\r\n"
					+ "sum(c9_b+c10_b) filter(where sch_broad_mgt_id= 3) as secondary_boys_private, \r\n"
					+ "sum(c11_b+c12_b) filter(where sch_broad_mgt_id= 3) as higher_secondary_boys_private, \r\n"
					+ "sum(c1_b+c2_b+c3_b+c4_b+c5_b) filter(where sch_broad_mgt_id = 4) as primary_boys_other ,\r\n"
					+ "sum(c6_b+c7_b+c8_b) filter(where sch_broad_mgt_id= 4) as upper_primary_boys_other,\r\n"
					+ "sum(c9_b+c10_b) filter(where sch_broad_mgt_id= 4) as secondary_boys_other, \r\n"
					+ "sum(c11_b+c12_b) filter(where sch_broad_mgt_id= 4) as higher_secondary_boys_other,\r\n"
					+ "sum(c1_g+c2_g+c3_g+c4_g+c5_g) filter(where sch_broad_mgt_id = 1) as primary_girls_govt ,\r\n"
					+ "sum(c6_g+c7_g+c8_g) filter(where sch_broad_mgt_id= 1) as upper_primary_girls_govt,\r\n"
					+ "sum(c9_g+c10_g) filter(where sch_broad_mgt_id= 1) as secondary_girls_govt, \r\n"
					+ "sum(c11_g+c12_g) filter(where sch_broad_mgt_id= 1) as higher_secondary_girls_govt, \r\n"
					+ "sum(c1_g+c2_g+c3_g+c4_g+c5_g) filter(where sch_broad_mgt_id = 2) as primary_girls_govt_aided ,\r\n"
					+ "sum(c6_g+c7_g+c8_g) filter(where sch_broad_mgt_id= 2) as upper_primary_girls_govt_aided,\r\n"
					+ "sum(c9_g+c10_g) filter(where sch_broad_mgt_id= 2) as secondary_girls_govt_aided,\r\n"
					+ "sum(c11_g+c12_g) filter(where sch_broad_mgt_id= 2) as higher_secondary_girls_govt,\r\n"
					+ "sum(c1_g+c2_g+c3_g+c4_g+c5_g) filter(where sch_broad_mgt_id = 3) as primary_girls_private ,\r\n"
					+ "sum(c6_g+c7_g+c8_g) filter(where sch_broad_mgt_id= 3) as upper_primary_girls_govt_private,\r\n"
					+ "sum(c9_g+c10_g) filter(where sch_broad_mgt_id= 3) as secondary_girls_private,\r\n"
					+ "sum(c11_g+c12_g) filter(where sch_broad_mgt_id= 3) as higher_secondary_girls_private, \r\n"
					+ "sum(c1_g+c2_g+c3_g+c4_g+c5_g) filter(where sch_broad_mgt_id = 4) as primary_girls_other ,\r\n"
					+ "sum(c6_g+c7_g+c8_g) filter(where sch_broad_mgt_id= 4) as upper_primary_girls_other, \r\n"
					+ "sum(c9_g+c10_g) filter(where sch_broad_mgt_id= 4) as secondary_girls_other ");
			qbuildObj.setTableName("udisereportnew.enrollment_social_categorywise esc");
			qbuildObj.setIsCondition("Y");
			qbuildObj.setCondition(" 1=1 ");
			getDynamicQueryPojo(qbuildObj,dependency,dependentValue);
			qbuildObj.setGroupSet(" grouping sets ( ("+qbuildObj.getGroupSet()+"), () ) ");
		    query=qbObj.gereratQuery(qbuildObj);
		}
		
		
		return query;
		
	}
	
	public QueryBuilderDependency getDynamicQueryPojo(QueryBuilderDependency qbuildObj, Map<String, Object> dependency, Map<String, String> dependentValue) {
		
		String reportFor=String.valueOf(dependency.get("reportFor"));
		String categoryType=String.valueOf(dependency.get("cateoryType"));
		String managementType=String.valueOf(dependency.get("managementType"));
		
		if(reportFor.equalsIgnoreCase("0")) {
			qbuildObj.setIsCondition("N");
			qbuildObj.setCondition("");
		}else if(reportFor.equalsIgnoreCase("1")) {
			
			System.out.println("in 1--->"+dependentValue.get("stateId"));
			qbuildObj.setIsCondition("Y");
			if(!dependentValue.get("stateId").equalsIgnoreCase("0")) {
			qbuildObj.setCondition(" state_id="+dependentValue.get("stateId")+" ");
			}
			qbuildObj.setFieldSet(qbuildObj.getFieldSet()+ ", state_name ");
			qbuildObj.setIsGroup("Y");
			qbuildObj.setGroupSet(" state_name ");
			qbuildObj.setIsOrderBy("Y");
			qbuildObj.setOrderBy(" state_name ");
		}else if(reportFor.equalsIgnoreCase("2")) {
			qbuildObj.setIsCondition("Y");
			if(dependentValue.get("districtId").equalsIgnoreCase("0")) {
				qbuildObj.setCondition(" state_id="+dependentValue.get("stateId")+" ");	
			}else {
			qbuildObj.setCondition(" state_id="+dependentValue.get("stateId")+" and district_id="+dependentValue.get("districtId")+" ");
			}
		}else if(reportFor.equalsIgnoreCase("3")) {
			qbuildObj.setIsCondition("Y");
			qbuildObj.setCondition(" state_id="+dependentValue.get("stateId")+" and district_id="+dependentValue.get("districtId")+" and block_id="+dependentValue.get("block_id")+" ");
		}else if(reportFor.equalsIgnoreCase("4")) {
			qbuildObj.setIsCondition("Y");
			qbuildObj.setCondition(" state_id="+dependentValue.get("stateId")+" and district_id="+dependentValue.get("districtId")+" and block_id="+dependentValue.get("block_id")+" and parliament_id="+dependentValue.get("parliamentId")+" ");
		}
		
		
		if(categoryType.equalsIgnoreCase("0")) {
			qbuildObj.setFieldSet( " social_category_name ," + qbuildObj.getFieldSet());
			qbuildObj.setIsGroup("Y");
			
			System.out.println("Group set--->"+qbuildObj.getGroupSet());
			
			if(qbuildObj.getGroupSet()==null || qbuildObj.getGroupSet().isEmpty()) {
			qbuildObj.setGroupSet("social_category_name");
			}else {
				qbuildObj.setGroupSet(qbuildObj.getGroupSet()+",social_category_name");
			}
			qbuildObj.setIsOrderBy("Y");
			qbuildObj.setOrderBy("social_category_name");
		}else if(categoryType.equalsIgnoreCase("9")) {
			if(qbuildObj.getIsGroup()==null || qbuildObj.getIsGroup().isEmpty()) {
			qbuildObj.setIsGroup("N");
			}
			if(qbuildObj.getIsOrderBy()==null ||  qbuildObj.getIsOrderBy().isEmpty()) {
			qbuildObj.setIsOrderBy("N");
			}
//			qbuildObj.setCondition(qbuildObj.getCondition() + " and social_category_id="+dependentValue.get("cateoryType"));
		}else if(categoryType.equalsIgnoreCase("1") || categoryType.equalsIgnoreCase("2") || categoryType.equalsIgnoreCase("3") || categoryType.equalsIgnoreCase("4") ) {
			qbuildObj.setIsCondition("Y");
			qbuildObj.setCondition(qbuildObj.getCondition() + " and social_category_id="+dependency.get("cateoryType"));
			qbuildObj.setFieldSet(" social_category_name ," +qbuildObj.getFieldSet());
			qbuildObj.setIsGroup("Y");
			if(qbuildObj.getGroupSet()==null || qbuildObj.getGroupSet().isEmpty()) {
				qbuildObj.setGroupSet("social_category_name");
				}else {
					qbuildObj.setGroupSet(qbuildObj.getGroupSet()+",social_category_name");
				}
			qbuildObj.setIsOrderBy("Y");
			qbuildObj.setOrderBy("social_category_name");
			
		}
		
		
		if(managementType.equalsIgnoreCase("9")) {
			if(qbuildObj.getIsGroup().isEmpty()) {
				qbuildObj.setIsGroup("N");
				}
				if(qbuildObj.getIsOrderBy().isEmpty()) {
				qbuildObj.setIsOrderBy("N");
				}
		}else if(managementType.equalsIgnoreCase("1")) {
			
//System.out.println("managementValue--->"+dependency.get("managementValue"));
			
			if(!String.valueOf(dependency.get("managementValue")).equalsIgnoreCase("0")) {
				qbuildObj.setIsCondition("Y");
				qbuildObj.setCondition(qbuildObj.getCondition() + " and sch_broad_mgt_id in ("+dependency.get("managementValue")+")");	
				qbuildObj.setFieldSet(" broad_management_name , " +qbuildObj.getFieldSet());
				qbuildObj.setIsGroup("Y");
				qbuildObj.setGroupSet(qbuildObj.getGroupSet()+ " ,broad_management_name ");
				qbuildObj.setIsOrderBy("Y");
				qbuildObj.setOrderBy(qbuildObj.getOrderBy()+" ,broad_management_name ");
			}else if(String.valueOf(dependency.get("managementValue")).equalsIgnoreCase("0")) {
//				qbuildObj.setIsCondition("Y");
//				qbuildObj.setCondition(qbuildObj.getCondition() + " and sch_broad_mgt_id in ("+dependency.get("managementValue")+")");	
				qbuildObj.setFieldSet( " broad_management_name ," +qbuildObj.getFieldSet());
				qbuildObj.setIsGroup("Y");
//				qbuildObj.setGroupSet(qbuildObj.getGroupSet()+ " ,broad_management_name ");
				qbuildObj.setIsOrderBy("Y");
//				qbuildObj.setOrderBy(qbuildObj.getOrderBy()+" ,broad_management_name ");
				
				if(qbuildObj.getGroupSet() !=null) {
					qbuildObj.setGroupSet(qbuildObj.getGroupSet()+ " ,broad_management_name ");
					qbuildObj.setOrderBy(qbuildObj.getOrderBy()+" ,broad_management_name ");
				}else {
					qbuildObj.setGroupSet(" broad_management_name ");
					qbuildObj.setOrderBy(" broad_management_name ");
				}
				
			}
		}else if(managementType.equalsIgnoreCase("2")) {
			if(!String.valueOf(dependency.get("managementValue")).equalsIgnoreCase("0")) {
				qbuildObj.setIsCondition("Y");
				qbuildObj.setCondition(qbuildObj.getCondition() + " and sch_mgmt_center_id in ("+dependency.get("managementValue")+")");	
				qbuildObj.setFieldSet(qbuildObj.getFieldSet()+ ", sch_mgmt_center_name ");
				qbuildObj.setIsGroup("Y");
//				qbuildObj.setGroupSet(qbuildObj.getGroupSet()+ " ,sch_mgmt_center_name ");
				qbuildObj.setIsOrderBy("Y");
//				qbuildObj.setOrderBy(qbuildObj.getOrderBy()+" ,broad_management_name ");
				
				if(qbuildObj.getGroupSet() !=null) {
					qbuildObj.setGroupSet(qbuildObj.getGroupSet()+ " ,sch_mgmt_center_name ");
					qbuildObj.setOrderBy(qbuildObj.getOrderBy()+" ,sch_mgmt_center_name ");
				}else {
					qbuildObj.setGroupSet("sch_mgmt_center_name ");
					qbuildObj.setOrderBy(" sch_mgmt_center_name ");
				}
				
				
			}else if(String.valueOf(dependency.get("managementValue")).equalsIgnoreCase("0")) {
//				qbuildObj.setIsCondition("Y");
//				qbuildObj.setCondition(qbuildObj.getCondition() + " and sch_mgmt_center_id in ("+dependency.get("managementValue")+")");	
				qbuildObj.setFieldSet( " sch_mgmt_center_name ," +qbuildObj.getFieldSet());
				qbuildObj.setIsGroup("Y");
				
				if(qbuildObj.getGroupSet() !=null) {
				qbuildObj.setGroupSet(qbuildObj.getGroupSet()+ " ,sch_mgmt_center_name ");
				qbuildObj.setOrderBy(qbuildObj.getOrderBy()+" ,sch_mgmt_center_name ");
				}else {
					qbuildObj.setGroupSet( " sch_mgmt_center_name ");
					qbuildObj.setOrderBy(" sch_mgmt_center_name ");
				}
				qbuildObj.setIsOrderBy("Y");
				
			}
		}
		
		
		
		
		return qbuildObj;
		
	}
	
	
}
