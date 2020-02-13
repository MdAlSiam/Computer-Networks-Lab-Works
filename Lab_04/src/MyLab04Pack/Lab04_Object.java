package MyLab04Pack;

import java.io.*;

public class Lab04_Object implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int num = 0;
	private String str = "init";
	private int parity = 0;
	private int proid = 0;
	
	
	public Lab04_Object(int n, String st, int pid) {
		this.num = n;
		this.str = st;
		this.proid = pid;
		
		calc_parity();
	}
	
	private void calc_parity(){
		int n1  = num;
		parity += parityof(n1);
		int len = str.length();
		for(int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			n1 = (int) ch;
			parity += parityof(n1);
		}
		parity += parityof(proid);
	}

	public int getnum() {
		return num;
	}
	
	public String getstring() {
		return str;
	}
	
	public int getpid() {
		return proid;
	}
	
	public int getparity() {
		return parity;
	}
	
	public int parityof(int nn) {
		int nnn = nn;
		int ret = 0;
		for(int i = 0; i < 32; i++) {
			if(nnn % 2 == 1) ret++;
			nnn = nnn << 1;
		}
		return ret;
	}

}

