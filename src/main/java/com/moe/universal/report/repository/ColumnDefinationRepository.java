package com.moe.universal.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moe.universal.report.modal.ColumnDefination;
import com.moe.universal.report.modal.ReportList;

public interface ColumnDefinationRepository extends JpaRepository<ColumnDefination, Long>{
  List<ColumnDefination> findAllByTableId(Integer tableId);
}
