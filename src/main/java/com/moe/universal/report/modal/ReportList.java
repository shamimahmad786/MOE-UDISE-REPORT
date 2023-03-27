package com.moe.universal.report.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="moe_report_reportlist")
public class ReportList {

	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="report_name")
	private String reportName;
	@Column(name="report_description")
	private String reportDescroption;
	@Column(name="report_tag")
	private String reportTag;
	@Column(name="report_domain")
	private String reportDomain;
	@Column(name="report_type")
	private Integer reportType;
	
}
