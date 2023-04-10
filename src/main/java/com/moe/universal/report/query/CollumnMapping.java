package com.moe.universal.report.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moe.universal.report.modal.ColumnDefination;
import com.moe.universal.report.repository.ColumnDefinationRepository;

public class CollumnMapping {

	public static List<HashMap<String, Object>> getColumnDescription(List<Object> stringList) {

		List<HashMap<String, Object>> mapList = new ArrayList<HashMap<String, Object>>();
		stringList.forEach((e) -> {
			getColumnDefination(mapList, String.valueOf(e));
		});
		return mapList;
	}

	public static List<Map<String, Object>> getColumn(ColumnDefinationRepository columnDefinationRepository,
			Integer tableId) {

		System.out.println("TableId--->" + tableId);

		List<ColumnDefination> coldefObj = columnDefinationRepository.findAllByTableId(tableId);

		System.out.println("size of column defination--->" + coldefObj.size());

		List<Map<String, Object>> finalList = new ArrayList<Map<String, Object>>();
		if (coldefObj.get(0).getNoOfHeaderLevel() == 1) {
		for (int i = 0; i < coldefObj.size(); i++) {
				Map<String, Object> cMap = new HashMap<String, Object>();
				cMap.put("field", coldefObj.get(i).getColumnId());
				cMap.put("headerName", coldefObj.get(i).getHeaderLevel3());
				finalList.add(cMap);
			}
		}
		if (coldefObj.get(0).getNoOfHeaderLevel() == 3) {
			for (int i = 0; i < coldefObj.size(); i++) {
				Integer headerLevel3MatchCondition = 0;
				if (finalList.size() == 0) {
					HashMap<String, Object> hs = new HashMap<String, Object>();
					List<HashMap<String, Object>> lt = new ArrayList<HashMap<String, Object>>();
					List<HashMap<String, Object>> lt2 = new ArrayList<HashMap<String, Object>>();
					Map<String, Object> cMap = new HashMap<String, Object>();
					Map<String, Object> cMap2 = new HashMap<String, Object>();
					cMap2.put("field", coldefObj.get(i).getColumnId());
					cMap2.put("headerName", coldefObj.get(i).getHeaderLevel3());
//						cMap.put("fieldName", coldefObj.get(i).getColumnId());
					cMap.put("headerName", coldefObj.get(i).getHeaderLevel2());
					lt2.add((HashMap<String, Object>) cMap2);
					cMap.put("children", lt2);

					hs.put("headerName", coldefObj.get(i).getHeaderLevel1());

					lt.add((HashMap<String, Object>) cMap);
					hs.put("children", lt);

					finalList.add(hs);
				} else {

					System.out.println(finalList.size());
					for (int j = 0; j < finalList.size(); j++) {

//					System.out.println(coldefObj.get(i).getHeaderLevel1()+"------------"+String.valueOf(finalList.get(j).get("headerName")));

						if (coldefObj.get(i).getHeaderLevel1()
								.equalsIgnoreCase(String.valueOf(finalList.get(j).get("headerName")))) {
							headerLevel3MatchCondition = 1;
							HashMap<String, Object> parentToInsert = (HashMap<String, Object>) finalList.get(j);

							System.out.println(finalList.get(j));

							List<HashMap<String, Object>> childListMap = (List<HashMap<String, Object>>) finalList
									.get(j).get("children");
							Integer headerLevel2MatchCondition = 0;
							for (int k = 0; k < childListMap.size(); k++) {
								if (String.valueOf(childListMap.get(k).get("headerName"))
										.equalsIgnoreCase(coldefObj.get(i).getHeaderLevel2())) {
									headerLevel2MatchCondition = 1;
									List<HashMap<String, Object>> subParentLis = new ArrayList<HashMap<String, Object>>();
									HashMap<String, Object> subParent = childListMap.get(k);
									List<HashMap<String, Object>> subchildListMap = (List<HashMap<String, Object>>) childListMap
											.get(k).get("children");
									Map<String, Object> cMap = new HashMap<String, Object>();
									cMap.put("field", coldefObj.get(i).getColumnId());
									cMap.put("headerName", coldefObj.get(i).getHeaderLevel3());
									subchildListMap.add((HashMap<String, Object>) cMap);
									subParent.put("children", subchildListMap);
//								subParentLis.add(subParent);
									childListMap.set(k, subParent);

//								parentToInsert.put("children", subParentLis);
									parentToInsert.put("children", childListMap);

//								System.out.println("Size---->"+finalList.size()+"-------------"+parentToInsert);

									finalList.set(j, parentToInsert);
								}
							}
//						
							if (headerLevel2MatchCondition == 0) {
								HashMap<String, Object> hs = new HashMap<String, Object>();
								HashMap<String, Object> firstLevelObj = (HashMap<String, Object>) finalList.get(j);
								List<HashMap<String, Object>> secondList = new ArrayList<HashMap<String, Object>>();
								List<HashMap<String, Object>> lt = new ArrayList<HashMap<String, Object>>();
								List<HashMap<String, Object>> lt2 = new ArrayList<HashMap<String, Object>>();
								Map<String, Object> cMap = new HashMap<String, Object>();
								Map<String, Object> cMap2 = new HashMap<String, Object>();
								cMap2.put("field", coldefObj.get(i).getColumnId());
								cMap2.put("headerName", coldefObj.get(i).getHeaderLevel3());
								cMap.put("field", coldefObj.get(i).getColumnId());
								cMap.put("headerName", coldefObj.get(i).getHeaderLevel2());
								lt2.add((HashMap<String, Object>) cMap2);
								cMap.put("children", lt2);
								lt.add((HashMap<String, Object>) cMap);

								childListMap.add((HashMap<String, Object>) cMap);

								parentToInsert.put("children", childListMap);

								finalList.set(j, parentToInsert);
							}

						}
					}

					if (headerLevel3MatchCondition == 0) {
						HashMap<String, Object> hs = new HashMap<String, Object>();
						List<HashMap<String, Object>> lt = new ArrayList<HashMap<String, Object>>();
						List<HashMap<String, Object>> lt2 = new ArrayList<HashMap<String, Object>>();
						Map<String, Object> cMap = new HashMap<String, Object>();
						Map<String, Object> cMap2 = new HashMap<String, Object>();
						cMap2.put("field", coldefObj.get(i).getColumnId());
						cMap2.put("headerName", coldefObj.get(i).getHeaderLevel3());
						lt2.add((HashMap<String, Object>) cMap2);
						cMap.put("headerName", coldefObj.get(i).getHeaderLevel2());
						cMap.put("children", lt2);
						hs.put("headerName", coldefObj.get(i).getHeaderLevel1());
						lt.add((HashMap<String, Object>) cMap);
						hs.put("children", lt);

						System.out.println("hs---->" + hs);

						finalList.add(hs);
					}

				}

			}
		}
		else if (coldefObj.get(0).getNoOfHeaderLevel() == 2) {
			for (int i = 0; i < coldefObj.size(); i++) {
				Integer headerLevel3MatchCondition = 0;
//				Map<String, Object> cMap = new HashMap<String, Object>();
//				cMap.put("field", "state_name");
//				cMap.put("headerName", "Location");
//				finalList.add(cMap);
				if (finalList.size() == 0) {
					HashMap<String, Object> hs = new HashMap<String, Object>();
					List<HashMap<String, Object>> lt = new ArrayList<HashMap<String, Object>>();
					Map<String, Object> cMap2 = new HashMap<String, Object>();
					cMap2.put("field", coldefObj.get(i).getColumnId());
					cMap2.put("headerName", coldefObj.get(i).getHeaderLevel3());
					cMap2.put("width", coldefObj.get(i).getDisplayWidth());
					hs.put("headerName", coldefObj.get(i).getHeaderLevel1());
					
					lt.add((HashMap<String, Object>) cMap2);
					hs.put("children", lt);
					finalList.add(hs);
					System.out.println(finalList.get(0));
				} else {

					System.out.println(finalList.size());
					for (int j = 0; j < finalList.size(); j++) {
						if (coldefObj.get(i).getHeaderLevel1().equalsIgnoreCase(String.valueOf(finalList.get(j).get("headerName")))) {
							headerLevel3MatchCondition = 1;
							HashMap<String, Object> parentToInsert = (HashMap<String, Object>) finalList.get(j);

							System.out.println(finalList.get(j));

							List<HashMap<String, Object>> childListMap = (List<HashMap<String, Object>>) finalList.get(j).get("children");
							Integer headerLevel2MatchCondition = 0;
							if (headerLevel2MatchCondition == 0) {
								Map<String, Object> cMap2 = new HashMap<String, Object>();
								cMap2.put("field", coldefObj.get(i).getColumnId());
								cMap2.put("headerName", coldefObj.get(i).getHeaderLevel3());
								cMap2.put("width", coldefObj.get(i).getDisplayWidth());
								childListMap.add((HashMap<String, Object>) cMap2);
								parentToInsert.put("children", childListMap);
								finalList.set(j, parentToInsert);
							}
						}
					}

					if (headerLevel3MatchCondition == 0) {
						HashMap<String, Object> hs = new HashMap<String, Object>();
						List<HashMap<String, Object>> lt = new ArrayList<HashMap<String, Object>>();
						Map<String, Object> cMap2 = new HashMap<String, Object>();
						cMap2.put("field", coldefObj.get(i).getColumnId());
						cMap2.put("headerName", coldefObj.get(i).getHeaderLevel3());
						cMap2.put("width", coldefObj.get(i).getDisplayWidth());
						hs.put("headerName", coldefObj.get(i).getHeaderLevel1());
						lt.add((HashMap<String, Object>) cMap2);
						hs.put("children", lt);

						System.out.println("hs---->" + hs);

						finalList.add(hs);
					}

				}

			}
		}

		System.out.println("finalList--->" + finalList);

		return finalList;
	}

	public static List<HashMap<String, Object>> getColumnDefination(List<HashMap<String, Object>> mapLis,
			String columnName) {

		HashMap<String, Object> hs = new HashMap<String, Object>();

		switch (columnName) {

		case "social_category_name":
			hs.put("columnName", "Social Category");
			hs.put("filterType", "Y");
			hs.put("width", 200);
//        	hs.put("parentType", "Y");
//        	hs.put("parentName", "Pre Primary Enrolment");
			break;
		case "cpp_b":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Pre Primary Enrolment");
			break;
		case "cpp_g":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Pre Primary Enrolment");
			break;
		case "cpp_bg":
			hs.put("columnName", "Total");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Pre Primary Enrolment");
			break;

		case "c1_b":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-1");
			break;

		case "c1_g":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-1");
			break;

		case "c1_bg":
			hs.put("columnName", "Total");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-1");
			break;

		case "c2_b":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-2");
			break;

		case "c2_g":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-2");
			break;

		case "c2_bg":
			hs.put("columnName", "Total");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-2");
			break;

		case "c3_b":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-3");
			break;

		case "c3_g":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-3");
			break;

		case "c3_bg":
			hs.put("columnName", "Total");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-3");
			break;

		case "c4_b":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-4");
			break;

		case "c4_g":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-4");
			break;

		case "c4_bg":
			hs.put("columnName", "Total");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-4");
			break;

		case "c5_b":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-5");
			break;

		case "c5_g":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-5");
			break;

		case "c5_bg":
			hs.put("columnName", "Total");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-5");
			break;

		case "c6_b":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-6");
			break;

		case "c6_g":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-6");
			break;

		case "c6_bg":
			hs.put("columnName", "Total");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-6");
			break;

		case "c7_b":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-7");
			break;

		case "c7_g":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-7");
			break;

		case "c7_bg":
			hs.put("columnName", "Total");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-7");
			break;

		case "c8_b":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-8");
			break;

		case "c8_g":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-8");
			break;

		case "c8_bg":
			hs.put("columnName", "Total");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-8");
			break;

		case "c9_b":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-9");
			break;

		case "c9_g":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-9");
			break;

		case "c9_bg":
			hs.put("columnName", "Total");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-9");
			break;

		case "c10_b":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-10");
			break;

		case "c10_g":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-10");
			break;

		case "c10_bg":
			hs.put("columnName", "Total");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-10");
			break;

		case "c11_b":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-11");
			break;

		case "c11_g":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-11");
			break;

		case "c11_bg":
			hs.put("columnName", "Total");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-11");
			break;

		case "c12_b":
			hs.put("columnName", "boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-12");
			break;

		case "c12_g":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-12");
			break;

		case "c12_bg":
			hs.put("columnName", "Total");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Class-12");
			break;

		case "primary_boys_govt":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Primary");
			break;

		case "primary_girls_govt":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Primary");
			break;

		case "upper_primary_boys_govt":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Upper Primary");
			break;

		case "upper_primary_girls_govt":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Upper Primary");
			break;

		case "secondary_boys_govt":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Secondary");
			break;

		case "secondary_girls_govt":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Secondary");
			break;

		case "higher_secondary_boys_govt":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Higher Secondary");
			break;

		case "higher_secondary_girls_govt":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt higher Secondary");
			break;
		case "primary_boys_govt_aided":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Aided Primary");
			break;

		case "primary_girls_govt_aided":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Aided Primary");
			break;

		case "upper_primary_boys_govt_aided":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 130);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Aided Upper Primary");
			break;

		case "upper_primary_girls_govt_aided":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 150);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Aided Upper Primary");
			break;
		case "secondary_boys_govt_aided":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 110);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Aided Secondary");
			break;

		case "secondary_girls_govt_aided":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 110);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Aided Secondary");
			break;

		case "higher_secondary_boys_govt_aided":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 110);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Aided Higher Secondary");
			break;

		case "higher_secondary_girls_govt_aided":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 110);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Aided Higher Secondary");
			break;

		case "primary_boys_private":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Private Primary");
			break;

		case "primary_girls_private":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Private Primary");
			break;
		case "upper_primary_boys_govt_private":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 110);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Private Upper Primary Girls");
			break;

		case "upper_primary_girls_govt_private":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 110);
			hs.put("parentType", "Y");
			hs.put("parentName", "Govt Private Upper Primary Girls");
			break;
		case "secondary_boys_govt_private":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 110);
			hs.put("parentType", "Y");
			hs.put("parentName", "Private Secondary Girls");
			break;

		case "secondary_girls_govt_private":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 100);
			hs.put("parentType", "Y");
			hs.put("parentName", "Private Secondary Girls");
			break;
		case "higher_secondary_boys_private":
			hs.put("columnName", "Boys");
			hs.put("filterType", "Y");
			hs.put("width", 130);
			hs.put("parentType", "Y");
			hs.put("parentName", "Private Higher Secondary Girls");
			break;

		case "higher_secondary_girls_private":
			hs.put("columnName", "Girls");
			hs.put("filterType", "Y");
			hs.put("width", 130);
			hs.put("parentType", "Y");
			hs.put("parentName", "Private Higher Secondary Girls");
			break;
		}
		mapLis.add(hs);
		System.out.println(mapLis);
		return mapLis;
	}

}
