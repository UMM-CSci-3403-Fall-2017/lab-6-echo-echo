package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 6013);
			DataInputStream in = new DataInputStream(System.in);
			OutputStream output = socket.getOutputStream();
			InputStream input = socket.getInputStream();
			byte[] toWrite = new byte[1];
			
			while(in.read(toWrite) != -1){
				output.write(toWrite);
				
				byte[] toPrint = new byte[1];
				input.read(toPrint);
				System.out.write(toPrint, 0, 1);
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
