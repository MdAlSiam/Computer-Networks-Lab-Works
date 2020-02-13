package MyPackage_Lab_02;

import java.net.*;
import java.io.*;

public class ClientClass {
	
	private Socket socket = null;
	private DataInputStream input = null; 
	private DataInputStream input_got = null;
	private DataOutputStream output = null;
	
	public ClientClass(String address, int port) {
		
		try {	
		
			socket = new Socket(address, port);
			System.out.println("Connected to " + address + " via port " + port);
			
			input = new DataInputStream(System.in);
			input_got = new  DataInputStream(new BufferedInputStream(socket.getInputStream()));
			output = new DataOutputStream(socket.getOutputStream());
			
		}catch(UnknownHostException u){System.out.println(u);}
		catch(IOException i) {System.out.println(i);}
			
		String str = "", fin = "over";
			
		//int n = 4;
			
		while(true) {
			try {
				str = input.readLine();
				
				if (  str.equals(fin) ) {
					output.writeUTF(str);
					System.out.println(" -- Conversation Over from Client -- ");
					break;
				}
				
				output.writeUTF(str);
			}catch(IOException i) {System.out.println(i);}
			try {
				str = input_got.readUTF();
				
				if (  str.equals(fin) ) {
					System.out.println(" -- Conversation Over from Client -- ");
					break;
				}
				
				System.out.println(str);
			}catch(IOException i) {System.out.println(i);}
			//n--;
		}
		
		try {
			input.close();
			output.close();
			input_got.close();
			socket.close();
		}catch(IOException i) {System.out.println(i);}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ObjectClass myobject = new ObjectClass();
		ClientClass client = new ClientClass("127.0.0.1", 2432);
	}

}

