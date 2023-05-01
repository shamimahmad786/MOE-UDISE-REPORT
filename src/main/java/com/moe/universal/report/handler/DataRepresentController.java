package com.moe.universal.report.handler;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moe.universal.report.pojo.RequestChartDataBean;
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
	ObjectMapper mapperObj;

	@Autowired
	ResourceLoader resourceLoader;

	@PostMapping(value = "/getSunBurstData")
	public ResponseEntity<?> fetchSunBurstData(@RequestBody String data) throws IOException {
		Resource resource = null;
	     RequestChartDataBean reqBean = new RequestChartDataBean();
	     
	     ObjectMapper mapper = new ObjectMapper();
		reqBean = mapper.readValue(data, RequestChartDataBean.class);
		
		String reportId = String.valueOf(reqBean.getReportId());
		switch (reportId) {
		case "1001":
			resource = resourceLoader.getResource("SocialCatWiseEnroll.json");
			break;
		case "1002":
			resource = resourceLoader.getResource("TestjsonSmallData.json");
			break;
		default:
			break;
		}

		File file = resource.getFile();
		QueryResult result = sunBurstReportService.getSunBurstDataService(reqBean, jsonFilePath, file);
		return ResponseEntity.ok(result);

	}

}
