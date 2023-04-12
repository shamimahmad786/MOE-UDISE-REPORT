package com.moe.universal.report.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moe.universal.report.pojo.InputDependency;
import com.moe.universal.report.query.CollumnMapping;
import com.moe.universal.report.query.EnrollmentQuery;
import com.moe.universal.report.repository.ColumnDefinationRepository;
import com.moe.universal.report.util.NativeRepository;
import com.moe.universal.report.util.QueryResult;

@Service
public class TabularReportService {
	
	
	@Autowired
	EnrollmentQuery enrollmentQuery;
	
	@Autowired
	ObjectMapper mapperObj;
	
	@Autowired
	NativeRepository nativeRepository;
	
	@Autowired
	ColumnDefinationRepository columnDefinationRepository;
	List<String> socList = Arrays.asList("0", "1", "2", "3", "5");
	
	public QueryResult getTabularJson(String dependency) {
		String query=null;
		QueryResult result=new QueryResult();
		Map<String, Object>	dependentObj=null;
		Map<String,String> dependValue=null;
		try {
		dependentObj = mapperObj.readValue(dependency, new TypeReference<HashMap<String, Object>>() {
		});
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		try {
			dependValue=(Map<String,String>)dependentObj.get("dependency");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		query=enrollmentQuery.enrollmentQuery(dependentObj,dependValue);
		if(query !=null) {
			result=nativeRepository.executeQueries(query);
			//result.setDisplaySet(CollumnMapping.getColumnDescription(result.getColumnName()));
			List<Map<String,Object>> ltOfHeader=	CollumnMapping.getColumn(columnDefinationRepository,Integer.valueOf(dependentObj.get("mapId").toString()));
			
			System.out.println("Report for--->"+dependValue.get("reportFor"));
			System.out.println("dependValue--->"+dependentObj);
			if(dependentObj.get("SocialCategoryType") !=null && socList.contains(String.valueOf(dependentObj.get("SocialCategoryType")))) {
				
				Map<String, Object> cMap2 = new HashMap<String, Object>();
				cMap2.put("field", "social_category_name");
				cMap2.put("headerName", "Soc. Category");
				cMap2.put("width", 180);
				ltOfHeader.add(0, cMap2);
			}
			if(dependentObj.get("managementType") !=null && String.valueOf(dependentObj.get("managementType")).equalsIgnoreCase("1")) {
				
				Map<String, Object> cMap2 = new HashMap<String, Object>();
				cMap2.put("field", "broad_management_name");
				cMap2.put("headerName", "Management");
				cMap2.put("width", 180);
				ltOfHeader.add(0, cMap2);
			}else if(dependentObj.get("managementType") !=null && String.valueOf(dependentObj.get("managementType")).equalsIgnoreCase("2")) {
				Map<String, Object> cMap2 = new HashMap<String, Object>();
				cMap2.put("field", "sch_mgmt_center_name");
				cMap2.put("headerName", "Management");
				cMap2.put("width", 180);
				ltOfHeader.add(0, cMap2);
			}
			else if(dependentObj.get("reportFor") !=null && String.valueOf(dependentObj.get("reportFor")).equalsIgnoreCase("1")) {
				
				Map<String, Object> cMap2 = new HashMap<String, Object>();
				cMap2.put("field", "state_name");
				cMap2.put("headerName", "State Name");
				cMap2.put("width", 250);
				ltOfHeader.add(0, cMap2);
			}
			else if(dependentObj.get("reportFor") !=null && String.valueOf(dependentObj.get("reportFor")).equalsIgnoreCase("2")) {
				
				Map<String, Object> cMap2 = new HashMap<String, Object>();
				cMap2.put("field", "state_name");
				cMap2.put("headerName", "State Name");
				cMap2.put("width", 250);
				ltOfHeader.add(0, cMap2);
				
				Map<String, Object> cMap3 = new HashMap<String, Object>();
				cMap3.put("field", "district_name");
				cMap3.put("headerName", "District Name");
				cMap3.put("width", 250);
				ltOfHeader.add(1, cMap3);
			}
			else if(dependentObj.get("reportFor") !=null && String.valueOf(dependentObj.get("reportFor")).equalsIgnoreCase("3")) {
				
				Map<String, Object> cMap2 = new HashMap<String, Object>();
				cMap2.put("field", "state_name");
				cMap2.put("headerName", "State Name");
				cMap2.put("width", 250);
				ltOfHeader.add(0, cMap2);
				
				Map<String, Object> cMap3 = new HashMap<String, Object>();
				cMap3.put("field", "district_name");
				cMap3.put("headerName", "District Name");
				cMap3.put("width", 250);
				ltOfHeader.add(1, cMap3);
				
				Map<String, Object> cMap4 = new HashMap<String, Object>();
				cMap4.put("field", "block_name");
				cMap4.put("headerName", "Block Name");
				cMap4.put("width", 250);
				ltOfHeader.add(2, cMap4);
			}
	
			
			System.out.println("header-->"+ltOfHeader);
			result.setTableHader(ltOfHeader);
			result.setTemplateType(1);
			List<HashMap<String,String>> lt=new ArrayList<HashMap<String,String>>();
			HashMap<String,String> hs=new HashMap<String,String>();
			hs.put("filterId", "management");
			lt.add(hs);
			hs.put("filterId", "socialcategory");
			lt.add(hs);
			result.setFilterData(lt);
			System.out.println(result);
		}
		return result;
	}
	
}
