package com.moe.universal.report.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.moe.universal.report.handler.MasterHandler;
import com.moe.universal.report.handler.StaticReportHandler;

@Configuration
public class MasterRouterConfig {
	@Autowired
	MasterHandler masterHandler;
	
    @Bean
    @Order(1)
    public RouterFunction<ServerResponse> MasterRouterConfig(){
//  	  return RouterFunctions.route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)),staticReportHandler::getAllProducts);
  	  
    	return RouterFunctions.route()
        .path("/master", b1 -> b1
            .nest(accept(MediaType.APPLICATION_JSON), b2 -> b2

                .GET("/getListOfReport", masterHandler::getListOfReport)
                .GET("/getReportWiseYear",masterHandler::getReportWiseYear)
            		)).build();

//                .GET(handler::listPeople))

//            .POST(handler::createPerson))

        

      }
}
