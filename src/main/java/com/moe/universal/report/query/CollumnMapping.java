package com.moe.universal.report.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CollumnMapping {

//	public static	List<HashMap<String,String>> commomHeadersFromExcel =[{"hhh":"hh"}];
//	List<Map<String, Integer>> myBooks = [
//	                                      {"id": 1, "name": "HTML and CSS", "price": 1100},
//	                                      {"id": 2, "name": "Python", "price": 2100},
//	                                      {"id": 3, "name": "Dart", "price": 100},
//	                                      {"id": 4, "name": "Java", "price": 100},
//	                                      {"id": 5, "name": "JavaScript", "price": 110},
//	                                      {"id": 6, "name": "Swift", "price": 90},
//	                                      {"id": 7, "name": "C++", "price": 85},
//	                                      {"id": 8, "name": "C#", "price": 58},
//	                                      {"id": 9, "name": "Python", "price": 100},
//	                                      {"id": 10, "name": "Ruby", "price": 55},
//	                                      {"id": 11, "name": "FrameWork", "price": 125}    
//	                                    ];
	
	public static List<HashMap<String, Object>> getColumnDescription(List<Object> stringList) {
//		List<String> stringList = new ArrayList<String>();

		  List<HashMap<String, Object>> mapList = new  ArrayList<HashMap<String, Object>>();

		  stringList.forEach((e)-> {
//		    Map<String, Object> item = new {"name": e, "selected": false};
//		    mapList.add(item);
		    getColumnDefination(mapList,String.valueOf(e));
		  });
		  return mapList;
	}
	
	public static List<HashMap<String, Object>> getColumnDefination(List<HashMap<String, Object>> mapLis,String columnName){
		
		HashMap<String, Object> hs=new HashMap<String, Object>();
		
	    switch(columnName) {
	    
	    
	    case "social_category_name":
        	hs.put("columnName", "Social Category");
        	hs.put("filterType", "Y");
        	hs.put("width", 200);
//        	hs.put("parentType", "Y");
//        	hs.put("parentName", "Pre Primary Enrolment");
            break;
        case "cpp_b":
        	hs.put("columnName", "Boys");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Pre Primary Enrolment");
            break;
        case "cpp_g":
        	hs.put("columnName", "Girls");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Pre Primary Enrolment");
            break;
        case "cpp_bg":
        	hs.put("columnName", "Total");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Pre Primary Enrolment");
            break;
             
        case "c1_b":
        	hs.put("columnName", "Boys");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-1");
            break;
             
        case "c1_g":
        	hs.put("columnName", "Girls");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-1");
            break;
             
        case "c1_bg":
        	hs.put("columnName", "Total");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-1");
            break;
             
        case "c2_b":
        	hs.put("columnName", "Boys");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-2");
            break;
             
        case "c2_g":
        	hs.put("columnName", "Girls");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-2");
            break;
             
        case "c2_bg":
        	hs.put("columnName", "Total");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-2");
            break;
             
        case "c3_b":
        	hs.put("columnName", "Boys");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-3");
            break;
             
        case "c3_g":
        	hs.put("columnName", "Girls");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-3");
            break;
             
        case "c3_bg":
        	hs.put("columnName", "Total");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-3");
            break;
             
        case "c4_b":
        	hs.put("columnName", "Boys");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-4");
            break;
             
        case "c4_g":
        	hs.put("columnName", "Girls");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-4");
            break;
             
        case "c4_bg":
        	hs.put("columnName", "Total");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-4");
            break;
            
        case "c5_b":
        	hs.put("columnName", "Boys");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-5");
            break;
            
        case "c5_g":
        	hs.put("columnName", "Girls");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-5");
            break;
            
        case "c5_bg":
        	hs.put("columnName", "Total");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-5");
            break;
            
        case "c6_b":
        	hs.put("columnName", "Boys");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-6");
            break;
            
        case "c6_g":
        	hs.put("columnName", "Girls");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-6");
            break;
            
        case "c6_bg":
        	hs.put("columnName", "Total");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-6");
            break;
            
        case "c7_b":
        	hs.put("columnName", "Boys");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-7");
            break;
            
        case "c7_g":
        	hs.put("columnName", "Girls");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-7");
            break;
            
        case "c7_bg":
        	hs.put("columnName", "Total");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-7");
            break;
            
        case "c8_b":
        	hs.put("columnName", "Boys");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-8");
            break;
            
        case "c8_g":
        	hs.put("columnName", "Girls");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-8");
            break;
            
        case "c8_bg":
        	hs.put("columnName", "Total");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-8");
            break;
            
        case "c9_b":
        	hs.put("columnName", "Boys");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-9");
            break;
            
        case "c9_g":
        	hs.put("columnName", "Girls");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-9");
            break;
            
        case "c9_bg":
        	hs.put("columnName", "Total");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-9");
            break;
            
        case "c10_b":
        	hs.put("columnName", "Boys");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-10");
            break;
            
        case "c10_g":
        	hs.put("columnName", "Girls");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-10");
            break;
            
        case "c10_bg":
        	hs.put("columnName", "Total");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-10");
            break;
            
        case "c11_b":
        	hs.put("columnName", "Boys");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-11");
            break;
            
        case "c11_g":
        	hs.put("columnName", "Girls");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-11");
            break;
            
        case "c11_bg":
        	hs.put("columnName", "Total");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-11");
            break;
            
        case "c12_b":
        	hs.put("columnName", "boys");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-12");
            break;
            
        case "c12_g":
        	hs.put("columnName", "Girls");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-12");
            break;
            
        case "c12_bg":
        	hs.put("columnName", "Total");
        	hs.put("filterType", "Y");
        	hs.put("width", 100);
        	hs.put("parentType", "Y");
        	hs.put("parentName", "Class-12");
            break;
        }
	    mapLis.add(hs);
//	    System.out.println(mapLis);
		return mapLis; 
	}
		
}
