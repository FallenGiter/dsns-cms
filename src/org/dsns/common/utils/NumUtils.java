package org.dsns.common.utils;

import java.text.DecimalFormat;


public class NumUtils {
	public static final DecimalFormat DF_00_DOT_00 = new DecimalFormat("#00.00"); 
	
	public static boolean isNum(String str) {
		try {
			Long.parseLong(str);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}
