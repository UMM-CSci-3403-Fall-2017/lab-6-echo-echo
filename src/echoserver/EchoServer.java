package echoserver;
import java.net.*;
import java.io.*;

public class EchoServer {
	public static void main(String[] args) {
		try {
			ServerSocket sock = new ServerSocket(6013);

			while (true) {
				System.out.println("Got a request!");
				Socket client = sock.accept();
				InputStream input = client.getInputStream();
				OutputStream output = client.getOutputStream();
				byte[] toWrite = new byte[1];
				
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
