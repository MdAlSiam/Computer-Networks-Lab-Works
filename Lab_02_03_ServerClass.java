package MyPackage_Lab_02;

import java.net.*;
import java.io.*;

public class ServerClass {
	
	private Socket socket = null;
	private ServerSocket serversocket = null;
	private DataInputStream input = null;
	private DataInputStream input_here = null;
	private DataOutputStream output = null;
	
	public ServerClass(int port) {
		
		try {
		
			serversocket = new ServerSocket(port);
			System.out.println("Server Started, Waiting for client");
			socket = serversocket.accept();
			System.out.println("Client Accepted");
			input_here = new DataInputStream(System.in);
			input = new  DataInputStream(new BufferedInputStream(socket.getInputStream()));
			output = new DataOutputStream(socket.getOutputStream());
			
		} catch(IOException i) {System.out.println(i);}
		
		
		String str = "", fin = "over", fin_ind = "";
		
		//int n = 4;
		
		while(true) {
			try {
				str = input.readUTF();
				
				if (  str.equals(fin) ) {
					System.out.println(" -- Conversation Over from Server -- ");
					break;
				}
				
				System.out.println(str);
			}catch(IOException i) {System.out.println(i);}
			try {
				str = input_here.readLine();
				
				if (  str.equals(fin) ) {
					output.writeUTF(str);
					System.out.println(" -- Conversation Over from Server -- ");
					break;
				}
				
				output.writeUTF(str);
			} catch(IOException i) { System.out.println(i);   }
			//n--;
		}
		
		try {
			socket.close();
			serversocket.close();
			input.close();
			input_here.close();
			output.close();
		}catch(IOException i) {System.out.println(i); }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerClass server = new ServerClass(2432);
	}

}
