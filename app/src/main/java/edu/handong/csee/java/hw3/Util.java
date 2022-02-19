package edu.handong.csee.java.hw3;

public class Util {

	public static String[] getSplit(String data, String sep) {
		
		return data.split(sep);
	}
	
	public static String SBToString(StringBuilder str) {
		
		return str.toString();
	}
	
	public static StringBuilder reset(StringBuilder sb) {
		
		return sb.delete(0, sb.length());
	}
}
