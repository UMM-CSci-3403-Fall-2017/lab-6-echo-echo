package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 6013);
			OutputStream output = socket.getOutputStream();
			int toWrite;
			
			while((toWrite = System.in.read()) != -1){
				System.out.println("enter something");
				output.write(toWrite);
			}
			
			int toPrint;
			InputStream input = socket.getInputStream();
			while((toPrint = input.read()) != -1){
				System.out.println(toPrint);
			}
			
			input.close();
			output.close();
			socket.close();
		} catch (IOException ioe) {
			System.out.println("We caught an exception");
			System.err.println(ioe);
		}
	}
}