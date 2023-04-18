package com.moe.universal.report.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.moe.universal.report.service.MasterService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/master")
public class MasterController {

	@Autowired
	MasterService masterService;
	
	
	
	@PostMapping("/getStateYearWise")
		public ResponseEntity<?>  getStateYearWise(@RequestBody String data) {
		return ResponseEntity.ok(masterService.getStateYearWise(data));
	  }
	
	@PostMapping("/getDistrictYearWise")
	public ResponseEntity<?>  getDistrictYearWise(@RequestBody String data) {
	return ResponseEntity.ok(masterService.getDistrictYearWise(data));
  }
	
	@PostMapping("/getBlockYearWise")
	public ResponseEntity<?>  getBlockYearWise(@RequestBody String data) {
	return ResponseEntity.ok(masterService.getBlockYearWise(data));
	}
	
	@GetMapping(value = "/yearListReportWise/{reportId}")
	public ResponseEntity<?>  getYearListReportWise(@PathVariable("reportId") Integer data) {
	return ResponseEntity.ok(masterService.fetchYearListOfReport(data));
  }
	
	
	
	
	
}
