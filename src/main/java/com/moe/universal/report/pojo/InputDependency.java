package com.moe.universal.report.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InputDependency {

private Integer mapId;
private Integer reportTypeValue;
private String paramType;
private String paramValue;
private String reportYear;
private Integer isManagementDependent;
private Integer managementType;
	
}
