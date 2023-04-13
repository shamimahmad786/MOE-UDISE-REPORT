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
@Table(name="report_ms_yearmapping",schema="udisereportnew")
public class YearListOfReport {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="report_id")
	private Integer reportId;
	
	@Column(name="map_id")
	private Integer mapId;
	
	@Column(name="report_year")
	private String reportYear;
	
	@Column(name="year_id")
	private Integer yearId;
	

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

	public Integer getMapId() {
		return mapId;
	}

	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}

	public String getReportYear() {
		return reportYear;
	}

	public void setReport_year(String reportYear) {
		this.reportYear = reportYear;
	}

	public Integer getYearId() {
		return yearId;
	}

	public void setYearId(Integer yearId) {
		this.yearId = yearId;
	}
	
	

}
