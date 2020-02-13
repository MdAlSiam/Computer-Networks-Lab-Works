package MyLab04Pack;

import java.net.*;
import java.io.*;

public class Lab04_Client{
	
	private Socket socket = null;
	private ObjectInputStream objectinputstream = null;
	private ObjectOutputStream objectoutputstream = null;
	
	public Lab04_Client(String address, int port) throws IOException, ClassNotFoundException{
		socket = new Socket(address, port);
		System.out.println("Pre: Connected to " + address + " via port " + port);
		objectoutputstream = new ObjectOutputStream(socket.getOutputStream());
		//System.out.println("Post: Connected to " + address + " via port " + port);
		Lab04_Object objectatclient4 = new Lab04_Object(12, "This is message from client", 1234);
		objectoutputstream.writeObject(objectatclient4);
		System.out.println("An object sent from client");
		socket.close();
		objectoutputstream.close();
	}
	
	public static void main (String[] args) throws IOException, ClassNotFoundException{
		Lab04_Client client = new Lab04_Client("127.0.0.1", 5000);
	}
}
