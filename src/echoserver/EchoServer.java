package echoserver;
import java.net.*;
import java.io.*;

public class EchoServer {
	public static void main(String[] args) {
		try {
			ServerSocket sock = new ServerSocket(6013);

			while (true) {
				System.out.println("Got a request!");
				Socket client = sock.accept(); // waiting for a response from a client
				
				//gets both the input and output stream of the socket
				InputStream input = client.getInputStream();
				OutputStream output = client.getOutputStream();
				byte[] toWrite = new byte[1];
				
				//takes the byte that the client wrote and writes it back for the client to print
				while(input.read(toWrite) != -1){
					output.write(toWrite);
				}
				
				input.close();
				output.close();
				client.close();
			}
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}
