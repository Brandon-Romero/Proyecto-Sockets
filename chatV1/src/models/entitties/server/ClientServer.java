package models.entitties.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServer extends Thread{
	

	private Socket socket;
	private DataInputStream bufferDeEntrada = null;
	private DataOutputStream bufferDeSalida = null;
	final String COMANDO_TERMINACION = "salir";
	
	public ClientServer(Socket socket2) {
		this.socket = socket2;
	}

	public String getSocketIp() {
		return socket.getInetAddress().getHostName();
		
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
	
	public static void showText(String text) {
		System.out.print(text);
	}
	
	@Override
	public void run() {

		while (true) {
			try {
				flujos();
				catchDatas();
			} finally {
				closeConnection();
			}
		}
	}

}
