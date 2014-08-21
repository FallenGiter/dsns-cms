package org.dsns.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss", yyyyMMdd = "yyyyMMdd";
	public static DateFormat DF_yyyyMMdd = new SimpleDateFormat(yyyyMMdd);
	public static DateFormat DF_yyyy_MM_dd_HH_mm_ss = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss);
	
	public static String getCurDay_yyyyMMdd() {
		return DF_yyyyMMdd.format(new Date());
	}
	
	public static Date now() {
		return new Date();
	}
}
