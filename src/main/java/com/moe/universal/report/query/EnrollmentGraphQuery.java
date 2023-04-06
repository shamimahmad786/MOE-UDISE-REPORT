package com.moe.universal.report.query;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moe.universal.report.pojo.QueryBuilderDependency;
import com.moe.universal.report.util.NativeRepository;
import com.moe.universal.report.util.QueryBuilder;

@Component
public class EnrollmentGraphQuery {

	@Autowired
	NativeRepository nativeRepository;
	
	public String enrollmentGraphQuery(Map<String, Object> dependency, Map<String, String> dependentValue) {
		QueryBuilder qbObj=new QueryBuilder();
		QueryBuilderDependency qbuildObj=new QueryBuilderDependency();
		String query = null;
		if(String.valueOf(dependency.get("mapId")).equalsIgnoreCase("1002")) {
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
//			getDynamicQueryPojo(qbuildObj,dependency,dependentValue);
			qbuildObj.setGroupSet(" grouping sets ( ("+qbuildObj.getGroupSet()+"), () ) ");
		    query=qbObj.gereratQuery(qbuildObj);
		}
		
		
		
		
		return query;
		
	}
	
}
