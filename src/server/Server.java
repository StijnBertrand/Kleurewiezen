package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	private final ServerSocket serverSocket;

	public Server(int port) throws IOException{
		InetSocketAddress serverAddress = new InetSocketAddress(port);
		this.serverSocket = new ServerSocket();
		serverSocket.bind(serverAddress);
	}
	/**
	 * Block and wait until a client arrives.
	 *
	 * Once a client arrives, start up a new Session Thread
	 * that handles further communication with this client,
	 * and returns immediately.
	 *
	 * @throws IOException when unable to listen on the specified port.
	 */
	public void acceptClient() throws IOException {
		Socket clientSocket = serverSocket.accept(); // blocks
		Player player = new Player(clientSocket);
		System.out.println("Server: client connected");
		player.start(); // starts a new thread
		// return immediately
	}
	private static class Player extends Thread {
		private final Socket clientSocket;
		private static PrintWriter output;
		private static BufferedReader input;
		private boolean gedaan = false;
		public Player(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}
		/**
		 * Handles communication with a single client.
		 *
		 * Listen for client requests and send back echoed replies.
		 *
		 * Client and server sockets communicate via input and output streams,
		 * as shown schematically below:
		 *
		 * <pre>
		 * Client Server
		 * cs = new Socket(addr,port) ss = socket.accept()
		 * cs.in <-------------------------- ss.out
		 * cs.out -------------------------> ss.in
		 * </pre>
		 */
		public void run() {
			try {
				// get raw input and output streams
				InputStream rawInput = this.clientSocket.getInputStream();
				OutputStream rawOutput = this.clientSocket.getOutputStream();
				// wrap streams in Readers and Writers to read and write
				// text Strings rather than individual bytes
				this.input = new BufferedReader(
						new InputStreamReader(rawInput));
				this.output = new PrintWriter(rawOutput);
//				if(!game.addPlayer(output)){
//					output.println("4");
//					output.close();
//					return;
//				}
//				String reply;
//				while(!game.dead){
//					while(!input.ready());
//					reply = input.readLine();
//					dispatch( Integer.parseInt( reply ));
//				}
			} catch (IOException e) {
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
			} finally {
				// tear down communication
				System.err.println("Server: closing client connection");
				try {
					this.clientSocket.close();
				} catch (IOException e) { /* ignore */ }
			}
		}
		
		private static void dispatch(int i) throws IOException, InterruptedException{
			int x,y;
			switch (i){
			case 1:
				while(!input.ready());
				x = Integer.parseInt(input.readLine());
				while(!input.ready());
				y = Integer.parseInt(input.readLine());
				break;
			case 2:
				while(!input.ready());
				x = Integer.parseInt(input.readLine());
				while(!input.ready());
				y = Integer.parseInt(input.readLine());
				break;
			}
		}
	}
	static public void main( String args[] ) throws InterruptedException, IOException {
		Server host = new Server(5002);
		for(;;){
			host.acceptClient();
		}
	}
}