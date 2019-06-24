package com.springboot.hibernate.enums;

import org.springframework.data.domain.Sort.Direction;

public class SortUtil {
	
	private final static String ASC = "ASC";
	private final static String DESC = "DESC";
	
	public static Direction getDirection(String sortDirection) {
		if(DESC.equalsIgnoreCase(sortDirection)) {
			return Direction.DESC;
		} else {
			return Direction.ASC;
		}
	}
	
}
