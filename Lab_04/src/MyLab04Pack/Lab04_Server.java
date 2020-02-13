
package MyLab04Pack;

import java.net.*;
import java.io.*;

public class Lab04_Server{
	
	private Socket socket = null;
	private ServerSocket serversocket = null;
	private ObjectInputStream objectinputstream = null;
	//private ObjectOutputStream objectoutputstream = null;
	
	public Lab04_Server(int port) throws IOException, ClassNotFoundException, NullPointerException{
		serversocket = new ServerSocket(port);
		System.out.println("Server Started, Waiting for client");
		socket = serversocket.accept();
		System.out.println("Client Accepted");
		objectinputstream = new ObjectInputStream(socket.getInputStream());
		Lab04_Object objectatserver = (Lab04_Object) objectinputstream.readObject();
		System.out.println("An object received from client");
		SeeObject(objectatserver);
		serversocket.close();
		socket.close();
		objectinputstream.close();
	}
	
	private void SeeObject(Lab04_Object obj) {
		int nn = obj.getnum();
		String ss = obj.getstring();
		int ppid = obj.getpid();
		int paritygot = obj.getparity();
		
		int parityhere = 0;
		
		int n1  = nn;
		parityhere += parityof(n1);
		int len = ss.length();
		for(int i = 0; i < len; i++) {
			char ch = ss.charAt(i);
			n1 = (int) ch;
			parityhere += parityof(n1);
		}
		parityhere += parityof(ppid);
		
		//parityhere = 999;
		
		if(parityhere == paritygot) {
			System.out.println("Object checked and it is correct.\n");
		}
		else {
			System.out.println("Object checked and suspecting some problem.\n");
		}
		
		//System.out.println("This is server.\nClient sent the object: " + nn +  " " + ss);
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

	
	public static void main (String[] args) throws IOException, ClassNotFoundException, NullPointerException{
		Lab04_Server server = new Lab04_Server(5000);
	}

}
