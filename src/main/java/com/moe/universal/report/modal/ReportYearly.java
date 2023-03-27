package com.moe.universal.report.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Data
@Entity
@Table(name="moe_report_reportyear")
public class ReportYearly {
	
	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="report_id")
	private Integer reportId;
	@Column(name="year_id")
	private String yearId;
	@Column(name="year_value")
	private String yearValue;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getReportId() {
		return reportId;
	}
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	public String getYearId() {
		return yearId;
	}
	public void setYearId(String yearId) {
		this.yearId = yearId;
	}
	public String getYearValue() {
		return yearValue;
	}
	public void setYearValue(String yearValue) {
		this.yearValue = yearValue;
	}
	
		
}
