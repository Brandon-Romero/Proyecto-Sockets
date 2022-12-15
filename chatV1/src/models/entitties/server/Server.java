package models.entitties.server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import models.IGame;

public class Server implements IGame {

	private Socket socket;
	private int port = 5050;
	
	private ArrayList<ClientServer> clients;
	private ServerSocket serverSocket;
	
	private DataInputStream bufferDeEntrada = null;
	private DataOutputStream bufferDeSalida = null;
	
	Scanner escaner = new Scanner(System.in);
	final String COMANDO_TERMINACION = "salir";
	private String optionFrame = "SERVER";
	
	public Server() {
		this.clients = new ArrayList<ClientServer>();
	}

	public void upConnection() {
		try {
			serverSocket = new ServerSocket(port);
			showText("Esperando conexion entrante en el puerto " + String.valueOf(port) + "...");
			acceptClient();

		} catch (Exception e) {
			e.printStackTrace();
			showText("Error en levantarConexion(): " + e.getMessage());
			System.exit(0);
		}
	}
	
	public void acceptClient() {
		while (true) {
			try {
				System.out.println("esperando cliente");
				
				socket = serverSocket.accept();
				lisntenClient(socket);
				showText("Conexion establecida con: " + socket.getInetAddress().getHostName() + "\n\n\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void lisntenClient(Socket socket2) {
		ClientServer clientServer = new ClientServer(socket2);
		clientServer.start();
		clients.add(clientServer);
	}

	@Override
	public String getIp() throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		return ip.getHostAddress();
	}


	public void flujos() {
		try {
			bufferDeEntrada = new DataInputStream(socket.getInputStream());
			bufferDeSalida = new DataOutputStream(socket.getOutputStream());
			bufferDeSalida.flush();
		} catch (IOException e) {
			showText("Error en la apertura de flujos");
		}
	}

	public void catchDatas() {
		String st = "";
		try {
			do {
				st = (String) bufferDeEntrada.readUTF();
				showText("\n[Cliente] => " + st);
				System.out.print("\n[Usted] => ");
			} while (!st.equals(COMANDO_TERMINACION));
		} catch (IOException e) {
			closeConnection();
		}
	}

	public void sedEspicificClient(String ip) {
		while (true) {
			try {
				String message = bufferDeEntrada.readUTF();
				
				for (ClientServer clientSocket : clients) {
					if (ip.equals(clientSocket.getSocketIp())) {

						bufferDeSalida.writeUTF(message);
					};
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public void send(String s) {
		try {
			bufferDeSalida.writeUTF(s);
			bufferDeSalida.flush();
		} catch (IOException e) {
			showText("Error en enviar(): " + e.getMessage());
		}
	}

	public static void showText(String text) {
		System.out.print(text);
	}

	public void writeDatas() {
		while (true) {
			for (ClientServer clientServer : clients) {

				System.out.print("[Usted] => ");
				send(escaner.nextLine());
			}
		}
	}

	public void closeConnection() {
		try {
			bufferDeEntrada.close();
			bufferDeSalida.close();
			socket.close();
		} catch (IOException e) {
			showText("Excepci�n en cerrarConexion(): " + e.getMessage());
		} finally {
			showText("Conversaci�n finalizada....");
			System.exit(0);

		}
	}


	public void runnerConnectionThreads(int port) {
		Thread hilo = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						upConnection();
						acceptClient();
						flujos();
						catchDatas();
					} finally {
						closeConnection();
					}
				}
				
			}
		});
		hilo.start();
		
	}

	
	public static void main(String[] args) {
		Server s = new Server();
		Scanner sc = new Scanner(System.in);

		showText("Ingresa el puerto [5050 por defecto]: ");
		String port = sc.nextLine();
		if (port.length() <= 0)
			port = "5050";
		s.runnerConnectionThreads( Integer.parseInt(port));
		s.writeDatas();
		//String ipClient = sc.nextLine();
		//s.sedEspicificClient(ipClient);

	}
	  
	 

	@Override
	public String getTittLeClient() {
		return null;
	}

	@Override
	public String getTittLeServer() {
		return optionFrame;
	}

}
