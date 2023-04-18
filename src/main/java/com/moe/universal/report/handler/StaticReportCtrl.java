package com.moe.universal.report.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moe.universal.report.service.TabularReportService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class StaticReportCtrl {
	@Autowired
	TabularReportService tabularReportService;

	@PostMapping(value = "/getTabularData")
	public ResponseEntity<?> getTabularData(@RequestBody String data) {
		
		return ResponseEntity.ok(tabularReportService.getTabularJson(data));
	}
}
