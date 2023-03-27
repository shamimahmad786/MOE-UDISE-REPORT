package com.moe.universal.report.handler;

import java.util.Map;

import org.json.simple.JSONObject;
//import org.json.JSONObject;
//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.moe.universal.report.pojo.InputDependency;
import com.moe.universal.report.service.TabularReportService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class StaticReportHandler {
	
	@Autowired
	TabularReportService    tabularReportService; 
	
	  public Mono<ServerResponse> getTabularData(ServerRequest serverRequest) {
		  System.out.println("data--->"+serverRequest);
		  String uri = serverRequest.uri().toString();
		    String method = serverRequest.methodName();
		    
		    System.out.println(method);
		    try {
		    	
		    	
		    	  Mono<String> responseBody = serverRequest.bodyToMono(String.class);
		          responseBody.map(s -> s + " -- added on the server side.");
		    	System.out.println("Start");
//		    	System.out.println( serverRequest.bodyToMono(String.class).share().block());
//		    	String obj=  serverRequest.bodyToMono(String.class).toFuture().get();s
		    	System.out.println("End");
//		    	System.out.println(obj.getMapId());
		    }catch(Exception ex) {
		    	ex.printStackTrace();
		    }
//		    String contentType = serverRequest.headers().contentType().get().toString();
//		    String characterSet = serverRequest.headers().acceptCharset().get(0).toString();
//		    Mono<JSONObject> bodyData = serverRequest.bodyToMono(JSONObject.class);
//		    Mono<String> bodyData = serverRequest.bodyToMono(String.class);
		    Mono<String> bodyData =  serverRequest.bodyToMono(String.class).doOnNext((String rqody)->{
		    	System.out.println("request body-->");
		    	System.out.println(rqody);
		    });
		    
		    
		    Mono<MultiValueMap<String, String>> formData = serverRequest.formData();
		    
		    System.out.println(formData);
//		    serverRequest.body();
		    
		    System.out.println(bodyData);
		    
		    Flux<InputDependency> flux = serverRequest
		            .bodyToFlux(InputDependency.class);
		    System.out.println(flux);
		    
//		    System.out.println(serverRequest.bodyToMono(InputDependency.class));
		    
//		    String bodyData = serverRequest.bodyToMono(String.class).block();
//		    JSONObject bodyData1 = serverRequest.bodyToMono(JSONObject.class).toProcessor().peek();
		    
//		    System.out.println("bodyData----->"+bodyData1);
		    
		    
		  return ServerResponse.ok()
	                .contentType(MediaType.APPLICATION_JSON)
	                .syncBody(tabularReportService.getTabularJson(""));
	  }
}
