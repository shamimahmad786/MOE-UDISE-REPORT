package com.moe.universal.report.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="moe_report_columndefination",schema="udisereportnew")
public class ColumnDefination {

	@Id
	private Long id;
	
	@Column(name="table_id")
	private Integer tableId;
	
	@Column(name="column_id")
	private String  columnId;
	
	@Column(name="column_name")
	private String  columnName;
	
	@Column(name="no_of_headerLevel")
	private Integer noOfHeaderLevel;
	
	@Column(name="header_level1")
	private String  headerLevel1;
	
	@Column(name="header_level2")
	private String  headerLevel2;
	
	@Column(name="header_level3")
	private String  headerLevel3;
	
	@Column(name="display_width")
	private Integer displayWidth;
	
	
	
	
	public ColumnDefination() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ColumnDefination(Long id, Integer tableId, String columnId, String columnName, Integer noOfHeaderLevel,
			String headerLevel1, String headerLevel2, String headerLevel3) {
		super();
		this.id = id;
		this.tableId = tableId;
		this.columnId = columnId;
		this.columnName = columnName;
		this.noOfHeaderLevel = noOfHeaderLevel;
		this.headerLevel1 = headerLevel1;
		this.headerLevel2 = headerLevel2;
		this.headerLevel3 = headerLevel3;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	public String getColumnId() {
		return columnId;
	}
	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public Integer getNoOfHeaderLevel() {
		return noOfHeaderLevel;
	}
	public void setNoOfHeaderLevel(Integer noOfHeaderLevel) {
		this.noOfHeaderLevel = noOfHeaderLevel;
	}
	public String getHeaderLevel1() {
		return headerLevel1;
	}
	public void setHeaderLevel1(String headerLevel1) {
		this.headerLevel1 = headerLevel1;
	}
	public String getHeaderLevel2() {
		return headerLevel2;
	}
	public void setHeaderLevel2(String headerLevel2) {
		this.headerLevel2 = headerLevel2;
	}
	public String getHeaderLevel3() {
		return headerLevel3;
	}
	public void setHeaderLevel3(String headerLevel3) {
		this.headerLevel3 = headerLevel3;
	}
	public Integer getDisplayWidth() {
		return displayWidth;
	}
	public void setDisplayWidth(Integer displayWidth) {
		this.displayWidth = displayWidth;
	}
	
	
}
