package com.moe.universal.report.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moe.universal.report.query.CollumnMapping;
import com.moe.universal.report.query.EnrollmentQuery;
import com.moe.universal.report.repository.ColumnDefinationRepository;
import com.moe.universal.report.util.ColumnMappingForDataRepresent;
import com.moe.universal.report.util.NativeRepository;
import com.moe.universal.report.util.QueryResult;

@Service
public class SunBurstReportService {
	
	@Autowired
	EnrollmentQuery enrollmentQuery;
	
	@Autowired
	ObjectMapper mapperObj;
	
	@Autowired
	NativeRepository nativeRepository;
	
	@Autowired
	ColumnDefinationRepository columnDefinationRepository;
	
	public QueryResult getSunBurstDataService(String dependency) {
		
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
			System.out.println( "MapId " +Integer.parseInt(dependentObj.get("mapId").toString()));
			result.setTableHader1(ColumnMappingForDataRepresent.getColumnMappingSunBurst(columnDefinationRepository,dependentObj.get("mapId") != null? Integer.parseInt(dependentObj.get("mapId").toString()):0));
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
