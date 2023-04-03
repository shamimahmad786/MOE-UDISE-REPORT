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
	
	
}
