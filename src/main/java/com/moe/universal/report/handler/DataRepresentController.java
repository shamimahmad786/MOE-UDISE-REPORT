package com.moe.universal.report.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moe.universal.report.service.SunBurstReportService;
import com.moe.universal.report.util.QueryResult;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class DataRepresentController {
	
	@Autowired
	SunBurstReportService sunBurstReportService;
	
	@PostMapping(value = "/getSunBurstData")
	public ResponseEntity<?> fetchSunBurstData(@RequestBody String data){
		System.out.println("dsklfldfkgfghmlk");
		QueryResult result = sunBurstReportService.getSunBurstDataService(data);
		return ResponseEntity.ok(result);
		
	}

}
