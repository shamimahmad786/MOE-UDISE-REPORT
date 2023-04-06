package com.moe.universal.report.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moe.universal.report.query.CollumnMapping;
import com.moe.universal.report.query.EnrollmentGraphQuery;
import com.moe.universal.report.query.EnrollmentQuery;
import com.moe.universal.report.repository.ColumnDefinationRepository;
import com.moe.universal.report.util.ColumnMappingForDataRepresent;
import com.moe.universal.report.util.NativeRepository;
import com.moe.universal.report.util.QueryResult;

@Service
public class SunBurstReportService {
	
	@Autowired
	EnrollmentGraphQuery enrollmentGraphQuery;
	
	@Autowired
	ObjectMapper mapperObj;
	
	@Autowired
	NativeRepository nativeRepository;

	
	@Autowired
	ColumnDefinationRepository columnDefinationRepository;
	
	public QueryResult getSunBurstDataService(String dependency,String jsonFilePath) {
		
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
		query=enrollmentGraphQuery.enrollmentGraphQuery(dependentObj,dependValue);
		if(query !=null) {
			result=nativeRepository.executeQueries(query);
			//String filePath = "d:\\Testjson.json";
			 JSONObject json = readJSON(jsonFilePath);
			 JSONArray records = json.getJSONArray("records");
             JSONObject recordToUpdate = null;
//           while (result.next()) {
//            	 
//            	 String rdColumn_name= rsData.getString("column_name");
//            	 String rdvalue= rsData.getString("value");
//            	 
//                 for (int i = 0; i < records.length(); i++) {
//                     JSONObject record = records.getJSONObject(i);
//                       if (record.getString("column_name").equals(rdColumn_name)) {
//    	            	   recordToUpdate  = record;
//    	               break;
//    	               }
//                 	}
//                 if (recordToUpdate != null) {
//                     recordToUpdate.put("value", rdvalue);
//                 }
//                 System.out.println(json);
//            	 
//             }
//			ColumnMappingForDataRepresent columnMappingForDataRepresent = new ColumnMappingForDataRepresent();
//			//result.setDisplaySet(CollumnMapping.getColumnDescription(result.getColumnName()));
//			
//			System.out.println( "MapId " +Integer.parseInt(dependentObj.get("mapId").toString()));
//			//result.setTableHader1(columnMappingForDataRepresent.getColumnMappingSunBurst(columnDefinationRepository,dependentObj.get("mapId") != null? Integer.parseInt(dependentObj.get("mapId").toString()):0));
//			result.setTemplateType(1);
//			List<HashMap<String,String>> lt=new ArrayList<HashMap<String,String>>();
//			HashMap<String,String> hs=new HashMap<String,String>();
//			hs.put("filterId", "management");
//			lt.add(hs);
//			hs.put("filterId", "socialcategory");
//			lt.add(hs);
//			result.setFilterData(lt);
//			System.out.println(result);
		}
		return result;
		
	}
	
	 public static JSONObject readJSON(String filePath)  {
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(filePath));
	            StringBuilder builder = new StringBuilder();
	            String line;
	            while ((line = reader.readLine()) != null) {
	                builder.append(line);
	            }
	            reader.close();
	            new JSONObject();
	            return new JSONObject(builder.toString());
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

}