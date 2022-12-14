package models.entitties.server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import models.IGame;


public class Server implements IGame{

	private Socket socket;
	private ArrayList<Thread> threadClient;
	private ServerSocket serverSocket;
	private DataInputStream bufferDeEntrada = null;
	private DataOutputStream bufferDeSalida = null;
	Scanner escaner = new Scanner(System.in);
	final String COMANDO_TERMINACION = "salir";
	
	public void Sever() {
		this.threadClient = new ArrayList<Thread>();
	}

	public void upConnection(int port) {
		try {
			serverSocket = new ServerSocket(port);
			showText("Esperando conexi�n entrante en el puerto " + String.valueOf(port) + "...");
			acceptClient();
			
		} catch (Exception e) {
			showText("Error en levantarConexion(): " + e.getMessage());
			System.exit(0);
		}
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
			System.out.print("[Usted] => ");
			send(escaner.nextLine());
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
		while (true) {
			try {
				upConnection(port);
				acceptClient();
				flujos();
				catchDatas();
			} finally { 
				closeConnection();
			}
		}
	}
	
	public void acceptClient() {
		while (true) {
			try {
				System.out.println("esperando cliente");
				socket = serverSocket.accept();
				lisntenClient(socket);
				showText("Conexi�n establecida con: " + socket.getInetAddress().getHostName() + "\n\n\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void lisntenClient(Socket socket2) {

		ClientServer clientServer = new ClientServer(socket2);
		clientServer.start();
	}
	
	public static void main(String[] args) {
		Server s = new Server();
		Scanner sc = new Scanner(System.in);
		
		showText("Ingresa el puerto [5050 por defecto]: ");
		String port = sc.nextLine();
		if (port.length() <= 0)
			port = "5050";
		s.runnerConnectionThreads(Integer.parseInt(port));
		
	}

	@Override
	public String getIp() {
		String ip = socket.getInetAddress().getHostName();
		return ip;
	}
}
