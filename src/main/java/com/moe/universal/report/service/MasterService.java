package com.moe.universal.report.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moe.universal.report.modal.ReportList;
import com.moe.universal.report.modal.ReportYearly;
import com.moe.universal.report.modal.YearListOfReport;
import com.moe.universal.report.repository.ReportListRepository;
import com.moe.universal.report.repository.ReportYearlyRepository;
import com.moe.universal.report.repository.YearListRepository;
import com.moe.universal.report.util.NativeRepository;
import com.moe.universal.report.util.QueryResult;

@Service
public class MasterService {

	@Autowired
	NativeRepository nativeRepository;
	
	@Autowired
	ObjectMapper mapperObj;
	@Autowired
	YearListRepository yearListRepository;
	
	public QueryResult  getStateYearWise(@RequestBody String data) {
		QueryResult result =new QueryResult();
		HashMap<String, Object> statemaster=null;
		try {
			statemaster	 = mapperObj.readValue(data, new TypeReference<HashMap<String, Object>>() {
			});
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		try {
			result=nativeRepository.executeQueries("select * from udisereportnew.master_state where year_id="+statemaster.get("yearId"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	return result;
  }


public QueryResult  getDistrictYearWise(@RequestBody String data) {
	
	HashMap<String, Object> districtrequest =getRequestObject(data);
	QueryResult result =new QueryResult();
	try {
		result=nativeRepository.executeQueries("select * from udisereportnew.master_district where year_id="+districtrequest.get("yearId") +" and state_id="+districtrequest.get("stateId"));
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	
	return result;
}


public QueryResult  getBlockYearWise(@RequestBody String data) {
	HashMap<String, Object> blockrequest =getRequestObject(data);
	QueryResult result =new QueryResult();
	try {
		result=nativeRepository.executeQueries("select * from udisereportnew.master_block where year_id="+blockrequest.get("yearId") +" and state_id="+blockrequest.get("stateId")+" and district_id="+blockrequest.get("districtId"));
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	return result;
}

public QueryResult  getYearListService(Integer reportId) {
	
	QueryResult result =new QueryResult();
	try {
		result=nativeRepository.executeQueries("select * from udisereportnew.master_block where year_id="+reportId);
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	return result;
}

public HashMap<String, Object> getRequestObject(String data){
	HashMap<String, Object> requestObj=null;
	try {
		requestObj	 = mapperObj.readValue(data, new TypeReference<HashMap<String, Object>>() {
		});
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	
	return requestObj;
}

public List<YearListOfReport> fetchYearListOfReport(Integer reportId){
	List<YearListOfReport> list = new ArrayList<>();
	 list = yearListRepository.findAllByReportId(reportId);
	return list;
}

	
}
