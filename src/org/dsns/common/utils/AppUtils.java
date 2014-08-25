package org.dsns.common.utils;

import javax.servlet.http.HttpServletRequest;

public class AppUtils {
	public static String getAppUrl(HttpServletRequest req) {
		int port = req.getServerPort();
		return "http://" + req.getServerName() + (port == 80 ? "" : ":" + String.valueOf(port)) + req.getContextPath();
	}
}
