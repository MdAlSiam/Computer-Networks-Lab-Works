package Packageofme;

import java.net.*;
import java.io.*;

public class ClientClass_Lab03 {
	
	private Socket socket = null;
	private ObjectInputStream objectinputstream = null;
	private ObjectOutputStream objectoutputstream = null;
	
	public ClientClass_Lab03(String address, int port) throws IOException, ClassNotFoundException{
		socket = new Socket(address, port);
		System.out.println("Pre: Connected to " + address + " via port " + port);
		//objectinputstream = new ObjectInputStream(socket.getInputStream());
		objectoutputstream = new ObjectOutputStream(socket.getOutputStream());
		System.out.println("Post: Connected to " + address + " via port " + port);
		ObjectClass objectatclient = new ObjectClass(12, "This is message from client\n");
		objectoutputstream.writeObject(objectatclient);
		System.out.println("An object sent from client");
		//ObjectClass objectfromserver = (ObjectClass) objectinputstream.readObject();
		//System.out.println("An object received from server");
		//SeeObject(objectfromserver);
		socket.close();
		//objectinputstream.close();
		objectoutputstream.close();
	}
	
//	private void SeeObject(ObjectClass obj) {
//		int nn = obj.getnum();
//		String ss = obj.getstring();
//		System.out.println("This is client.\nServer returned the object: " + nn + " " + ss);
//	}

	public static void main (String[] args) throws IOException, ClassNotFoundException{
		ClientClass_Lab03 client = new ClientClass_Lab03("127.0.0.1", 5000);
	}
}
