package org.dsns.common.utils;

import java.io.File;
import java.net.URL;

import org.springframework.util.StringUtils;

public class FileUtils {
	public static final String DOT = ".";
	
	public static void main(String[] args) {
		
	}
	
	public static boolean ensureFile(File file) throws Exception {
		if (file != null && !file.exists()) {
			ensureDir(file.getParentFile());
			return file.createNewFile();
		}
		return false;
	}
	
	public static boolean ensureDir(File file) throws Exception {
		if (file != null && !file.exists()) {
			return file.mkdirs();
		}
		return false;
	}
	
	public static String getFileSuffix(File file) throws Exception {
		if (file != null && file.isFile()) {
			String name = file.getName();
			return name.substring(name.lastIndexOf(DOT), name.length());
		}
		return null;
	}
	
	public static String getFileSuffix(String fileName) throws Exception {
		if (StringUtils.hasText(fileName)) {
			fileName = fileName.trim();
			return fileName.substring(fileName.lastIndexOf(DOT) + 1, fileName.length());
		}
		return null;
	}
	
	public static boolean isValidUrl(String url) {
		try {
			new URL(url);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String fixFilePath(String filePath) {
		if (StringUtils.hasText(filePath)) {
			String tmpFilePath = filePath.trim();
			
			char[] cArr = tmpFilePath.toCharArray();
			String str = "", separator = String.valueOf(File.separatorChar);
			char c;
			for (int i = 0; i < cArr.length; i++) {
				c = cArr[i];
				if (c == '/' || c =='\\') {
					if (!str.endsWith(separator)) {
						str += separator;
					} else {
						continue;
					}
				} else {
					str += c;
				}
			}
			return str;
		} else {
			return filePath;
		}
	}
}
