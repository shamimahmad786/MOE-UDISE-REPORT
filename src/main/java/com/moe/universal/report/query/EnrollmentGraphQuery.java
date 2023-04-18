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
	
	public String enrollmentGraphQuery(String mapId) {
		QueryBuilder qbObj=new QueryBuilder();
		QueryBuilderDependency qbuildObj=new QueryBuilderDependency();
		String query = null;
		//String mapId = String.valueOf(dependency.get("mapId"));
	
	
		switch (mapId) {
		case "1001":
			qbuildObj.setFieldSet(" sum(cpp_b) as cpp_b, sum(cpp_g) as cpp_g, sum(c1_b) as c1_b, sum(c1_g) as c1_g, sum(c2_b) as c2_b, sum(c2_g) as c2_g, sum(c3_b) as c3_b, sum(c3_g) as c3_g, sum(c4_b) as c4_b, sum(c4_g) as c4_g, sum(c5_b) as c5_b, sum(c5_g) as c5_g, sum(c6_b) as c6_b, sum(c6_g) as c6_g, sum(c7_b) as c7_b, sum(c7_g) as c7_g, sum(c8_b) as c8_b, sum(c8_g) as c8_g, sum(c9_b) as c9_b, sum(c9_g) as c9_g, sum(c10_b) as c10_b, sum(c10_g) as c10_g, sum(c11_b) as c11_b, sum(c11_g) as c11_g, sum(c12_b) as c12_b, sum(c12_g) as c12_g ");
			qbuildObj.setTableName("udisereportnew.enrollment_social_categorywise esc");
			qbuildObj.setIsCondition("Y");
			qbuildObj.setCondition(" 1=1 ");
			qbuildObj.setGroupSet(" grouping sets ( ("+qbuildObj.getGroupSet()+"), () ) ");
		    query=qbObj.gereratQuery(qbuildObj);
			break;
		case "1002" :
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
			qbuildObj.setGroupSet(" grouping sets ( ("+qbuildObj.getGroupSet()+"), () ) ");
		    query=qbObj.gereratQuery(qbuildObj);
		default:
			break;
		}

		
		return query;
		
	}
	
}
