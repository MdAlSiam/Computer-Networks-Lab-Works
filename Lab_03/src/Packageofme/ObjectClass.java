package Packageofme;

import java.io.*;

public class ObjectClass implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int num;
	private String str;
	
	public ObjectClass(int n, String st) {
		this.num = n;
		this.str = st;
	}
	
	public int getnum() {
		return num;
	}
	
	public String getstring() {
		return str;
	}
}
