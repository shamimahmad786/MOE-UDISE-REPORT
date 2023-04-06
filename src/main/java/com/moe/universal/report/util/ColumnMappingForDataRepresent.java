package com.moe.universal.report.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import com.moe.universal.report.modal.ColumnDefination;
import com.moe.universal.report.pojo.NodeMapping;
import com.moe.universal.report.repository.ColumnDefinationRepository;

import lombok.Value;

public class ColumnMappingForDataRepresent {
	
	AtomicInteger atomicInteger = new AtomicInteger();
	
	
	public  Map<NodeMapping,NodeMapping> getColumnMappingSunBurst(ColumnDefinationRepository columnDefinationRepository,Integer tableId) {
		List<ColumnDefination> coldefObj = columnDefinationRepository.findAllByTableId(tableId);
		List<Map<String,Object>> finalList=new ArrayList<Map<String,Object>>();
		Map<NodeMapping,NodeMapping> mapList = new HashMap<>();
		if(coldefObj.size()>0) {
		
			for(int i=0;i<2;i++) {
				
				NodeMapping nodeLavel1 = new NodeMapping(atomicInteger.get(), coldefObj.get(i).getHeaderLevel1().toString());
				if(!mapList.containsKey(nodeLavel1)) {
					mapList.put(nodeLavel1, nodeLavel1);
					Integer val = atomicInteger.incrementAndGet();
					NodeMapping nodeLavel2 = new NodeMapping(val, coldefObj.get(i).getHeaderLevel2());
					nodeLavel2.setParent(nodeLavel1.getId());
					if(!mapList.containsKey(nodeLavel2)) {
						mapList.put(nodeLavel2, nodeLavel2);
						NodeMapping nodeLavel3 = new NodeMapping(atomicInteger.incrementAndGet(), coldefObj.get(i).getHeaderLevel3());
						nodeLavel3.setParent(nodeLavel2.getId());
						mapList.put(nodeLavel3,nodeLavel3);
					}
				}else {
				
					System.out.println(atomicInteger.get());
					NodeMapping nodeLavel2 = new NodeMapping(atomicInteger.incrementAndGet(), coldefObj.get(i).getHeaderLevel2());
//					List<NodeMapping> list = new ArrayList<NodeMapping>(nodeLavel3);
					nodeLavel2.setParent(mapList.get(0).getId());
					if(!mapList.containsKey(nodeLavel2)) {
//						List<NodeMapping> list1 = new ArrayList<NodeMapping>(setList);
						NodeMapping nodeLavel3 = new NodeMapping(atomicInteger.get(), coldefObj.get(i).getHeaderLevel3());
						nodeLavel3.setParent(mapList.get(i).getId());
						//nodeLavel3.setParent(nodeLavel1.getId());
						mapList.put(nodeLavel3,nodeLavel3);
					}else {
					
//						List<NodeMapping> list1 = new ArrayList<NodeMapping>(setList);
						NodeMapping nodeLavel3 = new NodeMapping(atomicInteger.get(), coldefObj.get(i).getHeaderLevel3());
						nodeLavel3.setParent(mapList.get(i).getId());
						mapList.put(nodeLavel3,nodeLavel3);
					}
				}
			}
		}
		return mapList;
	}

}
