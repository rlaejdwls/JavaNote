package com.example.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class Util {
	public static final String strJavaPackagePath = "kr.ac.bcu.java";
	public static final String strLibPackagePath = "kr.ac.bcu.lib";
	
	public String getStrDate() {
		Calendar cal = Calendar.getInstance();
		String strYear = Integer.toString(cal.get(Calendar.YEAR));
		String strMonth = Integer.toString(cal.get(Calendar.MONTH) + 1);
		String strDay = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
		String strHour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
		String strMinute = Integer.toString(cal.get(Calendar.MINUTE));
		String strSecond = Integer.toString(cal.get(Calendar.SECOND));
		
		if (strMonth.length() == 1) {
			strMonth = "0" + strMonth;
		}
		if (strDay.length() == 1) {
			strDay = "0" + strDay;
		}
		if (strHour.length() == 1) {
			strHour = "0" + strHour;
		}
		if (strMinute.length() == 1) {
			strMinute = "0" + strMinute;
		}
		if (strSecond.length() == 1) {
			strSecond = "0" + strSecond;
		}
		
		return strYear + strMonth + strDay + 
				strHour + strMinute + strSecond;
	}
	
	public static void mkdirs(String path) {
		File f = new File(path);
		if (f.isDirectory()) {
			return;
		} else {
			f.mkdirs();
		}
	}
	
	public static String removeCharAll(String str, String... regex) {
		for (int i = 0; i < regex.length; i++) {
			str = str.replaceAll(regex[i], "");
		}
		return str;
	}
	
	ArrayList<String> fileList = new ArrayList<String>();
	
	public ArrayList<String> getFileList(String path, String ext) {
		try {
			File f = new File(path);
			for (File file : f.listFiles()) {
				if (file.isFile()) {
					if (ext.equals("*")) {
						fileList.add(file.getCanonicalPath().replaceAll("\\\\", "/"));
					} else if (file.getName().substring(file.getName().length() - ext.length()).equals(ext)) {
						fileList.add(file.getCanonicalPath().replaceAll("\\\\", "/"));
					}
				} else {
					getFileList(file.getCanonicalPath(), ext);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return fileList;
	}
	
	public static String getAbsolutePath() {
		Util util = new Util();
		return util.getClass().getClassLoader().getResource("").getPath().substring(1);
	}
	
	public static String getDevelopPath() {
		File f = new File("./src/");
		try {
			return f.getCanonicalPath().replaceAll("\\\\", "/") + "/";
		} catch (IOException e) {
			return f.getPath();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Util.removeCharAll("./../../abc", "../", "./"));
//		Util u = new Util();
//		ArrayList<String> fileList = u.getFileList(Ref.getAbsolutePath() + "kr/ac/bcu", "txt");
//		for (String path : fileList) {
//			System.out.println(path);
//		}
	}
}
