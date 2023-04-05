package com.moe.universal.report.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.moe.universal.report.modal.ColumnDefination;
import com.moe.universal.report.pojo.NodeMapping;
import com.moe.universal.report.repository.ColumnDefinationRepository;

public class ColumnMappingForDataRepresent {
	
	public static Set<NodeMapping> getColumnMappingSunBurst(ColumnDefinationRepository columnDefinationRepository,Integer tableId) {
		List<ColumnDefination> coldefObj = columnDefinationRepository.findAllByTableId(tableId);
		List<Map<String,Object>> finalList=new ArrayList<Map<String,Object>>();
		Set<NodeMapping> setList = new HashSet<>();
		if(coldefObj.size()>0) {
		
			for(int i=0;i<5;i++) {
				
				NodeMapping nodeLavel1 = new NodeMapping(i, coldefObj.get(i).getHeaderLevel1());
				if(setList.add(nodeLavel1)) {
					NodeMapping nodeLavel2 = new NodeMapping(1, coldefObj.get(i).getHeaderLevel2());
					nodeLavel2.setParent(nodeLavel1.getId());
					if(setList.add(nodeLavel2)) {
						NodeMapping nodeLavel3 = new NodeMapping(i, coldefObj.get(i).getHeaderLevel3());
						nodeLavel3.setParent(nodeLavel2.getId());
						setList.add(nodeLavel3);
					}
				}else {
					NodeMapping nodeLavel2 = new NodeMapping(1, coldefObj.get(i).getHeaderLevel2());
					List<NodeMapping> list = new ArrayList<NodeMapping>(setList);
					nodeLavel2.setParent(list.get(i-1).getId());
					if(setList.add(nodeLavel2)) {
						NodeMapping nodeLavel3 = new NodeMapping(i, coldefObj.get(i).getHeaderLevel3());
						nodeLavel3.setParent(nodeLavel1.getId());
						setList.add(nodeLavel3);
					}else {
						NodeMapping nodeLavel3 = new NodeMapping(i, coldefObj.get(i).getHeaderLevel3());
						nodeLavel3.setParent(nodeLavel2.getId());
						setList.add(nodeLavel3);
					}
				}
				
//				if(coldefObj.get(i).getHeaderLevel1().equals("Primary")) {
//					Map<String,Object> cMap=new HashMap<String,Object>();
//					if(i==0) {
//						cMap.put("id", "");
//						cMap.put("parent", '0');
//						cMap.put("name", coldefObj.get(i).getHeaderLevel1().toString());
//						finalList.add(cMap);
//					}else if(i==1) {
//						cMap.put("id", i);
//						cMap.put("parent", '0');
//						cMap.put("name", coldefObj.get(i).getHeaderLevel2());
//						finalList.add(cMap);
//					}else {
//						cMap.put("id", i);
//						cMap.put("parent", '1');
//						cMap.put("name", coldefObj.get(i).getHeaderLevel3().toString());
//						cMap.put("value", 1202);
//						finalList.add(cMap);
//					}
//					
//				}	
			}
		}
		return setList;
	}

}
