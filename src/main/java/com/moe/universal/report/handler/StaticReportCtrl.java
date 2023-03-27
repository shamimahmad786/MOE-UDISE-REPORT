package com.moe.universal.report.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.moe.universal.report.pojo.InputDependency;
import com.moe.universal.report.service.TabularReportService;
import com.moe.universal.report.util.QueryResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class StaticReportCtrl {
	@Autowired
	TabularReportService    tabularReportService; 
	
	@RequestMapping(value = "/getTabularData", method = RequestMethod.POST)
//	  public QueryResult getTabularData(@RequestBody String data) {
		public ResponseEntity<?>  getTabularData(@RequestBody String data) {
		
//		System.out.println("Tabular data--->"+tabularReportService.getTabularJson(data));
		
		return ResponseEntity.ok(tabularReportService.getTabularJson(data));
		
//		  return ServerResponse.ok()
////	                .contentType(MediaType.APPLICATION_JSON)
//	                .syncBody(tabularReportService.getTabularJson(data));
	  }
}
