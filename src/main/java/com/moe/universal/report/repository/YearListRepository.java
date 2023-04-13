package com.moe.universal.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moe.universal.report.modal.YearListOfReport;

@Repository
public interface YearListRepository extends JpaRepository<YearListOfReport, Integer> {
	List<YearListOfReport> findAllByReportId(Integer reportId);
}
