package com.moe.universal.report.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moe.universal.report.repository.ReportListRepository;
import com.moe.universal.report.service.MasterService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/master")
public class MasterController {

	@Autowired
	MasterService masterService;
	
	
	
	@RequestMapping(value = "/getStateYearWise", method = RequestMethod.POST)
		public ResponseEntity<?>  getStateYearWise(@RequestBody String data) {
		return ResponseEntity.ok(masterService.getStateYearWise(data));
	  }
	
	@RequestMapping(value = "/getDistrictYearWise", method = RequestMethod.POST)
	public ResponseEntity<?>  getDistrictYearWise(@RequestBody String data) {
	return ResponseEntity.ok(masterService.getDistrictYearWise(data));
  }
	
	@RequestMapping(value = "/getBlockYearWise", method = RequestMethod.POST)
	public ResponseEntity<?>  getBlockYearWise(@RequestBody String data) {
	return ResponseEntity.ok(masterService.getBlockYearWise(data));
	}
	
	@GetMapping(value = "/yearListReportWise/{reportId}")
	public ResponseEntity<?>  getYearListReportWise(@PathVariable("reportId") Integer data) {
	return ResponseEntity.ok(masterService.fetchYearListOfReport(data));
  }
	
	
	
	
	
}
