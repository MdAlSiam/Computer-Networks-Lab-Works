package L5P;

import java.net.*;
import java.util.ArrayList;

import java.io.*;

public class Lab05_Client{
	
	private Socket socket = null;
	private ObjectInputStream objectinputstream = null;
	private ObjectOutputStream objectoutputstream = null;
	
	public Lab05_Client(String address, int port) throws IOException, ClassNotFoundException, NullPointerException, SocketException{
		socket = new Socket(address, port);
		System.out.println("Pre: Connected to " + address + " via port " + port);
		objectoutputstream = new ObjectOutputStream(socket.getOutputStream());
		objectinputstream = new ObjectInputStream(socket.getInputStream());
		//System.out.println("Post: Connected to " + address + " via port " + port);
		
		//list<Lab05_Object> li = new ArraList<>();
		ArrayList<Lab05_Object> ara = new ArrayList<Lab05_Object>(11);
		Lab05_Object objectatclient4 = new Lab05_Object(1, "This is message 01 from client", 1234);
		ara.add(objectatclient4);
		objectatclient4 = new Lab05_Object(2, "This is message 02 from client", 1234);
		ara.add(objectatclient4);
		objectatclient4 = new Lab05_Object(3, "This is message 03 from client", 1234);
		ara.add(objectatclient4);
		
		int times = 3, index = 0;
		
		while(times > 0) {
			times--;
			objectoutputstream.writeObject(ara.get(index));
			
			System.out.println("An object sent from client");
			
			Lab05_Object objectgot = (Lab05_Object) objectinputstream.readObject();
			System.out.println("An object received from server");
			
			String jj = objectgot.getack();
			System.out.println("Status: " + jj);
			
			String ff = "got";
			
			if((ff.equals(jj))) {
				System.out.println("Server confirmed reception");
			}
			else {
				System.out.println("Server encountered error");
			}
			//String okstr = "got";
			//if(objectgot.ack == okstr) System.out.println("Client confirmed reception");
			index++;
		}	
		
		socket.close();
		objectoutputstream.close();
	}
	
	public static void main (String[] args) throws IOException, ClassNotFoundException, NullPointerException, SocketException{
		Lab05_Client client = new Lab05_Client("127.0.0.1", 5000);
	}
}
