package Lab_01_MyPackage;

import java.net.*;
import java.io.*;

public class ServerClass {
	
	private Socket socket = null;
	private ServerSocket serversocket = null;
	private DataInputStream input = null;
	
	public ServerClass(int port) {
		
		try {
		
			serversocket = new ServerSocket(port);
			System.out.println("Server Started, Waiting for client");
			socket = serversocket.accept();
			System.out.println("Client Accepted");
			input = new  DataInputStream(new BufferedInputStream(socket.getInputStream()));
			
		} catch(IOException i) {System.out.println(i);}
		
		
		String str = "";
		
		int n = 4;
		
		while(n > 0) {
			try {
				str = input.readUTF();
				System.out.println(str);
			}catch(IOException i) {System.out.println(i);}
			n--;
		}
		
		try {
			socket.close();
			serversocket.close();
			input.close();
		}catch(IOException i) {System.out.println(i); }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerClass server = new ServerClass(6225);
	}

}
