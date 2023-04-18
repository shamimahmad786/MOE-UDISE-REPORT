package com.moe.universal.report.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.moe.universal.report.repository.ReportListRepository;
import com.moe.universal.report.repository.ReportYearlyRepository;

import reactor.core.publisher.Mono;

@Component
public class MasterHandler {
	
	@Autowired
	ReportListRepository reportListRepository;
	
	@Autowired
	ReportYearlyRepository reportYearlyRepository;
	
	
	
	  public Mono<ServerResponse> getListOfReport(ServerRequest serverRequest) {
		  return ServerResponse.ok()
	                .contentType(MediaType.APPLICATION_JSON)
	                .bodyValue(reportListRepository.findAll());
	  }
	  
	  public Mono<ServerResponse> getReportWiseYear(ServerRequest serverRequest) {
		  return ServerResponse.ok()
	                .contentType(MediaType.APPLICATION_JSON)
	                .bodyValue(reportYearlyRepository.findAll());
	  }
	  
	  
}
