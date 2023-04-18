package com.moe.universal.report.handler;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
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
	
	@Value("${jsonFileLocation}")
	private String jsonFilePath;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@PostMapping(value = "/getSunBurstData")
	public ResponseEntity<?> fetchSunBurstData(@RequestBody String data) throws IOException{
		System.out.println("dsklfldfkgfghmlk");
		Resource resource = resourceLoader.getResource("TestjsonSmallData.json");
		File file = resource.getFile();
		QueryResult result = sunBurstReportService.getSunBurstDataService(data ,jsonFilePath,file);
		return ResponseEntity.ok(result);
		
	}

}
