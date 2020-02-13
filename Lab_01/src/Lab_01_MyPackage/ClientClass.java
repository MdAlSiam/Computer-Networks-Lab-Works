package Lab_01_MyPackage;

import java.net.*;
import java.io.*;

public class ClientClass {
	
	private Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream output = null;
	
	public ClientClass(String address, int port) {
		
		try {	
		
			socket = new Socket(address, port);
			System.out.println("Connected to " + address + " via port " + port);
			
			input = new DataInputStream(System.in);
			output = new DataOutputStream(socket.getOutputStream());
			
		}catch(UnknownHostException u){System.out.println(u);}
		catch(IOException i) {System.out.println(i);}
			
		String str = "";
			
		int n = 4;
			
		while(n > 0) {
			try {
				str = input.readLine();
				output.writeUTF(str);
			}catch(IOException i) {System.out.println(i);}
			n--;
		}
		
		try {
			input.close();
			output.close();
			socket.close();
		}catch(IOException i) {System.out.println(i);}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientClass client = new ClientClass("127.0.0.1", 6225);
	}

}
