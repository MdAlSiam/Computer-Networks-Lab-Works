package Packageofme;

import java.net.*;
import java.io.*;

public class ServerClass_Lab03 {
	
	private Socket socket = null;
	private ServerSocket serversocket = null;
	private ObjectInputStream objectinputstream = null;
	private ObjectOutputStream objectoutputstream = null;
	
	public ServerClass_Lab03(int port) throws IOException, ClassNotFoundException, NullPointerException{
		serversocket = new ServerSocket(port);
		System.out.println("Server Started, Waiting for client");
		socket = serversocket.accept();
		System.out.println("Client Accepted");
		objectinputstream = new ObjectInputStream(socket.getInputStream());
		//objectoutputstream = new ObjectOutputStream(socket.getOutputStream());
		ObjectClass objectatserver = (ObjectClass) objectinputstream.readObject();
		System.out.println("An object received from client");
		SeeObject(objectatserver);
		//ObjectClass objectatserver2 = new ObjectClass(999, "From Server");
		//objectoutputstream.writeObject(objectatserver2);
		//System.out.println("An object sent from server");
		serversocket.close();
		socket.close();
		objectinputstream.close();
		//objectoutputstream.close();
		
	}
	
	private void SeeObject(ObjectClass obj) {
		int nn = obj.getnum();
		String ss = obj.getstring();
		System.out.println("This is server.\nClient sent the object: " + nn +  " " + ss);
	}
	
	public static void main (String[] args) throws IOException, ClassNotFoundException, NullPointerException{
		ServerClass_Lab03 server = new ServerClass_Lab03(5000);
	}

}
