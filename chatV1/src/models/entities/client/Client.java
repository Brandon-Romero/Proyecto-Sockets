package models.entities.client;

import java.net.*;
import java.util.Scanner;

import models.IGame;

import java.io.*;

public class Client implements IGame {

    private Socket socket;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    Scanner teclado = new Scanner(System.in);
    final String COMANDO_TERMINACION = "salir()";
    private String optionFrame = "CLIENT";

    public void levantarConexion(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            showText("Conectado a :" + socket.getInetAddress().getHostName());
        } catch (Exception e) {
            showText("Excepci�n al levantar conexi�n: " + e.getMessage());
            System.exit(0);
        }
    }

    public static void showText(String s) {
        System.out.println(s);
    }

    public void abrirFlujos() {
        try {
            bufferDeEntrada = new DataInputStream(socket.getInputStream());
            bufferDeSalida = new DataOutputStream(socket.getOutputStream());
            bufferDeSalida.flush();
        } catch (IOException e) {
            showText("Error en la apertura de flujos");
        }
    }

    public void writeMessage(String s) {
        try {
            bufferDeSalida.writeUTF(s);
            bufferDeSalida.flush();
        } catch (IOException e) {
            showText("IOException on enviar");
        }
    }

    public void closeConnection() {
        try {
            bufferDeEntrada.close();
            bufferDeSalida.close();
            socket.close();
            showText("Conexi�n terminada");
        } catch (IOException e) {
            showText("IOException on cerrarConexion()");
        } finally {
            System.exit(0);
        }
    }

    public void runConnection(String ip, int port) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    levantarConexion(ip, port);
                    abrirFlujos();
                    readData();
                } finally {
                    closeConnection();
                }
            }
        });
        hilo.start();
    }

    public void readData() {
        String st = "";
        try {
            do {
                st = (String) bufferDeEntrada.readUTF();
                showText("\n[Servidor] => " + st);
                System.out.print("\n[Cliente] => ");
            } while (!st.equals(COMANDO_TERMINACION));
        } catch (IOException e) {
        }
    }

    public void writeDatas() {
        String message = "";
        while (true) {
            System.out.print("[Cliente] => ");
            message = teclado.nextLine();
            if (message.length() > 0)
                writeMessage(message);
        }
    }

    public static void main(String[] args) {
        Client cliente = new Client();
        Scanner escaner = new Scanner(System.in);
        showText("Ingresa la IP: [localhost por defecto] ");
        String ip = escaner.nextLine();
        if (ip.length() <= 0)
            ip = "localhost";

        showText("Puerto: [5050 por defecto] ");
        String port = escaner.nextLine();
        if (port.length() <= 0)
            port = "5050";
        cliente.runConnection(ip, Integer.parseInt(port));
        cliente.writeDatas();
    }

    @Override
    public String getIp() throws UnknownHostException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getTittLeClient() {
        return optionFrame;
    }

    @Override
    public String getTittLeServer() {
        return null;
    }

}
