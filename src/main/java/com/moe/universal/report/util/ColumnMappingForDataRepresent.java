package com.moe.universal.report.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moe.universal.report.modal.ColumnDefination;
import com.moe.universal.report.repository.ColumnDefinationRepository;

public class ColumnMappingForDataRepresent {
	
	public static List<Map<String,Object>> getColumnMappingSunBurst(ColumnDefinationRepository columnDefinationRepository,Integer tableId) {
		List<ColumnDefination> coldefObj = columnDefinationRepository.findAllByTableId(tableId);
		List<Map<String,Object>> finalList=new ArrayList<Map<String,Object>>();
		if(coldefObj.size()>0) {
		
			for(int i=0;i<4;i++) {
				if(coldefObj.get(i).getHeaderLevel1().equals("Primary")) {
					Map<String,Object> cMap=new HashMap<String,Object>();
					if(i==0) {
						cMap.put("id", "");
						cMap.put("parent", '0');
						cMap.put("name", coldefObj.get(i).getHeaderLevel1().toString());
						finalList.add(cMap);
					}else if(i==1) {
						cMap.put("id", i);
						cMap.put("parent", '0');
						cMap.put("name", coldefObj.get(i).getHeaderLevel2());
						finalList.add(cMap);
					}else {
						cMap.put("id", i);
						cMap.put("parent", '1');
						cMap.put("name", coldefObj.get(i).getHeaderLevel3().toString());
						cMap.put("value", 1202);
						finalList.add(cMap);
					}
					
				}	
			}
		}
		return finalList;
	}

}
