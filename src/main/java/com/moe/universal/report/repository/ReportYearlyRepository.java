package com.moe.universal.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moe.universal.report.modal.ReportYearly;

public interface ReportYearlyRepository extends JpaRepository<ReportYearly, Long>{
//	findAllByTableId
	 List<ReportYearly> findReportYearByReportId(Integer reportId);

}
